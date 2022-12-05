package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.FormInserisci;;

public class InsertInDB extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		System.out.println("Sono in action inserisci");
		
		FormInserisci hwForm = (FormInserisci) form;
		
		String cognome 	= hwForm.getCognome();
		String nome 	= hwForm.getNome();
		String tel1		= hwForm.getTelefono1();
		String rag_soc 	= hwForm.getRag_soc();
		String sesso 	= hwForm.getSesso();
		String tel2		= hwForm.getTelefono2();
		String indirizzo= hwForm.getIndirizzo();
		String citta	= hwForm.getCitta();
		String data_na	= hwForm.getData_nascita();
		String luogo_na = hwForm.getLuogo_nascita();
		String num_cc	= hwForm.getNum_cc();
		String codicef	= hwForm.getCodice_fiscale();
		String p_iva	= hwForm.getP_iva();
		String email	= hwForm.getEmail();
		System.out.println("il codice fiscale è" + codicef);
		String serverName 	= "10.153.120.35";
		String portNumber 	= "3308";
		String sid 			= "corsodb004";
		String userName 	= "corsodb004";
		String passwordDB 	= "ciaociao";
		
		Connection con;
		String prova = request.getParameter("cf");
		System.out.println("il codice prova è"+prova);
		try {
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
	
			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
	
			con = DriverManager.getConnection(url, userName, passwordDB);
			System.out.println(citta);
			String query = "SELECT id_comune FROM Comuni WHERE descrizione='" + citta + "';";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			String id_citta = rs.getString(1);
			System.out.println("2");
			//recupero ed incremento (o creo) l'id utente
			query = "SELECT MAX(cod_anag) FROM Anagrafica;";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			rs.next();
			int cod_anag = 1000000000;
			if(rs.getString(1) != null) {
				cod_anag = Integer.parseInt(rs.getString(1)) + 1;
			}
			System.out.println("3");
			//creare un conto associato a questo cod anag
			System.out.println(codicef);
			query = "INSERT INTO Anagrafica"
					+ "(cod_anag, cognome, nome, rag_soc, indirizzo, id_comune, sesso, data_nascita, luogo_nascita, cod_fiscale, partita_iva, telefono1, telefono2, email) "
					+ "VALUES "
					+ "('"+cod_anag	+"', "
					+ "'"+cognome	+"', "
					+ "'"+nome		+"', "
					+ "'"+rag_soc	+"', "
					+ "'"+indirizzo	+"', "
					+ "'"+id_citta	+"', "
					+ "'"+sesso		+"', "
					+ "'"+data_na	+"', "
					+ "'"+luogo_na	+"', "
					+ "'"+prova		+"', "
					+ "'"+p_iva		+"', "
					+ "'"+tel1		+"', "
					+ "'"+tel2		+"', "
					+ "'"+email	+"');";
			
			System.out.println(query);
			
			st = con.createStatement();
			st.executeUpdate(query);

			query =  "INSERT INTO `Conticorrenti`(`iso`, `num_controllo`, `cin`, `abi`, `cab`, `cod_cc`, `cod_anag_cc`, `importo_saldo`, `importo_fido`) VALUES('no', '00', 'L', '00000', '10001', '"+ num_cc +"', '"+ cod_anag +"', '00', '00')";
			System.out.println(query);
			st = con.createStatement();
			st.executeUpdate(query);
			
			hwForm.setErrore("Utente inserito correttamente!");
			
			hwForm.setCognome("");
			hwForm.setNome("");
			hwForm.setRag_soc("");
			hwForm.setIndirizzo("");
			hwForm.setSesso("");
			hwForm.setCitta("");
			hwForm.setData_nascita("");
			hwForm.setLuogo_nascita("");
			hwForm.setCodice_fiscale("");
			hwForm.setP_iva("");
			hwForm.setTelefono1("");
			hwForm.setTelefono2("");
			hwForm.setEmail("");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
//			hwForm.setErrore("Eccezione: " + e);
		}
		
		request.getSession().setAttribute("myInsert", hwForm);
		return mapping.findForward("success");
	}
}
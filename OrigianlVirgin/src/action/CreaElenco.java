package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.Persona;
import Bean.Persone;

public class CreaElenco extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		Persone persone = (Persone) form;
		List list = new ArrayList<>();
		
		String serverName 	= "10.153.120.35";
		String portNumber 	= "3308";
		String sid 			= "corsodb004";
		String userName 	= "corsodb004";
		String passwordDB 	= "ciaociao";

		Connection con;
		System.out.println("prima del try"); 
		int count = 0;
		try {
			
			//carica il file di classe del driver per il collegamento  al database con il ponte Odbc
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;

			//apri la connessione con il database
			con = DriverManager.getConnection(url, userName, passwordDB);
					
			String query = "SELECT * FROM Anagrafica  ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			
			while(rs.next()) {
				query = "SELECT cod_cc FROM Conticorrenti WHERE cod_anag_cc = '" + rs.getString(1) + "'";
				st = con.createStatement();
				System.out.println(query);
				ResultSet rs2 = st.executeQuery(query);
				System.out.println(rs2);
				System.out.println("dopo la select conti");
				rs2.next();
				String num_cc = rs2.getString(1);
				
				query 	= "SELECT descrizione FROM Comuni WHERE id_comune = '" + rs.getString(6) + "'";
				st 		= con.createStatement();
				rs2 	= st.executeQuery(query);
				System.out.println("dopo la select comuni");
				rs2.next();
				String citta = rs2.getString(1);
				list.add(creaPersona(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), num_cc, citta));
				System.out.println("dopo la list.add crea persone");
				persone.setIdsel(0);
				System.out.println(count);
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		persone.setElencoPersone(list);
		System.out.println(persone.toString());
		return mapping.findForward("success");
	}
	
	public Persona creaPersona(	int cod_anag, String cognome, String nome, String rag_soc, String indirizzo, String	id_comune,
								String sesso, String data_nascita, String luogo_nascita, String cod_fiscale, String	partita_iva,
								String telefono1, String telefono2, String email, String num_cc, String citta) {
		
		Persona persona = new Persona();
		persona.setCod_anag(cod_anag);
		persona.setCognome(cognome);
		persona.setNome(nome);
		persona.setRag_soc(rag_soc);
		persona.setIndirizzo(indirizzo);
		persona.setId_comune(id_comune);
		persona.setSesso(sesso);
		persona.setData_nascita(data_nascita);
		persona.setLuogo_nascita(luogo_nascita);
		persona.setCod_fiscale(cod_fiscale);
		persona.setPartita_iva(partita_iva);
		persona.setTelefono1(telefono1);
		persona.setTelefono2(telefono2);
		persona.setEmail(email);
		persona.setNum_cc(num_cc);
		persona.setCitta(citta);
		
		return persona;
	}
}

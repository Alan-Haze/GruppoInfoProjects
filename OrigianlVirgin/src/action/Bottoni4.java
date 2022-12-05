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

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class Bottoni4 extends org.apache.struts.actions.DispatchAction  {

	String serverName 	= "10.153.120.35";
	String portNumber 	= "3308";
	String sid 			= "corsodb004";
	String userName 	= "corsodb004";
	String passwordDB 	= "ciaociao";
	
	
	Connection con = null;
	
	public ActionForward elimina(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(request.getMethod());
		System.out.println("Sono in action elimina ");
		String cfElimina = request.getParameter("cod_anag");
		String ccElimina = request.getParameter("num_cc");
		System.out.println(cfElimina);
		System.out.println("il num_cc è "+ccElimina);
		String value = (String) request.getParameter("num_cc");  	
		System.out.println(value);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
			con = DriverManager.getConnection(url, userName, passwordDB);
			
			String query = "DELETE FROM `Anagrafica` WHERE cod_anag = '" + cfElimina + "' ";
			String query2 = "DELETE FROM `Conticorrenti` WHERE cod_cc = '" + ccElimina + "' ";
			
			Statement st = con.createStatement();
			st.executeUpdate(query2);
			st.executeUpdate(query);
			
			System.out.println(query);
			System.out.println(query2);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mapping.findForward("success");
	}

	public ActionForward salva(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Sono in action salva ");
		String codanag= request.getParameter("cod_anag");
		String cognome = request.getParameter("cognome");
		String nome = request.getParameter("nome");
		String tel1 = request.getParameter("telefono1");
		String ragsoc = request.getParameter("rag_soc");
		String sesso = request.getParameter("sessoskrt");
		String tel2 = request.getParameter("telefono2");
		String indirizzo = request.getParameter("indirizzo");
		String dnascita = request.getParameter("data_nascita");
		String lnascita = request.getParameter("luogo_nascita");
		String cf = request.getParameter("cf");
		String email = request.getParameter("email");
		String idcomune = request.getParameter("cittaID");
//		System.out.println(codanag);
//		System.out.println(cognome);
//		System.out.println(nome);
//		System.out.println(tel1);
//		System.out.println(ragsoc);
		int idcomunenumber = Integer.parseInt(idcomune);
		
		System.out.println(sesso);
		System.out.println(idcomunenumber);
		
//		System.out.println(tel2);
//		System.out.println(indirizzo);
//		System.out.println(dnascita);
//		System.out.println(lnascita);
//		System.out.println(cf);
//		System.out.println(email);
//		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
			con = DriverManager.getConnection(url, userName, passwordDB);
			
			String query = "UPDATE `Anagrafica` SET `cognome`='" + cognome + "',`nome`='" + nome + "',`rag_soc`='" + ragsoc + "',`indirizzo`='" + indirizzo + "',`data_nascita`='" + dnascita+ "',`luogo_nascita`='" + lnascita + "',`cod_fiscale`='" + cf + "',`telefono1`='" + tel1 + "',`telefono2`='" + tel2 + "',`email`='" + email + "',`sesso`='"+sesso+"',`id_comune`='"+idcomunenumber+"' WHERE `cod_anag`='" + codanag + "'";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			System.out.println(query);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("success");
	}
}

package action;
import java.sql.*;


import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.UserPasswordLogin;

public class CheckLogin extends Action {

@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception {
	
	UserPasswordLogin hwForm = (UserPasswordLogin) form;
	
	String username = hwForm.getUsername();
	String password = hwForm.getPassword();
	
	String serverName 	= "10.153.120.35";
	String portNumber 	= "3308";
	String sid 			= "corsodb004";
	String userName 	= "corsodb004";
	String passwordDB 	= "ciaociao";

	Connection con = null;
	
	try {
		//carica il file di classe del driver per il collegamento  al database con il ponte Odbc
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;

		//apri la connessione con il database
		con =  DriverManager.getConnection(url, userName, passwordDB);
				
		String query = "SELECT * FROM UtentiAdmin WHERE user='" + username + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println("siamo dentro al try");
		
		if(rs.next()) {
			query 	= "SELECT password FROM UtentiAdmin WHERE user='" + username + "';";
			st		= con.createStatement();
			rs		= st.executeQuery(query);
			System.out.println("siamo dentro al try");
			rs.next();

			if(password.equals(rs.getString(1))) {
				return mapping.findForward("success");
			}else {
				hwForm.setErrore("Password errata");
			}
		}else {
			hwForm.setErrore("Utente non registrato");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(con != null)
			con.close();
	}
	request.setAttribute("utente", hwForm);
	return mapping.findForward("failure");
}
}



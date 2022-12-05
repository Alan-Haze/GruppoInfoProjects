package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.FormInserisci;

public class CreaCampiInserisci extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		FormInserisci hwForm = (FormInserisci) form;
		
		System.out.println("Sono in action chiama inserisci");
		
		String serverName 	= "10.153.120.35";
		String portNumber 	= "3308";
		String sid 			= "corsodb004";
		String userName 	= "corsodb004";
		String passwordDB 	= "ciaociao";

		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
			con = DriverManager.getConnection(url, userName, passwordDB);
					
			String query = "SELECT * FROM Comuni;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);	
			ArrayList<String> elencoCitta = new ArrayList<>();
		
			while(rs.next()) {
				elencoCitta.add(rs.getString(2));
			}
			
			hwForm.setElencoCitta(elencoCitta);
			System.out.println(elencoCitta);
			query 	= "SELECT MAX(cod_cc) FROM Conticorrenti;";
			st 		= con.createStatement();
			rs		= st.executeQuery(query);
			
			long num_cc = 100000000000L;
			rs.next();
			if(rs.getString(1) != null) 
				num_cc = Long.parseLong(rs.getString(1))+1;
			
			hwForm.setNum_cc("" + num_cc);
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("myInsert", hwForm);
		return mapping.findForward("success");
	}
}

package Lezione11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Movimenti {

	public static void Read(Connection con) throws IOException, SQLException {
		String riga = "";
		String query = "";
	
		BufferedReader br = new BufferedReader(new FileReader("out/esercizio 11/Movimenti.txt"));
		Statement st			= con.createStatement();
		
		Statement s = con.createStatement();
		int ris = s.executeUpdate("drop table Movimenti");
		System.out.println("tabella eliminata");
		con.commit();
		
		riga = br.readLine();
		while(!riga.equals("")) {
			query	+=	riga;
			riga	=	br.readLine(); 
		}
		
		try {
			st.execute(query);
			con.commit();
		}catch (SQLException e) {e.printStackTrace();}	
		
		
		st.executeUpdate("TRUNCATE TABLE Movimenti;");
		while((riga = br.readLine()) != null) {
			String update = riga;
			st.executeUpdate(update);
		}
		br.close();
	}

}

package Lezione10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Es10 {
	int Cod_anag;
	String Cognome;
	String Nome;
	String Rag_soc;
	String Indirizzo;
	String Città;
	String Sesso;
	String Data_nascita;
	String Luogo_nascita;
	String Partita_iva;
	String Telefono1;
	String Telefono2;

	public static void main(String[] args) throws IOException {

		String serverName = "10.153.120.35";
		String portNumber = "3308";
		String sid = "corsodb004";
		String userName = "corsodb004";
		String password = "ciaociao";

		try {
			Connessione oggcon = new Connessione(serverName, portNumber, sid, userName, password);
			Connection con = oggcon.connetti();
			con.setAutoCommit(false);		
			Create(con);
			Insert(con, "out/Esercizio 10/Anagrafica.txt");
			Stampa(con);
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void Stampa(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = con.createStatement();
		String query = "SELECT * FROM Anagrafica WHERE Città=\'TO\';";
		ResultSet c1 = st.executeQuery(query);
		while (c1.next()) {
			if (c1.getString(2).length() > 7)
				System.out.print(c1.getString(2) + "\t");
			else
				System.out.print(c1.getString(2) + "\t\t");
			if (c1.getString(3).length() > 7)
				System.out.print(c1.getString(3) + "\t");
			else
				System.out.print(c1.getString(3) + "\t\t");
			System.out.println(c1.getString(5));
		}c1.close();
	}
	private static void Insert(Connection con, String path) throws SQLException {
		String Riga = "";
		Statement st = con.createStatement();
		String truncate = "TRUNCATE TABLE Anagrafica;";
		st.executeUpdate(truncate);
		con.commit();
		try {
			Statement st1 = con.createStatement();
			java.sql.PreparedStatement comando = con.prepareStatement(
					"INSERT INTO Anagrafica(Cod_anag, Cognome, Nome, Rag_soc, Indirizzo, Città, Sesso, Data_nascita,Luogo_nascita, Partita_iva, Telefono1, Telefono2) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while ((Riga = br.readLine()) != null) {
				if (Riga.startsWith("ï»¿"))
					Riga = Riga.replace("ï»¿", "");
				String[] campo = Riga.split("-");
				String[] data = campo[7].split("/");
				campo[7] = data[2] + "/" + data[1] + "/" + data[0];
				System.out.println(Arrays.toString(campo));
				comando.setInt(1, Integer.parseInt(campo[0]));
				comando.setString(2, campo[1]);
				comando.setString(3, campo[2]);
				comando.setString(4, campo[3]);
				comando.setString(5, campo[4]);
				comando.setString(6, campo[5]);
				comando.setString(7, campo[6]);
				comando.setString(8, campo[7]);
				comando.setString(9, campo[8]);
				comando.setString(10, campo[9]);
				comando.setString(11, campo[10]);
				comando.setString(12, campo[11]);
				int res = comando.executeUpdate();
				System.out.println(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		con.commit();

	}

	private static void Create(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		Statement s = con.createStatement();
		int ris = s.executeUpdate("drop table Anagrafica");
		System.out.println("tabella eliminata");
		con.commit();
		Statement st = con.createStatement();
		String comando = "CREATE TABLE IF NOT EXISTS Anagrafica" + "(Cod_anag int(10) 			PRIMARY KEY, "
				+ "Cognome varchar(30) 			NOT NULL, " + "Nome varchar(30) 			NOT NULL, "
				+ "Rag_soc varchar(40) 			NOT NULL, " + "Indirizzo varchar(30) 		NOT NULL, "
				+ "Città varchar(20) 			NOT NULL, " + "Sesso varchar(01) 			NOT NULL, "
				+ "Data_nascita date 			NOT NULL, " + "Luogo_nascita varchar(20) 	NOT NULL, "
				+ "Partita_iva varchar(20)		NOT NULL, " + "Telefono1 varchar(30) 		NOT NULL, "
				+ "Telefono2 varchar(30) 		NOT NULL)";

		st.executeUpdate(comando);
		con.commit();
		System.out.println("tabella creata");
	}

}

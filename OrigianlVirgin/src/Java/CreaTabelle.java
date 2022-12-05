package Java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Java.Connessione;

public class CreaTabelle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void Create(Connection con) throws SQLException {

//		Statement s2 = con.createStatement();
//		int ris2 = s2.executeUpdate("drop table Agenzie");
//		System.out.println("tabella Agenzie eliminata");
//		Statement s = con.createStatement();
//		int ris = s.executeUpdate("drop table UtentiAdmin");
//		System.out.println("tabella UtentiAdmin eliminata ");
//		Statement s3 = con.createStatement();
//		int ris3 = s3.executeUpdate("drop table Comuni");
//		System.out.println("tabella comuni eliminata");
//		
//		Statement s4 = con.createStatement();
//		int ris4 = s4.executeUpdate("drop table Anagrafica");
//		System.out.println("tabella anagrafica eliminata");
		
		Statement s5 = con.createStatement();
		int ris5 = s5.executeUpdate("drop table Conticorrenti");
		System.out.println("tabella conticorrenti eliminata");
	
		con.commit();
		Statement st = con.createStatement();
//		String comando = "CREATE TABLE Agenzie(\r\n" + 
//				"cod_cab INTEGER(5) NOT NULL PRIMARY KEY,\r\n" + 
//				"nome VARCHAR(30) NOT NULL,\r\n" + 
//				"indirizzo VARCHAR(30) NOT NULL,\r\n" + 
//				"città VARCHAR(20) NOT NULL,\r\n" + 
//				"telefono VARCHAR(10) NOT NULL,\r\n" + 
//				"fax VARCHAR(10) NOT NULL\r\n" + 
//				")";
//		String comando2 = "CREATE TABLE UtentiAdmin(\r\n" + 
//				"cod_user INTEGER(7) NOT NULL PRIMARY KEY,\r\n" + 
//				"cognome VARCHAR(30) NOT NULL,\r\n" + 
//				"nome VARCHAR(30) NOT NULL,\r\n" + 
//				"n_matricola VARCHAR(10) NOT NULL,\r\n" + 
//				"user VARCHAR(7) NOT NULL,\r\n" + 
//				"password VARCHAR(7) NOT NULL,\r\n" + 
//				"data_scad date,\r\n" + 
//				"session_id VARCHAR(34) NOT NULL, \r\n" + 
//				"cod_cab INTEGER(5) NOT NULL,\r\n" + 
//				" FOREIGN KEY (cod_cab) REFERENCES Agenzie(cob_cab)\r\n" + 
//				")";
//		String comando3 = "CREATE TABLE Comuni(\r\n" + 
//				"id_comune INTEGER(7) NOT NULL PRIMARY KEY,\r\n" + 
//				"descrizione VARCHAR(10)\r\n" + 
//				")";
//		String comando4="CREATE TABLE Anagrafica(\r\n" + 
//				"cod_anag INTEGER(10) NOT NULL PRIMARY KEY,\r\n" + 
//				"cognome VARCHAR(30) NOT NULL ,\r\n" + 
//				"nome VARCHAR(30) NOT NULL, \r\n" + 
//				"rag_soc VARCHAR(30),\r\n" + 
//				"indirizzo  VARCHAR(30) NOT NULL  , \r\n" + 
//				"id_comune INTEGER(7),\r\n" + 
//				"sesso  VARCHAR(30) NOT NULL , \r\n" + 
//				"data_nascita DATE NOT NULL , \r\n" + 
//				"luogo_nascita VARCHAR(30) NOT NULL, \r\n" + 
//				"cod_fiscale VARCHAR(30),\r\n" + 
//				"partita_iva VARCHAR(30),\r\n" + 
//				"telefono1 VARCHAR(30)NOT NULL ,\r\n" + 
//				"telefono2 VARCHAR(30),\r\n" + 
//				"email VARCHAR(30),\r\n" + 
//				"FOREIGN KEY (id_comune) REFERENCES Comuni(id_comune)\r\n" + 
//				")";
		String comando5 ="CREATE TABLE Conticorrenti(\r\n" + 
				"iso VARCHAR(2) NOT NULL,\r\n" + 
				"num_controllo INTEGER(2) NOT NULL, \r\n" + 
				"cin  VARCHAR(1) NOT NULL,\r\n" + 
				"abi INTEGER(5) NOT NULL,\r\n" + 
				"cab INTEGER(5) NOT NULL,\r\n" + 
				"cod_cc INTEGER(30) NOT NULL PRIMARY KEY,\r\n" + 
				"cod_anag_cc INTEGER(10) NOT NULL,\r\n" + 
				"importo_saldo INTEGER(30) NOT NULL,\r\n" + 
				"importo_fido INTEGER(30) NOT NULL,\r\n" + 
				"FOREIGN KEY(cab) REFERENCES Agenzie (cod_cab),\r\n" + 
				"FOREIGN KEY(cod_anag_cc) REFERENCES Anagrafica(cod_anag)\r\n" + 
				"\r\n" + 
				")";

//		st.executeUpdate(comando);
//		st.executeUpdate(comando2);
//		st.executeUpdate(comando3);
//		st.executeUpdate(comando4);
		st.executeUpdate(comando5);
		con.commit();
		System.out.println("tabelle create");
	}
}


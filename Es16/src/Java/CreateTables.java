package Java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Java.Connessione;

public class CreateTables {

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
			// Insert(con, "out/Esercizio 10/Anagrafica.txt");
			// Stampa(con);
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void Create(Connection con) throws SQLException {

		Statement s = con.createStatement();
		int ris = s.executeUpdate("drop table TipiUser");
		System.out.println("tabella TipiUser eliminata ");
		Statement s2 = con.createStatement();
		int ris2 = s2.executeUpdate("drop table Utenti");
		System.out.println("tabella Utenti eliminata");
		con.commit();
		Statement st = con.createStatement();
		Statement st2 = con.createStatement();
		String comando = "CREATE TABLE Utenti  (idUser int(10) PRIMARY KEY,cognome varchar(30) NOT NULL,nome varchar(30) 			NOT NULL,nomeUser varchar(40) 		NOT NULL,uPassword varchar(30) 		NOT NULL,dataScadenza date 			NOT NULL,idTipoUser int(10),FOREIGN KEY (idTipoUser) REFERENCES TipiUser(tipoUser))";

		String comando2 = "CREATE TABLE TipiUser (tipoUser int(10) PRIMARY KEY, \r\n"
				+ "descrizione varchar(20) NOT NULL)";

		st2.executeUpdate(comando2);
		st.executeUpdate(comando);

		con.commit();
		System.out.println("tabelle create");
	}
}

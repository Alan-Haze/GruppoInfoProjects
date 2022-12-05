package Lezione13;

import java.sql.*;

public class Connessione {
	private String serverName = "";
	private String portNumber = "";
	private String sid = "";
	private String userName = "";
	private String password = "";
	
	public Connessione(String serverName, String portNumber, String sid, String userName, String password) {
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.sid = sid;
		this.userName = userName;
		this.password = password;
	}
	
public Connection connetti () throws ClassNotFoundException, SQLException {
		
		//carica il file di classe del driver per il collegamento  al database con il ponte Odbc
	Class.forName("com.mysql.jdbc.Driver");
	
	String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" +  sid;
		
		//apri la connessione con il database
		Connection con = DriverManager.getConnection(url,userName,password);
		System.out.println("\nConnect OK\n" + "*** url: " + url + " ***\n");
		return con;
	}
}

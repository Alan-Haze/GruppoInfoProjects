<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div><h1>CIAO BENVENUTO :) </h1></div>
	 <%@ page import="java.sql.*"%>
	<%
		String user = request.getParameter("utentiForm1");
		String serverName = "10.153.120.35";
		String portNumber = "3308";
		String sid = "corsodb004";
		String userName = "corsodb004";
		String passwordDB = "ciaociao";

		Connection con;
		try {
			//carica il file di classe del driver per il collegamento  al database con il ponte Odbc
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;

			//apri la connessione con il database
			con = DriverManager.getConnection(url, userName, passwordDB);

			String query = "DELETE FROM Utenti WHERE idUser = '" + user +"'";
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			con.close();
	%>
	<script> RecordEliminato(); </script>
	<%
		response.sendRedirect("tabella.jsp");
		} catch (Exception e) {
			out.write("" + e);
		}
	%> 
	 
</body>
</html>
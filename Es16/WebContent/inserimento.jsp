<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/inserisci.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	 <!-- <form  id='Inserisci'>
		<label class='intestazione2'>Inserimento utenti</label>

		<div class='riga'>
			<label>Cognome*</label> <input type='text' name='cognome' /> <label>Nome*</label>
			<input type='text' name='nome' />
		</div>

		<div class='riga'>
			<label>Nome user*</label> <input type='text' name='username' /> <label>Password*</label>
			<input type='text' name='password' />
		</div>

		<div class='riga'>
			<label>Data scad password*</label> <input type='text' name='scadenza'
				placeholder='gg/mm/aaaa' /> <label>Tipo*</label> <select id='tipo'
				name='tipo'>
				<option value='1'>Amministratore</option>
				<option value='2'>Commerciale</option>
				<option value='3'>Docente</option>
				<option value='4'>Corsista</option>
			</select>
		</div>

		<div class='bottoni2'>

			<input type='submit' id='salvaInsert' value='Salva' />
			<button>Annulla</button>
		</div>
	
	</form>  -->
	
	<%@ page import="java.sql.*"%>
	<%@ page import="java.time.LocalDateTime"%>
	<%@ page import="java.time.format.DateTimeFormatter"%>
	<%@ page import="java.util.regex.Matcher"%>
	<%@ page import="java.util.regex.Pattern"%>

	<%
		String cognome = request.getParameter("cognome");
		String nome = request.getParameter("nome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String scadenza = request.getParameter("scadenza");
		String tipo = request.getParameter("tipo");
		
		String serverName = "10.153.120.35";
		String portNumber = "3308";
		String sid = "corsodb004";
		String userName = "corsodb004";
		String passwordDB = "ciaociao";

		Connection con;
		int id = (int) (Math.random() * 100) + 100;
		System.out.println(request);
		try {
			System.out.println("siamo entrati nel try");
			//carica il file di classe del driver per il collegamento  al database con il ponte Odbc
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;

			//apri la connessione con il database
			con = DriverManager.getConnection(url, userName, passwordDB);
			System.out.println("1");
			String[] data = scadenza.split("/");
			System.out.println("2");
			scadenza = data[2] + "-" + data[1] + "-" + data[0];
					
					
			System.out.println("siamo entrati prima fdel query");
			String query = "INSERT INTO Utenti (idUser, cognome, nome, nomeUser, uPassword, dataScadenza, idTipoUser) "
					+ "VALUES ('" + id + "', '" + cognome + "', '" + nome + "', '" + username + "', '" + password
					+ "', '" + scadenza + "', '" + tipo + "');";
			System.out.println("siamo entrati prima fdel query");
					Statement st = con.createStatement();
			System.out.println(query);
			
			st.execute(query);
			con.close();
			response.sendRedirect("tabella.jsp");
			
		} catch (Exception e) {
			System.out.println(e);

		}
	%>
</body>
</html>
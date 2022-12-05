<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="css/modifica.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <div> 
<form class='formModifica'
		id='Modifica'>
		<label class='intestazione2'>IdUser</label> <input
			type='text' id='id' name='id' />
		<div class='riga'>
			<label>Cognome*</label> <input type='text' id='cognome'
				name='cognomeM' /> <label>Nome*</label> <input type='text'
				id='nome' name='nomeM' />
		</div>

		<div class='riga'>
			<label>Nome user*</label> <input type='text' id='username'
				name='usernameM' /> <label>Password*</label> <input type='text'
				id='password' name='passwordM' />
		</div>

		<div class='riga'>
			<label>Data scad password*</label> <input type='text' id='scadenza'
				name='scadenzaM' placeholder='gg/mm/aaaa' /> <label>Tipo*</label> <select
				id='tipoMod' name='tipoM'>
				<option value='1'>Amministratore</option>
				<option value='2'>Commerciale</option>
				<option value='3'>Docente</option>
				<option value='4'>Corsista</option>
			</select>
		</div>

		<div class='bottoni2'>

			</label> <input type='submit' value='Salva'
				onClick='return confirm('Confermi la modifica?');' />
			<button onClick='disattivaModifica();'>Annulla</button>
		</div>

	</form>
	</div> -->
	<%@ page import="java.sql.*"%>
	<%@ page import="java.time.LocalDateTime"%>
	<%@ page import="java.time.format.DateTimeFormatter"%>
	<%@ page import="java.util.regex.Matcher"%>
	<%@ page import="java.util.regex.Pattern"%>
	 <%
	 	String cognome = request.getParameter("cognomeM");
	 	String nome = request.getParameter("nomeM");
	 	String username = request.getParameter("usernameM");
	 	String password = request.getParameter("passwordM");
	 	String scadenza = request.getParameter("scadenzaM");
	 	String tipo = request.getParameter("tipoM");
	 	//String id = request.getParameter("id");
	 	String id = "141";
	 	String serverName = "10.153.120.35";
	 	String portNumber = "3308";
	 	String sid = "corsodb004";
	 	String userName = "corsodb004";
	 	String passwordDB = "ciaociao";
	 	System.out.println("siamo entrati nella jsp");
	 	Connection con;
	 	try {
	 		System.out.println("siamo entrati nel try");
	 		//carica il file di classe del driver per il collegamento  al database con il ponte Odbc
	 		Class.forName("com.mysql.jdbc.Driver");

	 		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;

	 		//apri la connessione con il database
	 		con = DriverManager.getConnection(url, userName, passwordDB);
	 		System.out.println("ora splitiamo la data");
	 		String[] data = scadenza.split("/");
	 		System.out.println("ora splitiamo la data-FATTO");
			scadenza = data[2] + "-" + data[1] + "-" + data[0];
			System.out.println("formato data -- -- --");
			
	 		String query = "UPDATE Utenti " + "SET " + "cognome='" + cognome + "', " + "nome='" + nome + "', "
	 				+ "nomeUser='" + username + "', " + "uPassword='" + password + "', " + "dataScadenza='"
	 				+ scadenza + "', " + "idTipoUser='" + tipo + "' " + "WHERE " + "idUser='" + id + "';";
	 		System.out.println(query);
	 		Statement st = con.createStatement();
	 		st.executeUpdate(query);
	 		con.close();
	 		System.out.println("prima del rendirizzamento");
	 		response.sendRedirect("tabella.jsp");
	 	} catch (Exception e) {
	 		out.write("" + e);
	 	}
	 %>  
</body>
</html>
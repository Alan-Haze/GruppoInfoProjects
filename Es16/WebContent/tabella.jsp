<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/index.css">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Insert title here</title>
</head>
<body>

<script>
function confirmSubmit()
{
	var agree=confirm("Are you sure you wish to continue?");
	if (agree)
	 return true ;
	else
	 return false ;
	}
</script>
	<div class="container">

		<div class="table">
			<form action="elimina.jsp">
				Elenco utenti
				<div class="scroller">
					<table id="minchiaqui">
						<tr>
							<th id="radiobutton"></th>
							<th class="mainBar">USER</th>
							<th class="mainBar">COGNOME</th>
							<th class="mainBar">NOME</th>
							<th class="mainBar">SCAD_PW</th>
						</tr>

						<%@ page import="java.sql.*"%>

						<%
							String serverName = "10.153.120.35";
							String portNumber = "3308";
							String sid = "corsodb004";
							String userName = "corsodb004";
							String passwordDB = "ciaociao";

							String utenti = "";
							String datiUtenti = "";

							Connection con;
							try {
								Class.forName("com.mysql.jdbc.Driver");
								String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
								con = DriverManager.getConnection(url, userName, passwordDB);
								String query = "SELECT nomeUser, Cognome, Nome, dataScadenza, idUser FROM Utenti";
								Statement st = con.createStatement();
								ResultSet rs = st.executeQuery(query);
								String dataOut = "";

								while (rs.next()) {
									dataOut = rs.getString(4);
									String[] ar = dataOut.split("-");
									dataOut = ar[2] + "/" + ar[1] + "/" + ar[0];
									String cont = rs.getString(5);
						%>
						<script>
						function getIdUserRadio(){
							console.log(document.getElementB)
						}
						function CreaElementi() {
							
							let myScroller = document.getElementsByClassName("scroller")
							let newTr = document.createElement('tr');
							
							let newTd0 = document.createElement('th');
							let oInput = document.createElement('input');
							oInput.setAttribute("type", "radio");
							oInput.setAttribute("id", "utentiForm1");
							oInput.setAttribute("name", "utentiForm1");
							oInput.setAttribute("value", " <%=cont%> ") ;
							
							
							let newTd = document.createElement('th');
							newTd.setAttribute("class", "utentiForm");
							newTd.textContent = "<%=rs.getString(1)%>" ;
							
							let newTd1 = document.createElement('th');
							newTd1.setAttribute("class", "utentiForm");
							newTd1.textContent = "<%=rs.getString(2)%>" ;
								
							let newTd2 = document.createElement('th');
							newTd2.setAttribute("class", "utentiForm");
							newTd2.textContent = "<%=rs.getString(3)%>" ;

							let newTd3 = document.createElement('th');
							newTd3.setAttribute("class", "utentiForm");
							newTd3.textContent = "<%=dataOut%>";

								newTd0.appendChild(oInput);
								newTr.appendChild(newTd0);
								newTr.appendChild(newTd);
								newTr.appendChild(newTd1);
								newTr.appendChild(newTd2);
								newTr.appendChild(newTd3);
								minchiaqui.appendChild(newTr);

								let ss = document.getElementById("utentiForm1")
										.getAttribute("value");
								console.log(ss)
							}
							CreaElementi();
						</script>

						<%
							}
							} catch (Exception e) {
							}
						%>
					</table>
				</div>
				<br>
				<div class="restbuttons">
					<button id="preventsub" onclick="insert()">Inserisci</button>
					<button id="nonono" onclick="modify()">Modifica</button>
					<!-- <button onclick="deleter()">Elimina</button> -->
					<button onclick='return confirmSubmit()' type="submit">Elimina</button>
				</div>
		
		</div>

	</div>
	<a onclick="window.location.href = 'index.jsp'" id="logoutbutton"><button>LogOut</button></a>


	<script></script>
	<script>
		document.getElementById("logoutbutton").addEventListener("click",
				function(event) {
					event.preventDefault()
				});
	</script>
	<script>
		document.getElementById("nonono").addEventListener("click",
				function(event) {
					event.preventDefault()
				});
	</script>


	<script>
		document.getElementById("preventsub").addEventListener("click",
				function(event) {
					event.preventDefault()
				});
		function modify() {
			let swapModify = document.getElementsByClassName("table")[0]
			swapModify.innerHTML = "<div>Modifica Utenti<form action= 'modifica.jsp' id='InserisciModifica' style=' margin-top: 7.5%; margin-left: 7.5%; justify-content: center; display: table;'><div class='riga' style='display: table-row;'><div class='riga' style='display: table-row;'><label style='display: table-cell; padding: 20px;'>Cognome*</label><input type='text' name='cognomeM' style='display: table-cell;'/> <label style='display: table-cell; padding: 20px;'>Nome*</label><input type='text' name='nomeM' style='display: table-cell;'/></div><div class='riga' style='display: table-row;'><label style='display: table-cell; padding: 20px;'>Nome user*</label><input type='text' name='usernameM' style='display: table-cell;'/><label style='display: table-cell; padding: 20px;'>Password*</label><input type='text' name='passwordM' style='display: table-cell;'/></div><div class='riga' style='display: table-row;'><label style='display: table-cell; padding: 20px;'>Data scad password*</label><input type='text' name='scadenzaM'placeholder='gg/mm/aaaa' style='display: table-cell;'/><label style='display: table-cell; padding: 20px;'>Tipo*</label><select id='tipo'name='tipoM'><option value='1'>Amministratore</option><option value='2'>Commerciale</option><option value='3'>Docente</option><option value='4'>Corsista</option></select></div></form><div id='bottonissima'style='float: right; margin-right: 5%; padding: 5%;'><input type='submit' id='salvaInsert' value='Salva'  onclick ='return confirmSubmit()' /><button onclick='fammiredirect()'>Annulla</button></div><div>"

		}
		function insert() {
			let swap = document.getElementsByClassName("table")[0]
			swap.innerHTML = "<div>Inserimento utenti<form action='inserimento.jsp' id='Inserisci' style=' margin-top: 7.5%; margin-left: 7.5%; justify-content: center; display: table;'><div class='riga' style='display: table-row;'><div class='riga' style='display: table-row;'><label style='display: table-cell; padding: 20px;'>Cognome*</label><input type='text' name='cognome' style='display: table-cell;'/> <label style='display: table-cell; padding: 20px;'>Nome*</label><input type='text' name='nome' style='display: table-cell;'/></div><div class='riga' style='display: table-row;'><label style='display: table-cell; padding: 20px;'>Nome user*</label><input type='text' name='username' style='display: table-cell;'/><label style='display: table-cell; padding: 20px;'>Password*</label><input type='text' name='password' style='display: table-cell;'/></div><div class='riga' style='display: table-row;'><label style='display: table-cell; padding: 20px;'>Data scad password*</label><input type='text' name='scadenza'placeholder='gg/mm/aaaa' style='display: table-cell;'/><label style='display: table-cell; padding: 20px;'>Tipo*</label><select id='tipo'name='tipo'><option value='1'>Amministratore</option><option value='2'>Commerciale</option><option value='3'>Docente</option><option value='4'>Corsista</option></select></div></form><div id='bottonissima'style='float: right; margin-right: 5%; padding: 5%;'><button type='submit' id='salvaInsert' onclick ='return confirmSubmit()'>Salva<button><button onclick='fammiredirect()'>Annulla</button></div><div>"
		}
		function fammiredirect() {
			event.preventDefault()
			window.location = "tabella.jsp"
		}
		
	</script>
</body>
</html>
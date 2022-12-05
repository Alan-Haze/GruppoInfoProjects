<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%> --%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<%@page import="java.util.ArrayList"%>
<%@page import="Bean.PersonaAJAX"%>
<%@page import="Bean.PersoneAJAX"%>

<!DOCTYPE>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/formModifica.css">
</head>
<body>
	<script>
		let xmlHttp;
		function selezionato(url) {
			xmlHttp = new XMLHttpRequest();
			xmlHttp.onreadystatechange = handleStateChange;
			xmlHttp.open('POST', url, true);
			xmlHttp.send();
			return false;
		}
		function handleStateChange() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					parserRisultato()
				} else {
					alert("problem:")
				}
			}
		}
		function parserRisultato() {
			var elenconomi = xmlHttp.responseText.split(',');
			carica = '<label>Nome</label>'
			carica += '<select id="nomi" tabindex="2" name="stNome" onchange="attivaBottone()"><option></option>';

			for (let i = 0; i < elenconomi.length; i++) {
				console.log("il cognome da inviare alla action è: \n "
						+ document.getElementById("cognome").value);

				carica += '<option value="'+elenconomi[i] +'">' + elenconomi[i]
						+ '</option>';
			}
			carica += '</select>';
			/* carica += '<button id="vissel"></button>' */
			document.getElementById("spannomi").innerHTML = carica;
		}
		function attivaBottone() {
			document.getElementById('buttonTop').disabled = false;
		}
	</script>
	<script>
		$(document).ready(
				function() {
					/* $('#contocracra').empty(); */
					$('#rigaCC').children().attr("disabled", "disabled");
					$('#rigaCognome').children().attr("disabled", "disabled");
					$('#spannomi').children().attr("disabled", "disabled");
					$("#buttonTop").prop("disabled", true);
					$("#attivaSave").prop("disabled", true);
					$("#attivaAnnulla").prop("disabled", true);
					$(".information").prop("disabled", true);

					$('#targetCognome').click(
							function() {
								$("#buttonTop").prop("disabled", true);
								$('#rigaCC').children().attr("disabled",
										"disabled");
								$('#rigaCognome').children().removeAttr(
										"disabled", "disabled");
								/* $("#buttonTop").removeAttr('disabled'); */
								$("div").remove(".box-dati");

							});
					$('#targetCC').click(
							function() {
								$('#rigaCognome').children().attr("disabled",
										"disabled");
								$('#rigaCC').children().removeAttr("disabled",
										"disabled");
								$("#buttonTop").prop("disabled", true);
								$("div").remove(".box-dati");
							});
					$('#buttonTop').click(function() {

						setTimeout(function() {
							$('#form01')[0].reset();
							document.getElementById("form01").reset();
						}, 1000);
					});
					$("#contocc").change(function() {
						$("#buttonTop").removeAttr('disabled');
					});
					$("#nomi").change(function() {
						alert("ciao");
						$("#buttonTop").removeAttr('disabled');
					});
					$("#nomi").change(function() {

						$("#buttonTop").removeAttr('disabled');
					});
					$('#attivaModifica').click(function() {
						$("#attivaModifica").prop("disabled", true);
						$("#attivaDel").prop("disabled", true);
						$("#attivaSave").removeAttr('disabled');
						$("#attivaAnnulla").removeAttr('disabled');
						$(".information").removeAttr('disabled');

					});
					$('#attivaAnnulla').click(function() {
						$("#attivaAnnulla").prop("disabled", true);
						$("#attivaSave").prop("disabled", true);
						$("#attivaModifica").removeAttr('disabled');
						$("#attivaDel").removeAttr('disabled');
						$(".information").prop("disabled", true);
					});
				});
	</script>
	<label></label>
	<div class="background">
		<div class="tabella">

			<form action="modificaAjax.do" id="form01">
			
				<div class="riga">
					<div id="elemento">
						<input id="targetCognome" type="radio" name="sesso1"
							onclick="this.form.metodo.value='metodoCognome'">Cognome
						<div id="rigaCognome">

							<html:select property="stCognome" styleId="cognome"
								name="beanajax" value=""
								onchange="return selezionato('selCognome.do?selcognome=' +this.value);">
								<option></option>
								<html:options property="elencoCognome" name="beanajax"></html:options>
							</html:select>

						</div>
					</div>
					<div id="elemento">
						<div id="spannomi" style="margin-left: 30;">
							<label>Nome</label><select><option></option></select>

						</div>
					</div>
					<!-- 	<button type="submit" name="idsel" onclick="">Cerca</button> -->
					<div id="elemento">
						<button id="buttonTop" type="submit" name="metodo" value="XX"
							disabled style="margin-left: 40;">Cerca</button>
					</div>
				</div>
				<div id="elemento" style="padding-left: 25; padding-bottom: 35;">
					<input id="targetCC" type="radio" value="" name="sesso1"
						list="contocc" onclick="this.form.metodo.value='metodoCC'">
					Codice conto
					<div id="rigaCC">
						<input type="text" name="contocc" id="contocc" list="contocracra">

						<datalist id="contocracra">
							<c:forEach items="${beanajax.elencoNominativi}" var="persona">
								<option></option>
								<option value="${persona.num_cc}"></option>
							</c:forEach>
						</datalist>

					</div>
				</div>
			</form>
		</div>

		<div class="box-dati">
			<c:forEach items="${beanajax.elencoNominativi}" var="persona">
				<%-- test="${(persona.cognome == beanajax.stCognome) and (persona.nome == beanajax.stNome)}"> --%>
				<c:if test="${persona.cognome == beanajax.stCognome}">

					<form action="bottoni4.do" method="POST" id='information'>
						<input hidden name="cod_anag"
							value="<c:out value="${persona.cod_anag}"></c:out>"> <input
							hidden name="num_cc"
							value="<c:out value="${persona.num_cc}">
						</c:out>">

						<input hidden name="metodo" value="xx">
						<div class="form-box">
							<div class="riga">
								<h3>Dati Correntista</h3>
							</div>



							<div class="riga">
								<div class="cell1">
									<label for="cognome"> <span>Cognome*</span> <input
										type="text" name="cognome" id="cognome" class="information"
										value="<c:out value="${persona.cognome}"></c:out>">
									</label>
								</div>

								<div class="cell2">
									<label for="nome"> <span>Nome*</span> <input
										type="text" name="nome" id="nome" class="information"
										value="<c:out value="${persona.nome}"></c:out>">
									</label>
								</div>

								<div class="cell3">
									<label for="telefono1"> <span>Telefono1*</span> <input
										type="text" name="telefono1" id="telefono1"
										class="information"
										value="<c:out value="${persona.telefono1}"></c:out>">
									</label>
								</div>
							</div>

							<div class="riga">
								<div class="cell1">
									<label for="ragione sociale"> <span>Ragione
											sociale</span> <input type="text" name="rag_soc" id="rag_soc"
										class="information"
										value="<c:out value="${persona.rag_soc}"></c:out>">
									</label>
								</div>
								<div class="cell2">
									<input hidden name="sessoskrt" value="${persona.sesso}"> <label
										for="sesso"> <span>Sesso</span> <c:if
											test="${persona.sesso eq 'M'}">

											<input type="radio" name="sesso" class="information"
												value="F" onclick="this.form.sessoskrt.value='F'">
											<span>femmina</span>
											<input type="radio" name="sesso" value="M"
												class="information" onclick="this.form.sessoskrt.value='M'"
												checked>
											<span>maschio</span>
										</c:if> <c:if test="${persona.sesso eq 'F'}">
											<input type="radio" name="sesso" value="F"
												class="information" onclick="this.form.sessoskrt.value='F'"
												checked>
											<span>femmina</span>
											<input type="radio" name="sesso" value="M"
												class="information" onclick="this.form.sessoskrt.value='M'">
											<span>maschio</span>
										</c:if>
									</label>
								</div>

								<div class="cell3">
									<label for="telefono2"> <span>Telefono2</span> <input
										type="text" name="telefono2" id="telefono2"
										class="information"
										value="<c:out value="${persona.telefono2}"></c:out>">
									</label>
								</div>
							</div>

							<div class="riga">
								<div class="cell-double">
									<label for="indirizzo"> <span>Indirizzo*</span> <input
										type="text" name="indirizzo" id="indirizzo"
										class="information"
										value="<c:out value="${persona.indirizzo}"></c:out>">
									</label>
								</div>
								<div class="cell3">
								<input hidden name="cittaID" value="${persona.id_comune}">
									<label for="città"> <span>Città</span> 
									<select onchange="console.log(value);changeFunc(value)"
										name="citta" class="information">
											<option>${persona.citta}</option>
											<%@ page import="java.sql.*"%>
											
											<%
												String serverName = "10.153.120.35";
														String portNumber = "3308";
														String sid = "corsodb004";
														String userName = "corsodb004";
														String passwordDB = "ciaociao";
														Connection con = null;
														Class.forName("com.mysql.jdbc.Driver");
														String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
														con = DriverManager.getConnection(url, userName, passwordDB);

														String query = "SELECT * FROM Comuni;";
														Statement st = con.createStatement();
														ResultSet rs = st.executeQuery(query);
														while (rs.next()) {
														
															out.write("<option value='"+rs.getString(1)+"'>" + rs.getString(2) + "</option>");
														}
											%>
											<!-- onchange='this.form.citta1.value='"+ rs.getString(1)+"'' -->
									</select>
									</label>
								</div>
							</div>
							<div class="riga-reduced">
								<div class="cell1">
									<label for="data nascita"> <span>Data nascita*</span> <input
										type="text" name="data_nascita" id="data_nascita"
										class="information"
										value="<c:out value="${persona.data_nascita}"></c:out>">
									</label>
								</div>

								<div class="cell2">
									<label for="luogo nascita"> <span>Luogo nascita*</span>
										<input type="text" name="luogo_nascita" id="luogo_nascita"
										class="information"
										value="<c:out value="${persona.luogo_nascita}"></c:out>">
									</label>
								</div>
							</div>

							<div class="box-cc">
								<label for="numero conto"> <span>Num. conto</span> <input
									type="text" name="num_cc" id="num_cc" class="information"
									value="<c:out value="${persona.num_cc}"></c:out>" readonly>
								</label>
							</div>

							<div class="riga-reduced">
								<div class="cell1">
									<label for="codice fiscale"> <span>Codice
											fiscale</span> <input type="text" name="cf" id="cf"
										class="information"
										value="<c:out value="${persona.cod_fiscale}"></c:out>">
									</label>
								</div>

								<div class="cell2">
									<label for="partita iva"> <span>Partita iva</span> <input
										type="text" name="p_iva" id="p_iva" class="information"
										value="<c:out value="${persona.partita_iva}"></c:out>">
									</label>
								</div>
							</div>

							<div class="riga">
								<div class="cell1">
									<label for="email"> <span>Email</span> <input
										type="text" name="email" id="email" class="information"
										value="<c:out value="${persona.email}"></c:out>">
									</label>
								</div>
							</div>
							<div class="riga">

								<button id="attivaAnnulla" type="reset"
									onclick="toggleAnnulla(true)">Annulla</button>
								<button id="attivaModifica" type="reset"
									onclick="toggleModifica(true)">Modifica</button>
								<button id="attivaDel" type="submit"
									onclick="return ControllaElimina()">Elimina</button>
								<button id="attivaSave" type="submit"
									onclick="return ControllaSalva()">Salva</button>

							</div>

						</div>


					</form>
				</c:if>
				<c:if test="${persona.num_cc == beanajax.idsel}">
					<form action="bottoni4.do" method="POST" id='information'
						id="form01">
						<input hidden name="cod_anag"
							value="<c:out value="${persona.cod_anag}"></c:out>"> <input
							hidden name="num_cc"
							value="<c:out value="${persona.num_cc}">
						</c:out>">

						<input hidden name="metodo" value="xx">
						<div class="form-box">
							<div class="riga">
								<h3>Dati Correntista</h3>
							</div>

							<div class="riga">
								<div class="cell1">
									<label for="cognome"> <span>Cognome*</span> <input
										type="text" name="cognome" id="cognome" class="information"
										value="<c:out value="${persona.cognome}"></c:out>">
									</label>
								</div>

								<div class="cell2">
									<label for="nome"> <span>Nome*</span> <input
										type="text" name="nome" id="nome" class="information"
										value="<c:out value="${persona.nome}"></c:out>">
									</label>
								</div>

								<div class="cell3">
									<label for="telefono1"> <span>Telefono1*</span> <input
										type="text" name="telefono1" id="telefono1"
										class="information"
										value="<c:out value="${persona.telefono1}"></c:out>">
									</label>
								</div>
							</div>

							<div class="riga">
								<div class="cell1">
									<label for="ragione sociale"> <span>Ragione
											sociale</span> <input type="text" name="rag_soc" id="rag_soc"
										class="information"
										value="<c:out value="${persona.rag_soc}"></c:out>">
									</label>
								</div>

								<div class="cell2">
									<input hidden name="sessoskrt" value="${persona.sesso}"> <label
										for="sesso"> <span>Sesso</span> <c:if
											test="${persona.sesso eq 'M'}">

											<input type="radio" name="sesso" class="information"
												value="F" onclick="this.form.sessoskrt.value='F'">
											<span>femmina</span>
											<input type="radio" name="sesso" value="M"
												class="information" onclick="this.form.sessoskrt.value='M'"
												checked>
											<span>maschio</span>
										</c:if> <c:if test="${persona.sesso eq 'F'}">
											<input type="radio" name="sesso" value="F"
												class="information" onclick="this.form.sessoskrt.value='F'"
												checked>
											<span>femmina</span>
											<input type="radio" name="sesso" value="M"
												class="information" onclick="this.form.sessoskrt.value='M'">
											<span>maschio</span>
										</c:if>
									</label>
								</div>
								<div class="cell3">
									<label for="telefono2"> <span>Telefono2</span> <input
										type="text" name="telefono2" id="telefono2"
										class="information"
										value="<c:out value="${persona.telefono2}"></c:out>">
									</label>
								</div>
							</div>

							<div class="riga">
								<div class="cell-double">
									<label for="indirizzo"> <span>Indirizzo*</span> <input
										type="text" name="indirizzo" id="indirizzo"
										class="information"
										value="<c:out value="${persona.indirizzo}"></c:out>">
									</label>
								</div>
								
								<div class="cell3">
								<input hidden name="cittaID" value="${persona.id_comune}">
									<label for="città"> <span>Città</span> 
									<select onchange="console.log(value);changeFunc(value)"
										name="citta" class="information">
											<option value="id_comune: <c:out value="${persona.id_comune}"></c:out>">
											</option>
											<%@ page import="java.sql.*"%>
											<%
												String serverName = "10.153.120.35";
														String portNumber = "3308";
														String sid = "corsodb004";
														String userName = "corsodb004";
														String passwordDB = "ciaociao";
														Connection con = null;
														Class.forName("com.mysql.jdbc.Driver");
														String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + sid;
														con = DriverManager.getConnection(url, userName, passwordDB);

														String query = "SELECT * FROM Comuni;";
														Statement st = con.createStatement();
														ResultSet rs = st.executeQuery(query);
														while (rs.next()) {
															out.write("<option value='"+rs.getString(1)+"' class='information'>" + rs.getString(2) + "</option>");
														}
											%>
											<!-- onchange='this.form.citta1.value='"+ rs.getString(1)+"'' -->
									</select>
									</label>
								</div>
							</div>
							<div class="riga-reduced">
								<div class="cell1">
									<label for="data nascita"> <span>Data nascita*</span> <input
										type="text" name="data_nascita" id="data_nascita"
										class="information"
										value="<c:out value="${persona.data_nascita}"></c:out>">
									</label>
								</div>

								<div class="cell2">
									<label for="luogo nascita"> <span>Luogo nascita*</span>
										<input type="text" name="luogo_nascita" id="luogo_nascita"
										class="information"
										value="<c:out value="${persona.luogo_nascita}"></c:out>">
									</label>
								</div>
							</div>

							<div class="box-cc">
								<label for="numero conto"> <span>Num. conto</span> <input
									type="text" name="num_cc" id="num_cc" class="information"
									value="<c:out value="${persona.num_cc}"></c:out>" readonly>
								</label>
							</div>

							<div class="riga-reduced">
								<div class="cell1">
									<label for="codice fiscale"> <span>Codice
											fiscale</span> <input type="text" name="cf" id="cf"
										class="information"
										value="<c:out value="${persona.cod_fiscale}"></c:out>">
									</label>
								</div>

								<div class="cell2">
									<label for="partita iva"> <span>Partita iva</span> <input
										type="text" name="p_iva" id="p_iva" class="information"
										value="<c:out value="${persona.partita_iva}"></c:out>">
									</label>
								</div>
							</div>

							<div class="riga">
								<div class="cell1">
									<label for="email"> <span>Email</span> <input
										type="text" name="email" id="email" class="information"
										value="<c:out value="${persona.email}"></c:out>">
									</label>
								</div>
							</div>

							<div class="riga">
								<button id="attivaAnnulla" type="reset"
									onclick="toggleAnnulla(true)">Annulla</button>
								<button id="attivaModifica" type="reset"
									onclick="toggleModifica(true)">Modifica</button>
								<button id="attivaDel" type="submit"
									onclick="return ControllaElimina()">Elimina</button>
								<button id="attivaSave" type="submit"
									onclick="return ControllaSalva()">Salva</button>

							</div>
					</form>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
		function XML() {
			let XHR = null;
			XHR = new XMLHttpRequest();
			return XHR
		}
		function ControllaElimina() {
			var agree = confirm("Are you sure you wish to continue?");
			if (agree) {
				document.forms[1].metodo.value = 'elimina'
				return true;
			}

			else
				return false;
		}

		function ControllaSalva() {
			var agree = confirm("Are you sure you wish to continue?");
			if (agree) {
				document.forms[1].metodo.value = 'salva'
				return true;
			}

			else
				return false;
		}

		function toggleAnnulla(bool) {
			console.log("cliccatoAnnulla")
			if (bool == true) {
				console.log("true")
				document.getElementById('information').disabled = true;
			} else {
				console.log("false")

			}
		}
		function toggleModifica(bool) {
			console.log("cliccatoModificato")
			if (bool == true) {
				console.log("true")
				document.getElementById('information').disabled = false;
			} else {
				console.log("false")

			}
		}
		function changeFunc(i) {
		     alert(i);
		     document.forms[1].cittaID.value=i
		   }
		
	</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="css/tabella.css">
</head>
<body>
	<div class="background">
		<div class="tabella">
			<form action="elenco2.do" method="POST">
				<table>
					<thead>
						<tr>
							<th>Seleziona</th>
							<th>Cognome</th>
							<th>Nome</th>
							<th>Ragione sociale</th>
							<th>Telefono</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${elencopersonebean.elencoPersone}" var="persona">
							<tr>
								<td><button type="submit" name="idsel"
										value="${persona.cod_anag}" onclick='console.log(${persona.cod_anag},${elencopersonebean.idsel})'>
										<img alt="<O" src="png/lente1.png" height=20px width=20px;>
										</button></td>
								<td><label>${persona.cognome} </label></td>
								<td><label>${persona.nome} </label></td>
								<td><label>${persona.rag_soc} </label></td>
								<td><label>${persona.telefono1} </label></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>

		<div class="box-dati">
			<c:forEach items="${elencopersonebean.elencoPersone}" var="persona">
				<c:if test="${persona.cod_anag == elencopersonebean.idsel}">
					<div class="form-box">
						<div class="riga">
							<h3>Dati Correntista</h3>
						</div>

						<div class="riga">
							<div class="cell1">
								<label for="cognome"> <span>Cognome*</span> <input
									type="text" name="cognome" id="cognome"
									value="<c:out value="${persona.cognome}"></c:out>" readonly>
								</label>
							</div>

							<div class="cell2">
								<label for="nome"> <span>Nome*</span> <input type="text"
									name="nome" id="nome"
									value="<c:out value="${persona.nome}"></c:out>" readonly>
								</label>
							</div>

							<div class="cell3">
								<label for="telefono1"> <span>Telefono1*</span> <input
									type="text" name="telefono1" id="telefono1"
									value="<c:out value="${persona.telefono1}"></c:out>" readonly>
								</label>
							</div>
						</div>

						<div class="riga">
							<div class="cell1">
								<label for="ragione sociale"> <span>Ragione
										sociale</span> <input type="text" name="rag_soc" id="rag_soc"
									value="<c:out value="${persona.rag_soc}"></c:out>" readonly>
								</label>
							</div>

							<div class="cell2">
								<label for="sesso"> <span>Sesso</span> <c:if
										test="${persona.sesso eq 'M'}">
										<input type="radio" name="sesso" value="F" disabled>
										<span>femmina</span>
										<input type="radio" name="sesso" value="M" checked disabled>
										<span>maschio</span>
									</c:if> <c:if test="${persona.sesso eq 'F'}">
										<input type="radio" name="sesso" value="F" checked disabled>
										<span>femmina</span>
										<input type="radio" name="sesso" value="M" disabled>
										<span>maschio</span>
									</c:if>
								</label>
							</div>

							<div class="cell3">
								<label for="telefono2"> <span>Telefono2</span> <input
									type="text" name="telefono2" id="telefono2"
									value="<c:out value="${persona.telefono2}"></c:out>" readonly>
								</label>
							</div>
						</div>

						<div class="riga">
							<div class="cell-double">
								<label for="indirizzo"> <span>Indirizzo*</span> <input
									type="text" name="indirizzo" id="indirizzo"
									value="<c:out value="${persona.indirizzo}"></c:out>" readonly>
								</label>
							</div>
							<div class="cell3">
								<label for="città"> <span>Città</span> <select
									name="citta" disabled>
										<option><c:out value="${persona.citta}"></c:out></option>
								</select>
								</label>
							</div>
						</div>
						<div class="riga-reduced">
							<div class="cell1">
								<label for="data nascita"> <span>Data nascita*</span> <input
									type="text" name="data_nascita" id="data_nascita"
									value="<c:out value="${persona.data_nascita}"></c:out>"
									readonly>
								</label>
							</div>

							<div class="cell2">
								<label for="luogo nascita"> <span>Luogo nascita*</span>
									<input type="text" name="luogo_nascita" id="luogo_nascita"
									value="<c:out value="${persona.luogo_nascita}"></c:out>"
									readonly>
								</label>
							</div>
						</div>

						<div class="box-cc">
							<label for="numero conto"> <span>Num. conto</span> <input
								type="text" name="num_cc" id="num_cc"
								value="<c:out value="${persona.num_cc}"></c:out>" readonly>
							</label>
						</div>

						<div class="riga-reduced">
							<div class="cell1">
								<label for="codice fiscale"> <span>Codice fiscale</span>
									<input type="text" name="cf" id="cf"
									value="<c:out value="${persona.cod_fiscale}"></c:out>" readonly>
								</label>
							</div>

							<div class="cell2">
								<label for="partita iva"> <span>Partita iva</span> <input
									type="text" name="p_iva" id="p_iva"
									value="<c:out value="${persona.partita_iva}"></c:out>" readonly>
								</label>
							</div>
						</div>

						<div class="riga">
							<div class="cell1">
								<label for="email"> <span>Email</span> <input
									type="text" name="email" id="email"
									value="<c:out value="${persona.email}"></c:out>" readonly>
								</label>
							</div>
						</div>
						<div class="riga">

							<div class="cell1"></div>

							<div class="cell2"></div>

							<div class="cell3">
								<button>
									<a href="elenco.do">Chiudi</a>
								</button>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>
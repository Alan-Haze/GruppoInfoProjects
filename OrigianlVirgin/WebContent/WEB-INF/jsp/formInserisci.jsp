<%@page import="java.util.ArrayList"%>
<%@page import="Bean.FormInserisci"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
 <link rel="stylesheet" href="css/formInserisci.css"> 
</head>
<body>
	<%
		ArrayList<String> elencoCitta = new ArrayList<>();
		elencoCitta = ((FormInserisci)request.getSession().getAttribute("myInsert")).getElencoCitta();
	%> 
	<div class="background">
		<div class="form-box">
			<form action="inserisciInDB.do" method="POST">
				<div class="riga">
					<h3>Inserimento</h3>
				</div>
				
				<div class="riga">
					<div class="cell1">
						<label for="cognome">
							<span>Cognome*</span>
							<input type="text" name="cognome" id="cognome" maxlength="30" required pattern="[A-z]+">
						</label>
					</div>
					
					<div class="cell2">
						<label for="nome">
							<span>Nome*</span>
							<input type="text" name="nome" id="nome" maxlength="30" required pattern="[A-z]+">
						</label>
					</div>
					
					<div class="cell3">
						<label for="telefono1">
							<span>Telefono1*</span>
							<input type="text" name="telefono1" id="telefono1" maxlength="10" required pattern="[0-9]+">
						</label>
					</div>		
				</div>
				
				<div class="riga">
					<div class="cell1">
						<label for="ragione sociale">
							<span>Ragione sociale</span>
							<input type="text" name="rag_soc" id="rag_soc" maxlength="40">
						</label>
					</div>
					
					<div class="cell2">
						<label for="sesso">
							<span>Sesso</span>
							<input type="radio" name="sesso" value="F" required> <span>femmina</span>
							<input type="radio" name="sesso" value="M" required>	<span>maschio</span>
						</label>
					</div>
					
					<div class="cell3">
						<label for="telefono2">
							<span>Telefono2</span>
							<input type="text" name="telefono2" id="telefono2" maxlength="10" pattern="[0-9]+">
						</label>
					</div>			
				</div>
				
				<div class="riga">
					<div class="cell-double">
						<label for="indirizzo">
							<span>Indirizzo*</span>
							<input type="text" name="indirizzo" id="indirizzo"  maxlength="30" required>
						</label>
					</div>
					<div class="cell3">
						<label for="città">
							<span>Città</span>
							<select name="citta" required>
								<option></option>
								 <% 
									for(int i=0; i<elencoCitta.size(); i++){
										out.write("<option value="+elencoCitta.get(i)+">"+elencoCitta.get(i)+"</option>");
									}
								%> 
							</select>
						</label>
					</div>	
				</div>
				<div class="riga-reduced">
					<div class="cell_spec">
						<label for="data nascita">
							<span>Data nascita*</span>
							<input type="text" name="data_nascita" id="data_nascita" readonly>
							<input type="date" id="data" max="3000-01-01" onfocus="this.max=new Date().toISOString().split('T')[0]"  onchange="passaData();" required>
						</label>
					</div>
					
					<div class="cell2">
						<label for="luogo nascita">
							<span>Luogo nascita*</span>
							<input type="text" name="luogo_nascita" id="luogo_nascita"  maxlength="20" required pattern="[A- z]+">
						</label>
					</div>	
				</div>
				
				<div class="box-cc">
					<label for="numero conto">
						<span>Num. conto</span>
						 <input type="text" name="num_cc" id="num_cc" value="<%=((FormInserisci)request.getSession().getAttribute("myInsert")).getNum_cc()%>" readonly>
					</label>
				</div>
				
				<div class="riga-reduced">
					<div class="cell1">
						<label for="codicefiscale">
							<span>Codice fiscale</span>
							<input type="text" name="cf" id="cf" maxlength="16" pattern="^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$">
						</label>
					</div>
					
					<div class="cell2">
						<label for="partita iva">
							<span>Partita iva</span>
							<input type="text" name="p_iva" id="p_iva" maxlength="11" pattern="[0-9]+">
						</label>
					</div>	
				</div>
					
				<div class="riga">
					<div class="cell1">
						<label for="email">
							<span>Email</span>
							<input type="text" name="email" id="email" maxlength="30" pattern="[a-Z0-9]+@[a-Z]+\\.[a-Z]{2,3}">
						</label>
					</div>
				</div>
				<div class="riga">
					
					<div class="cell1"></div>
					
					 <div class="cell2">
						<%-- <%=((FormInserisci)request.getSession().getAttribute("myInsert")).getErrore()		%>
						<%((FormInserisci)request.getSession().getAttribute("myInsert")).setErrore(""); 	%>
					 --%></div> 
					
					<div class="cell3">
						<input type="submit" value="Salva"/>
						<button><a href="login.do">Annulla</a></button>
					</div>
					
				</div>
			</form>
		</div>
	</div>
</body>

<script type="text/javascript">
	function passaData(){
		document.getElementById("data_nascita").value = document.getElementById("data").value;
	}
</script>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="css/navbar.css">
</head>
<body>
	<nav class="navbar">
		<div id="bottone">
			<a href="returnHome.do" >Home</a>
		</div>
		<div class="dropdown">
			<button class="dropbtn">Anagrafica  correntisti</button>
			<div class="dropdown-content">
				<a href="formInserimento.do">Inserimento correntisti</a> 
				<a href="formModifica.do">Modifica correntista</a> 
				<a href="elenco.do">Elenco correntisti</a>
			</div>
		</div>
		 <div class="dropdown2">
			<button class="dropbtn2">Modifica conti correnti</button>
			<div class="dropdown-content2">
				<a href="">Distinta di versamento</a> 
				<a href="">Bonifico bancario</a> 
			</div>
		</div> 
	</nav>
</body>
</html>
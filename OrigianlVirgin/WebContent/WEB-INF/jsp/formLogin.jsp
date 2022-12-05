<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<div class="formBackground">
	<div class="container1">
		<div class="intestazione">
			<legend>Accedi dal tuo conto</legend>
		</div>

		<div class="img">
			<img src="png/immLoginIntesaSPaolo.png">
		</div>

		<div class="container2">
			<form action="login.do" method="POST">
				<div class="row">
					<label for="User">User<input type="text"
						id="username" name="username"/>
					</label>
				</div>
				<div class="row">
					<label for="Password">Password<input
						type="password" id="password" name="password"/>
					</label>
				</div>
				<div class="row">
					<input type="submit" value="Login!" />
				</div>
			</form>
		</div>
	</div>
</div>
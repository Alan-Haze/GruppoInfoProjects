<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML><html>
<head>
<link rel="stylesheet" href="css/es16.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here alan</title>	
</head>
<body>

<div class="container">
      
    <form class="formcontainer"  onsubmit="checkLogin()" >
        <legend id="blue" >Login</legend>
        <fieldset>
        <label for="user" id="userlabel">User</label>
        <input type="text" name="user" id="user"  >
        <img src="png/immgLogin.png" width="50px" height="50px" id="immagine">
        <br>
        <br>
        <label for="user">Password</label>
        <input type="text" name="password" id="password">
        <button type="submit" id="submitbutton"  >Login</button>
        <br>
        <div id="errore"  style="color:red;font-size: 11px;" ></div>
    	<br>
    </fieldset>
    </form>	
    		<script type="text/javascript">
    		
    			function checkLogin(){
    				event.preventDefault()
    				let username = document.getElementById("user").value;
    				let password = document.getElementById("password").value;
    				let target = document.getElementById("errore");
    				
    				if (username == "admin") {
    					if (password == "admin") {
    						window.location = "tabella.jsp";
    					} else {
    						console.log("password sbagliata");
    						target.innerHTML = 
      			              "ERRORE digitare User: admin Password: admin";
    					}
    				} else {
    					console.log("username sbagliato");
    					target.innerHTML = 
    			              "ERRORE digitare User: admin Password: admin";
    				}
    				
    			} 
    			
    		</script>
</div>

</body>
</html>


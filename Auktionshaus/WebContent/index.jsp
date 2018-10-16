<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="style.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auktionshaus_Sailer</title>
</head>
<body>

<form action="CheckLogin" method="post">
<h3> Username</h3><input type="text" name="username"/>
<br>
<h3> Password</h3><input type="password" name="password"/>
<br>
<p></p>
<div>
<input type="submit" value="Anmelden"/>
</div>

 <%
 	String errmsg = (String) request.getAttribute("error");
 	if (errmsg != null){
 		out.append("<p class='error'>" + errmsg + "</p>");
 		
 	}
 %>
</form>

<div>
<form action="GoToRegister" method="POST" >
<button class="anmelden" type="submit" onClick="Register" >Regrister</button>

</form>
</div>
</body>
</html>
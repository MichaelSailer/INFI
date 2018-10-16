

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="register_style.css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h1>Welcome to Register</h1>
	<div>
	<form action="register" method="POST">
		Username: <input type="text" name="username"/><br>
		Password: <input type="password" name="password1"><br>
		Wiederholen: <input type="password" name="password2"/><br>
		E-Mail: <input type="text" name="email"> <br>
		<button type="submit">Anmelden</button>
		</form>
	</div>
	


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contatos</title>
</head>
<body>
	<form method="post" action="servletContato">
	<% out.println("Nome"); %><input type="text" name="nome"/><br>
	<% out.println("Telefone"); %><input type="text" name="telefone"/><br>
	<input type="submit" value="Enviar">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet" method="POST">
<input type="hidden" name="accion" value="crearusuario">
<input type="text" name="usuario" placehloder="Usuario">
<br>
<input type="password" name="password" placehloder="Password">
<br>
<input type="submit" value="ENVIAR">
</form>
</body>
</html>
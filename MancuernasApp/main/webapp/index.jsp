<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mancuernas</title>
</head>
<body>
<form method="POST" action="Servlet">
<input type="hidden" name="accion" value="login">
USUARIO: <input type="text" name="usuario">
PASSWORD: <input type="text" name="password">
<input type="submit" value="ENVIAR">
</form>

</body>
</html>
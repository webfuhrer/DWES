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
<input type="hidden" name="accion" value="insertar">
NOMBRE: <input type="text" name="titulo"><br>
GÉNERO: <input type="text" name="genero">
<input type="submit">
</form>
</body>
</html>
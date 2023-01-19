<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="ServletRecuperaDatos?accion=listar">
Ver contactos
</a>
<form action="ServletRecuperaDatos" method="POST">
<input type="text" placeholder="Escribe el nombre" name="nombre"><br>
<input type="tel" placeholder="Escribe el teléfono" name="telefono">
<input type="submit">
</form>

</body>
</html>
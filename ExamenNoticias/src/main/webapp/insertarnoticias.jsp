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
<input type="hidden" name="accion" value="grabar">
ESPAÑOL:<br>
<input type="text" name="titular_ES"><br>
<textarea name="cuerpo_ES"></textarea>

<br>
INGLES:
<input type="text" name="titular_EN"><br>
<textarea name="cuerpo_EN"></textarea>
<input type="submit">
</form>
</body>
</html>
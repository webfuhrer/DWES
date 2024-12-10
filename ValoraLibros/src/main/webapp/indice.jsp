<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet" method="POST">
<input type="text" name="usr" placeholder="Introduzca el usuario">
<input type="password" name="pwd" placeholder="Introduzca el pwd">
<input type="hidden" name="action" value="login">
<input type="submit" >
</form> 
<br>
<a href="Servlet?action=ver">Valorar libros</a>
</body>
</html>
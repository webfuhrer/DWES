<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="paqueteexamen.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet" method="POST">
<input type="hidden" name="action" value="insertar_libro">
<input type="text" name="nombre">
<input type="text" name="autor">
<input type="text" name="URL_portada">
<input type="number" name="ISBN">
<!-- El desplegable se llama puntuacion -->
<%=PintaHTML.crearDesplegablePuntuacion()%>
<input type="submit">
</form>
<a href="Servlet?action=importarCSV">Importar desde CSV</a>
</body>
</html>
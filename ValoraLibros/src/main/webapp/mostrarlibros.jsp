<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="paqueteexamen.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<Libro>libros=(ArrayList<Libro>)request.getAttribute("libros"); %>
<%
String html_tabla=PintaHTML.crearTabla(libros);
%>

<%=html_tabla %>
<br>
<a href="Servlet?action=exportMongoDB">Exportar a MongoDB</a>
<br>
<a href="Servlet?action=exportCSV">Exportar a CSV</a>
</body>
</html>
<%@page import="paquetebiblioteca.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%ArrayList<Libro> lista_libros=(ArrayList<Libro> )request.getAttribute("lista_libros"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String tabla_html=PintarHTML.pintarTabla(lista_libros);
out.print(tabla_html);
%>
</body>
</html>
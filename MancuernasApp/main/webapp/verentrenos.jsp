<%@page import="paqueteobjetos.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String usuario=(String)request.getAttribute("usuario");
ArrayList<Entrenamiento> lista_entrenos=(ArrayList<Entrenamiento>)request.getAttribute("lista_entrenos");
String tabla=PintarHTML.crearTabla(lista_entrenos);
%>
</head>
<body>
<!-- request.setAttribute("lista_entrenos", lista_entrenos);
		request.setAttribute("usuario", usuario); -->
		<%=tabla %>
		<br>
		<form action="Servlet" method="POST">
		<button type="submit" name="accion" value="exportar">
		<input type="hidden" name="usuario" value="<%=usuario%> ">
		EXPORTAR A CSV
		</button>
		</form>
		
</body>
</html>
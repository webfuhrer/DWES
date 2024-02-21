<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="paqueteobjetos.Ejercicio" %>
    <%@page import="paqueteobjetos.PintarHTML" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String usuario=(String)request.getAttribute("usuario");
ArrayList<Ejercicio> lista_ejercicios=(ArrayList<Ejercicio>)request.getAttribute("lista_ejercicios");
if (usuario==null)
{
	request.getRequestDispatcher("index.jsp");
}
%>
Bienvenido <%=usuario %>
<a href="Servlet?accion=verentrenos&usuario=<%=usuario%>">Ver entrenos de <%=usuario%> </a>
<form action="Servlet" method="post">
<input type="hidden" name="usuario" value="<%=usuario%>">
<%

//Código para pintar los desplegables
out.print(PintarHTML.crearOpcion(1, lista_ejercicios));
out.print(PintarHTML.crearOpcion(2, lista_ejercicios));
out.print(PintarHTML.crearOpcion(3, lista_ejercicios));
out.print(PintarHTML.crearOpcion(4, lista_ejercicios));
%>
<button name="accion" type="submit" value="crearentreno">
Grabar
</button>
</form>


</body>
</html>
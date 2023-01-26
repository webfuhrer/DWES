<%@page import="paqueteforo.Comentario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String usuario=(String)session.getAttribute("usuario");
ArrayList<Comentario> comentarios=(ArrayList<Comentario>)request.getAttribute("comentarios");
%>
</body>
Hola <%=usuario %>
<%
for (int i=0; i<comentarios.size(); i++)
{
	Comentario c=comentarios.get(i);
	out.print(c.crearHTML());
	
}

%>
<form action="Servlet" method="POST">

<textarea name="comentario" ></textarea>
<input type="submit">
</form>
</html>
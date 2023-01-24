<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi agenda CSV</title>
</head>
<body>
<%
ArrayList<String> contactos=(ArrayList<String>)request.getAttribute("datos");

%>
<%=contactos %>
<ul>
<%
	for(int indice=0; indice<contactos.size(); indice++)
	{
		out.print("<li>"+contactos.get(indice)+"</li>");
	}
%>

</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
String master=(String)request.getAttribute("master");
if(master==null || !master.equals("OK"))
{
	//Se ha colado. Fuera de aquí
	request.getRequestDispatcher("index.jsp").forward(request,response);
}


%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet" method="POST">
<input type="text" name="nombre_ejercicio">
<input type="hidden" name="accion" value="crearejercicio">
<input type="submit" value="Enviar">

</form>
</body>
</html>
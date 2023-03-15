<%@page import="paquetenoticias.Noticia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String idioma=(String)request.getAttribute("idioma");
    ArrayList<Noticia> lista_noticias=(ArrayList<Noticia>)request.getAttribute("lista_noticias");
 	String ruta_imagen="./imagenes/espanya.png";
 	String accion="cambiaridiomaES";//cambiaridiomaES
    if (idioma.equals("ES"))
 	{
    	ruta_imagen="./imagenes/uk.png";
    	accion="cambiaridiomaEN";
 	}
    		
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="insertarnoticias.jsp">Insertar noticias</a><br>
	<a href="Servlet?accion=<%=accion %>">
	<img src="<%=ruta_imagen %>" width=5%>
	</a>
<%
String texto="";
for (int i=0; i<lista_noticias.size(); i++)
{
	Noticia n=lista_noticias.get(i);
	texto+="<br><hr><h2>"+n.getTitular()+"</h2><p>"+n.getCuerpo()+"</p>";
	
}
%>
<%=texto %>
</body>
</html>
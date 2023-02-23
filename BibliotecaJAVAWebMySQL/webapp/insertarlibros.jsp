<%@page import="paquetebiblioteca.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function verificarDesplegable()
{
//1-Ver el valor del select
var valor_select=document.getElementsByName("genero")[0].value;

if (valor_select==0)
	{
	//2-Si el value es cero, saco un input text con name=n_genero. Y hago que acccion=nuevo_genero
	document.getElementById("capa_texto").innerHTML="<input type='text' name='n_genero'>";
	document.getElementsByName("accion")[0].value="nuevogenero";
	}
else
	{
	//3-Si el value es distinto de 0. quitar el campo, si existe y poner accion=insertar
	document.getElementById("capa_texto").innerHTML="";
	document.getElementsByName("accion")[0].value="insertar";
	}


}


</script>

</head>
<body>
<%ArrayList<Genero> lista_generos=(ArrayList<Genero>)request.getAttribute("lista_generos");
String desplegable_generos=PintarHTML.crearDesplegable(lista_generos, "genero", "");


%>
<form action="Servlet" method="POST">
	<input type="hidden" name="accion" value="insertar">
	NOMBRE: <input type="text" name="titulo"><br>
	GÉNERO: <%=desplegable_generos %>
	<div id="capa_texto"></div>
<input type="submit">
</form>
</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="paquetecoches.PintarHTML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
ArrayList<String> modelos=(ArrayList<String>)request.getAttribute("modelos");
ArrayList<String> marcas=(ArrayList<String>)request.getAttribute("marcas");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Concesionario</title>
<script>
function enviarDatos()
{
	
	}
function ponerOyente()
{
	var objeto_desplegable=document.getElementsByName("marca")[0];
	objeto_desplegable.onchange=function(){
		document.getElementsByTagName("form")[0].submit();
	}
}
</script>
</head>
<body onload="ponerOyente();">
<!-- Formulario buscar modelo por marca (a) -->
<form action="Servlet" method="POST">
	<%
	String desplegable_modelos="";
	String marca_seleccionada="";
	if (modelos!=null)
	{
		marca_seleccionada=(String)request.getAttribute("marca_seleccionada");
		desplegable_modelos=PintarHTML.crearDesplegable(modelos, "modelo", "");
				
	}
	String desplegable_marcas=PintarHTML.crearDesplegable(marcas, "marca", marca_seleccionada);//El tercer argumento es para cuando seleccione
	out.print(desplegable_marcas);
	out.print(desplegable_modelos);
	%>
	<input type="hidden" name="accion" value="vermodelospormarcas">
	<input type="submit" >
	</form>
	<hr>
<!-- Formulario de insertar marca (b)-->
<form action ="Servlet"method="POST">
<input type="hidden" name="accion" value="insertarmarca">
<input type="text" name="marca">
<input type="submit">
</form>
<hr>
<!-- Formulario de insertar modelo -->
<form action="Servlet" method="POST">
<%String desplegable_marcas_2=PintarHTML.crearDesplegable(marcas, "marca", "");//El tercer argumento es para cuando seleccione
out.print(desplegable_marcas_2);
%>
<input type="text" name="modelo">
<input type="hidden" name="accion" value="insertarmodelo">
<input type="submit">
</form>
</body>
</html>
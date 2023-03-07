package paquetebiblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class PintarHTML {
public static String pintarTabla(ArrayList<Libro> lista_libros)
{
	String aux="<table>";
	for (int i=0; i<lista_libros.size(); i++)
	{
		Libro l=lista_libros.get(i);
		String txt_boton="";
		txt_boton=(l.getEstado()==0)?"PRESTAR":"DEVOLVER";
		//Hacerlo con el ternario
		/*if (l.getEstado()==0)
		{
			txt_boton="PRESTAR";
		}else
		{
			txt_boton="DEVOLVER";
		}*/
		aux+="<tr><td>"+l.getTitulo()+"</td><td>"+l.getGenero()+"</td>";
		aux+="<td>";
		aux+="<form action='Servlet'><input type='hidden' name='accion' value='cambioestado'>";
		aux+="<input type='hidden' name='id' value='"+l.getId()+"'>";
		aux+="<input type='submit' value='"+txt_boton+"'>";
		aux+="</form>";
		aux+="<td>";
		aux+="</tr>";
	}
	aux+="</table>";
	return aux;
}

public static String crearDesplegable(ArrayList<Genero> lista_datos, String nombre_select, String elem_seleccionado)
{
	
	String desplegable="<select name=\""+nombre_select+"\" onchange=verificarDesplegable();>\n";
	String seleccionado="";
	desplegable+="<option value=0 selected=true>Nuevo género</option> ";
	for(Genero dato: lista_datos)
	{
		seleccionado="";
		if (dato.equals(elem_seleccionado))
		{
			seleccionado="selected";
		}
		
		desplegable+="<option value='"+dato.getId()+"' "+seleccionado+" >"+dato.getGenero()+"</option>\n";
				
	}
	desplegable+="</select>";
	return desplegable;
}



}

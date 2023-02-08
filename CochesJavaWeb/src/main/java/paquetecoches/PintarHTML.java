package paquetecoches;

import java.util.ArrayList;

public class PintarHTML {
public static String crearDesplegable(ArrayList<String> lista_datos, String nombre_select, String elem_seleccionado)
	{
		String desplegable="<select name=\""+nombre_select+"\">\n";
		String seleccionado="";
		for(String dato: lista_datos)
		{
			seleccionado="";
			if (dato.equals(elem_seleccionado))
			{
				seleccionado="selected";
			}
			
			desplegable+="<option value='"+dato+"' "+seleccionado+" >"+dato.toUpperCase()+"</option>\n";
					
		}
		desplegable+="</select>";
		return desplegable;
	}
}
/*
 * <option selected>
 * 
 * 
 * */

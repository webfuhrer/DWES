package paqueteobjetos;
import java.util.ArrayList;

public class PintarHTML {
public static String crearOpcion(int indice, ArrayList<Ejercicio> lista_ejercicios)
	{
	//1-Crea desplegable con el nombre "ejercicio_indice"
	//2-Crea un cambpo de observaciones con el nombre "observaciones_indice"
	String nombre="ejercicio_"+indice;
	String combo="<select name="+nombre+">";
	for(int i=0; i<lista_ejercicios.size(); i++)
	{
		Ejercicio e=lista_ejercicios.get(i);
		combo+="\n<option value="+e.getId()+">"+e.getNombre()+"</option>";
	}
	
	combo+="\n</select>";
	String campo_obs="\n<textarea name=observaciones_"+indice+"></textarea>";
	return combo+"<br>"+campo_obs+"<hr>";
	
	}
public static String crearTabla(ArrayList<Entrenamiento> lista_entrenos)
{
	String tabla="<table>";
	tabla+="<tr><th>FECHA</th>"
			+ "<th>ejercicio 1</th>";
	tabla+="<th>ejercicio 2</th>";
	tabla+="<th>ejercicio 3</th>";
	tabla+="<th>ejercicio 4</th></tr>";
	for (int i=0; i<lista_entrenos.size(); i++)
	{
		Entrenamiento e=lista_entrenos.get(i);
		tabla+="<tr><td>"+e.getFecha()+"</td>";
		tabla+="<td>"+e.getEjercicios()[0]+"<i>"+e.getObservaciones()[0]+"</i>"+"</td>";
		tabla+="<td>"+e.getEjercicios()[1]+"<i>"+e.getObservaciones()[1]+"</i>"+"</td>";
		tabla+="<td>"+e.getEjercicios()[2]+"<i>"+e.getObservaciones()[2]+"</i>"+"</td>";
		tabla+="<td>"+e.getEjercicios()[3]+"<i>"+e.getObservaciones()[3]+"</i>"+"</td>";
		tabla+="</tr>";
		
	}
	
	tabla+="</table>";
	return tabla;
}
}

package paqueteexamen;

import java.util.ArrayList;

public class PintaHTML {
	public static String crearDesplegablePuntuacion()
	{
		String combo="<select name=puntuacion>";
		combo+="<option value='' selected>No quiero ahora</option>";
		for(int i=1; i<=5; i++)
		{
			combo+="<option value="+i+">"+i+"</option>";
		}
		combo+="</select>";
		return combo;
	}
public static String crearTabla(ArrayList<Libro> libros)
	{
	String combo="<select name=puntuacion>\n";
	 combo+="<option value=1>1</option>\n";
	 combo+="<option value=2>2</option>\n";
	 combo+="<option value=3>3</option>\n";
	 combo+="<option value=4>4</option>\n";
	 combo+="<option value=5>5</option>\n";
	 combo+="</select>";
	
	String tabla="<table>";
		for (int i=0; i<libros.size(); i++)
				{
					Libro l=libros.get(i);
					
					tabla+="<tr><td><img src="+l.getURL_portada()+" width=100></td>\n";
					tabla+="<td>"+l.getNombre()+"("+l.getAutor()+")"+"<br>\n";
					tabla+="<form action=Servlet method=POST>\n";
					tabla+="<input type=hidden name=ISBN value="+l.getISBN()+">\n";
					tabla+="<input type=hidden name=action value=puntuar_libro>";
					tabla+=combo;
					tabla+="<input type=submit>";
					tabla+="</form>\n";
					tabla+="<br>";
					tabla+=l.getAverage();
					tabla+="</td></tr>";
					
					
				}
		return tabla;	
				
	}
}

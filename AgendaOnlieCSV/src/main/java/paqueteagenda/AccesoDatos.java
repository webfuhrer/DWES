package paqueteagenda;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoDatos {
	public static void grabarEnCSV(String nombre,String telefono)
	{
		String linea=nombre.trim()+","+telefono.trim()+"\n";
		File archivo=new File("D:\\agenda.csv");
		
		String ruta=archivo.getAbsolutePath();
		try {
			FileWriter fw=new FileWriter(archivo, true);
			fw.write(linea);
			fw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<String> leerDatos()
	{
		String n="Pepe"; 
		String a="Jose";
		String m="Ana";
		ArrayList<String> lista=new ArrayList<String>();
		lista.add(n);
		lista.add(a);
		lista.add(m);
		return lista;
	}
	
	
	
}

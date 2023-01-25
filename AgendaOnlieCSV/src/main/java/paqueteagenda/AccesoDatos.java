package paqueteagenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	public static ArrayList<Contacto> leerDatos()
	{
		//1-Leo linea
		//2-Parto la linea
		//3-Creo un objeto
		//4-Lo meto en el ArrayList.
		File archivo=new File("D:\\agenda.csv");
		ArrayList<Contacto> lista=new ArrayList();
		try {
				FileReader fr=new FileReader(archivo);
				BufferedReader br=new BufferedReader(fr);
				String linea=br.readLine();
				
				while(linea!=null)
				{
					
					String[] datos=linea.split(",");
					String nombre=datos[0];
					String telefono=datos[1];
					Contacto c=new Contacto(nombre, telefono);
					lista.add(c);
					linea=br.readLine();
				}
		}
		catch (Exception e)
		{
			System.out.println("Algo ha ido mal: "+e.getLocalizedMessage());
		}
			
	
		return lista;
	}
	
	
	
}

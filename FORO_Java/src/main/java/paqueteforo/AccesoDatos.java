package paqueteforo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;



public class AccesoDatos {
private static String ruta="D:\\comentarios.csv";
	public static void grabarComentario(String usuario, String comentario) {
	Comentario c=new Comentario(usuario, comentario, Comentario.recuperarFechaFormateada());
	File archivo=new File(ruta);
	try {
		FileWriter fw=new FileWriter(archivo, true);
		fw.write(c.crearCSV());
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public static ArrayList<Comentario> cargarComentarios() {
		// 
		ArrayList<Comentario> comentarios=new ArrayList<Comentario>();
		try {
			FileReader fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			
			while(linea!=null)
			{
				
				String [] datos=linea.split(",");
				String usuario=datos[0];
				String comentario=datos[1];
				String fecha=datos[2];
				Comentario c=new Comentario(usuario, comentario, fecha);
				comentarios.add(c);
				 linea=br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comentarios;
	}

}

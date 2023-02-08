package paquetecoches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoDatos {
	private static String ruta="D:\\coches\\";

	public static ArrayList<String> recuperarModelosPorMarca(String marca) {
		// TODO Auto-generated method stub
		ArrayList<String> modelos=new ArrayList<String>();
		String nombre_fichero=marca+".csv";
		String ruta_completa=ruta+nombre_fichero;
		File archivo=new File(ruta_completa);
		try {
			FileReader fr=new FileReader(archivo);
			BufferedReader br=new BufferedReader(fr);
			String modelo=br.readLine();
			while(modelo!=null)
			{
				modelos.add(modelo);
				modelo=br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelos;
	}

	public static ArrayList<String> recuperarMarcas() {
		ArrayList<String> lista_marcas=new ArrayList<String>();
		File directorio=new File(ruta);
		String[] lista_ficheros=directorio.list();//audi.csv, ford.csv, kia.csv...
		for (String marca: lista_ficheros)
		{
			String[] datos=marca.split("\\.");//0->Audi, 1->csv
			lista_marcas.add(datos[0]);
		}
	return lista_marcas;
	}

}

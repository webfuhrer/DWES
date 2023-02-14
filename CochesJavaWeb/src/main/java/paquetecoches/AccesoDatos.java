package paquetecoches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class AccesoDatos {
	private static String ruta="D:\\coches\\";

	/*public static ArrayList<String> recuperarModelosPorMarca(String marca) {
		//select modelo from t_modelos where id_marca= (SELECT id from t_marcas where marca='Ford');
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
	}*/
	
	
	
	/*
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
	}*/
	
	
	//select modelo from t_modelos where id_marca= (SELECT id from t_marcas where marca='Ford');
	public static ArrayList<String> recuperarModelosPorMarca(String marca) {
		//select modelo from t_modelos where id_marca= (SELECT id from t_marcas where marca='Ford');
		// TODO Auto-generated method stub
		ArrayList<String> lista_modelos=new ArrayList<String>();
		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3307/coches?user=root&password=");
			String sql="select modelo from t_modelos where id_marca= (SELECT id from t_marcas where marca='"+marca+"')";
			Statement stmt=c.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String modelo=rs.getString("modelo");
				lista_modelos.add(modelo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista_modelos;
	}
	
	public static ArrayList<String> recuperarMarcas() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<String> lista_marcas=new ArrayList<String>();
		
		
		try {
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/coches?user=root&password=");
			String sql="SELECT marca FROM t_marcas";
			Statement stmt=c.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String marca=rs.getString("marca");
				lista_marcas.add(marca);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_marcas;
		
	}
}

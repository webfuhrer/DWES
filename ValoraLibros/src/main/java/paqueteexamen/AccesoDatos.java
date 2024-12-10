package paqueteexamen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class AccesoDatos {
private static String url_mysql="jdbc:mysql://localhost:3306/bd_examen";
private static String url_mongodb="mongodb://localhost:27017/";
private static String ruta_fichero="C:\\Users\\Profesor\\Documents\\dwes_luis\\libros.csv"; 
private static String usuario="root";
private static String password="";
private static Connection c=null;

//Hardcoded "JARCODEAR"
	private static void abrirConexion()  
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection(url_mysql, usuario, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
	}
	public static int getRol(String usr, String pwd) {
		// Este método devuelve el rol del usuario:
		//0 si no existe
		//1 si es usuario "normal"
		//2 si es admin
	abrirConexion();
		String sql="SELECT rol FROM t_usuarios where usr=? and pwd=?";
		try {
			
			PreparedStatement pstmt=c.prepareStatement(sql);
			pstmt.setString(1, usr);
			pstmt.setString(2, pwd);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==false) {return 0;}
			String rol=rs.getString("rol");
			rs.close();
			c.close();
			return(Integer.parseInt(rol));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static ArrayList<Libro> getLibros() {
		abrirConexion();
		String sql="SELECT * FROM t_libros";
		PreparedStatement pstmt;
		ArrayList<Libro> libros=new ArrayList();
		try {
			pstmt = c.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				String nombre=rs.getString("nombre");
				String autor=rs.getString("autor");
				String ISBN=rs.getString("ISBN");
				String URL_portada=rs.getString("URL_portada");
				String puntuaciones=rs.getString("puntuaciones");
				//(String iSBN, String nombre, String autor, String uRL_portada, String puntuaciones)
				Libro l=new Libro(ISBN, nombre, autor, URL_portada, puntuaciones);
				libros.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libros;
	}
	public static void updateReviews(String iSBN, String puntuacion) {
		// TODO Auto-generated method stub
		abrirConexion();
		//UPDATE t_libros SET puntuaciones = CASE WHEN puntuaciones = '' THEN 'VACIO' ELSE 'NO VACIO' END
				   //WHERE (ISBN=10)
		String sql="UPDATE t_libros "
				+ "   SET puntuaciones = CASE WHEN puntuaciones = '' THEN ? ELSE CONCAT(puntuaciones,?) END\r\n"
				+ "WHERE (ISBN=?)";
		//update t_libros set puntuaciones=concat(puntuaciones,'-0') where isbn=10
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, puntuacion);
			pstmt.setString(2, '-'+puntuacion);
			pstmt.setString(3, iSBN);
			pstmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void exportMongo() {
		// TODO Auto-generated method stub
		ConnectionString c=new ConnectionString(url_mongodb);
		
		MongoClientSettings s= MongoClientSettings.builder().applyConnectionString(c).build();
		
		MongoClient m=MongoClients.create(s);
		MongoDatabase db=m.getDatabase("local");
		MongoCollection<Document> collection=db.getCollection("libros");
		//Recuperar el ArrayList<Libro>
		ArrayList<Libro> libros=getLibros();
		for (int i=0; i<libros.size(); i++)
		{
			HashMap<String, Object> mapa=new HashMap();
			Libro l=libros.get(i);
			mapa.put("nombre", l.getNombre());
			mapa.put("autor", l.getAutor());
			mapa.put("ISBN", l.getISBN());
			mapa.put("imagen", l.getURL_portada());
			mapa.put("puntuaciones", l.getPuntuaciones());
			Document d=new Document(mapa);
			collection.insertOne(d);
		}
		
		
	}
	public static void exportCSV()
	{
		ArrayList<Libro> libros=getLibros();
		try {
			FileWriter fw=new FileWriter(ruta_fichero, false);
			for(int i=0; i<libros.size(); i++)
			{
				fw.write(libros.get(i).toCSV());
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insertarLibro(Libro l) {
		// TODO Auto-generated method stub
		abrirConexion();
		String sql="INSERT INTO t_libros VALUES(?, ?, ?, ?, ?);";
		try {
			PreparedStatement pstmt=c.prepareStatement(sql);
			pstmt.setString(1, l.getISBN());
			pstmt.setString(2, l.getURL_portada());
			pstmt.setString(3, l.getNombre());
			pstmt.setString(4, l.getAutor());
			pstmt.setString(5, l.getPuntuaciones());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("El ISBN "+l.getISBN()+" está repetido");
		}
	}
	public static void importarCSV() {
		// TODO Auto-generated method stub
		//nombre,autor,URL_portada,ISBN,puntuaciones
		try {
			FileReader fr=new FileReader(ruta_fichero);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			ArrayList<Libro> listaLibros=new ArrayList<Libro>();
			while(linea != null)
			{
				String[] datos=linea.split(",");
				String nombre=datos[0];
				String autor=datos[1];
				String URL_portada=datos[2];
				String ISBN=datos[3];
				String puntuaciones=datos[4];
				//String iSBN, String nombre, String autor, String uRL_portada, String puntuaciones
				Libro l=new Libro(ISBN, nombre, autor, URL_portada, puntuaciones);
				listaLibros.add(l);
				linea=br.readLine();
				
			}
			insertarEnBD(listaLibros);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void insertarEnBD(ArrayList<Libro> listaLibros) {
		// TODO Auto-generated method stub
		for (int i=0; i<listaLibros.size(); i++)
		{
			insertarLibro(listaLibros.get(i));
		}
		
	}

}

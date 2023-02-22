package paquetebiblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import paquetebiblioteca.Libro;
public class AccesoDatos {
	private static Connection c=null;
	
	public static void actualizarEstado(int id) {
		abrirConexion();
		try {
			Statement stmt=c.createStatement();
			String sql="update `t_libros` set estado=!estado where id="+id;
			//2-Lanzar update del estado del libro con id=id
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1 Conectarse
		
	}

	private static void abrirConexion() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties p=new Properties();
		p.setProperty("user","root");
		
		c=DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca", p);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

	public static void insertarLibro(Libro libro) {
		abrirConexion();
		try {
			Statement stmt=c.createStatement();
			//INSERT INTO t_libros (titulo, genero, estado) VALUES(...)
			//Desfase objeto-relacional. ORM. P. ej. Hibernate
			String sql="INSERT INTO t_libros(titulo, genero, estado ) VALUES"
					+ " ('"+libro.getTitulo()+"', '"+libro.getGenero()+"', "+libro.getEstado()+")";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Libro> recuperarLibros() {
		ArrayList<Libro> lista_libros=new ArrayList<Libro>();
		if(c==null)
		{abrirConexion();}
		try {
			Statement stmt=c.createStatement();
			String sql= "SELECT * FROM t_libros";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String titulo=rs.getString("titulo");
				String genero=rs.getString("genero");
				int id=rs.getInt("id");
				int estado=rs.getInt("estado");
				Libro libro=new Libro(titulo, genero, id, estado);
				lista_libros.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista_libros;
	}

}

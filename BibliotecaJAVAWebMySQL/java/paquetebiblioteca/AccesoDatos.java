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
//ORM 
	public static ArrayList<Libro> recuperarLibros() {
		ArrayList<Libro> lista_libros=new ArrayList<Libro>();
		/*SELECT t_libros.id, t_libros.titulo, t_libros.estado, t_generos.genero FROM `t_libros` INNER JOIN t_generos ON t_libros.genero=t_generos.id;*/
		if(c==null)
		{abrirConexion();}
		try {
			Statement stmt=c.createStatement();
			String sql= "SELECT t_libros.id, t_libros.titulo, t_libros.estado, t_generos.genero FROM `t_libros` INNER JOIN t_generos ON t_libros.genero=t_generos.id";
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

	public static int insertarGenero(String n_genero) {
		// TODO Auto-generated method stub
		abrirConexion();
		int id=0;
		Statement stmt;
		try {
			stmt = c.createStatement();
			String sql="INSERT INTO t_generos (genero) VALUES ('"+n_genero+"')";
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS );
			ResultSet rs=stmt.getGeneratedKeys();
			rs.next();
			id=rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public static ArrayList<Genero> recuperarGeneros() {
		// TODO Auto-generated method stub
		ArrayList<Genero> lista_generos=new ArrayList<Genero>();
		abrirConexion();
		Statement stmt;
		try {
			stmt = c.createStatement();
			String sql= "SELECT * FROM t_generos";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String genero=rs.getString("genero");
				int id=rs.getInt("id");
				
				Genero g=new Genero(genero, id);
				lista_generos.add(g);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		return lista_generos;
	}

}

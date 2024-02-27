package paquetedatos;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import paqueteobjetos.Ejercicio;
import paqueteobjetos.Entrenamiento;
import paqueteobjetos.PintarHTML;

public class AccesoDatos {
	private static Connection c=null;
	private static void createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gimnasio?user=root");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String checkUser(String usuario, String password) {
		//rol es null si el usuario no xiste
		createConnection();
		String rol=null;
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT rol FROM t_usuarios WHERE usuario=? AND password=?");
			pstmt.setString(1, usuario);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
			rol=rs.getString("rol");
			return rol;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Ejercicio> getExercices() {
		createConnection();
		ArrayList<Ejercicio> lista_ejercicios=new ArrayList<Ejercicio>();
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT * FROM t_ejercicios");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String nombre=rs.getString("nombre");
				Ejercicio e=new Ejercicio(nombre, id);
				lista_ejercicios.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_ejercicios;
				
		
	}

	public static void grabarEntrenamiento(Entrenamiento e) {
		createConnection();
		try {
			PreparedStatement pstmt=c.prepareStatement("INSERT INTO t_entrenamiento"
					+ " (usuario,fecha, ejercicio1, ejercicio2, ejercicio3, ejercicio4,"
					+ " obs1, obs2, obs3, obs4)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, e.getUsuario());
			pstmt.setString(2, e.getFecha());
			for(int i=0; i<e.getEjercicios().length; i++)
			{
				pstmt.setString(i+3, e.getEjercicios()[i] );
				pstmt.setString(i+7, e.getObservaciones()[i] );
			}
			pstmt.execute();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}

	public static void registrar(String usuario, String password) {
		createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement("INSERT INTO t_usuarios (usuario, password, rol) VALUES (?, ?, ?)");
			pstmt.setString(1, usuario);
			pstmt.setString(2, password);
			pstmt.setString(3, "user");
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void crearEjercicio(String nombre) {
		createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement("INSERT INTO t_ejercicios (nombre) VALUES (?)");
			pstmt.setString(1, nombre);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Entrenamiento> recuperarEntrenos(String usuario) {
		// TODO Auto-generated method stub
		ArrayList<Entrenamiento> lista_entrenamientos=new ArrayList<Entrenamiento>();
		String sql="SELECT id, usuario,obs1,obs2,obs3,obs4,fecha,\r\n"
				+ "(SELECT nombre FROM t_ejercicios WHERE t_ejercicios.id=t_entrenamiento.ejercicio1) as ej1,\r\n"
				+ "(SELECT nombre FROM t_ejercicios WHERE t_ejercicios.id=t_entrenamiento.ejercicio2) as ej2,\r\n"
				+ "(SELECT nombre FROM t_ejercicios WHERE t_ejercicios.id=t_entrenamiento.ejercicio3) as ej3,\r\n"
				+ "(SELECT nombre FROM t_ejercicios WHERE t_ejercicios.id=t_entrenamiento.ejercicio4) as ej4\r\n"
				+ "FROM `t_entrenamiento` WHERE usuario=?;";
		createConnection();
		PreparedStatement pstmt;
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1, usuario);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				String[] ejercicios=new String[4];
				String[] observaciones=new String[4];
				
				String nombre_usuario=rs.getString("usuario");
				String fecha=rs.getString("fecha");
				int id=rs.getInt("id");
				for(int i=1; i<5; i++)
				{
					String campo_obs="obs"+i;
					String campo_ej="ej"+i;
					ejercicios[i-1]=rs.getString(campo_ej);
					observaciones[i-1]=rs.getString(campo_obs);
					
				}
				Entrenamiento e=new Entrenamiento(id, usuario, fecha, ejercicios, observaciones);
				lista_entrenamientos.add(e);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROOR "+e.getLocalizedMessage());
		}
		return lista_entrenamientos;
	}

	public static void exportarCSV(ArrayList<Entrenamiento> lista_entrenos) {
		try {
			FileWriter fw=new FileWriter("C:\\datos\\entrenos.csv")		;
			for(int i=0; i<lista_entrenos.size(); i++)
			{
				fw.write(lista_entrenos.get(i).toCSV());
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void crearHTML(String usuario) {
		// TODO Auto-generated method stub
		String html="<html><head><title>ENTRENOS DE "+usuario+"</title></head>\n";
		html+="<body><h1>Entrenos de "+usuario+"</h1>\n";
		html+="<br>";
		html+=PintarHTML.crearTabla(recuperarEntrenos(usuario));
		html+="</body></html>\n";
		try {
			FileWriter fw=new FileWriter("C:\\datos\\entrenos.html");
			fw.write(html);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}


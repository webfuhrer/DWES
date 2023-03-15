package paquetenoticias;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoDatos {
static Connection c=null;
static Statement stmt=null;
public static void abrirConexion() throws SQLException, ClassNotFoundException
{
	Class.forName("com.mysql.jdbc.Driver");
	c=DriverManager.getConnection("jdbc:mysql://localhost:3307/examennoticias", "root", "");
								
	stmt=c.createStatement();
}
public static ArrayList<Noticia> recuperarNoticias(String idioma) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Noticia> lista_noticias=new ArrayList<Noticia>();
		abrirConexion();
		String sql="SELECT * FROM t_noticias where idioma=\""+idioma+"\"";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			int id=rs.getInt("id");
			String titular=rs.getString("titular");
			String cuerpo=rs.getString("cuerpo");
			Noticia n=new Noticia(id, idioma, titular, cuerpo);
			lista_noticias.add(n);
		}
		return lista_noticias;
	}
public static void insertarNoticia(Noticia n) throws SQLException, ClassNotFoundException {
	abrirConexion();
	String sql="INSERT INTO t_noticias (idioma, titular, cuerpo) VALUES ('"+n.getIdioma()+"','"
			+n.getTitular()+"', '"+n.getCuerpo()+"')";
	stmt.executeUpdate(sql);
}
public static void exportarCSV() throws SQLException, IOException, ClassNotFoundException {
	ArrayList<Noticia> noticias_ES=recuperarNoticias("ES");
	ArrayList<Noticia> noticias_EN=recuperarNoticias("EN");
	File f=new File("D://noticias.csv");
	FileWriter fw=new FileWriter(f);
	for (int i=0; i<noticias_ES.size(); i++)
	{
		Noticia n=noticias_ES.get(i);
		fw.write(n.toCSV());
		
	}
	for (int i=0; i<noticias_EN.size(); i++)
	{
		Noticia n=noticias_EN.get(i);
		fw.write(n.toCSV());
	}
	fw.close();
	
	
}

}

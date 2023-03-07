package paquetebiblioteca;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		//La BD se llama biblioteca y el tabla t_libros
		if (accion==null)
		{
			//Caso a. Llego de inicio
			
		}else if (accion.equals("cambioestado"))
		{
			//Caso b
			String str_id=request.getParameter("id");
			int id=Integer.parseInt(str_id);
			AccesoDatos.actualizarEstado(id);
			
			
		}else if (accion.equals("insertar"))
		{
		//Caso c
			String titulo=request.getParameter("titulo");
			String genero=request.getParameter("genero");
			//c.2 Insertar libro implica crear un objeto libro y enviarlo a AccesoDatos
			Libro libro=new Libro(titulo, genero, 0, 0);
			AccesoDatos.insertarLibro(libro);
			
		}else if (accion.equals("nuevogenero"))
		{//1-Recupero n_genero y titulo
			String n_genero=request.getParameter("n_genero");
			String titulo=request.getParameter("titulo");
			
			//2-Compruebo que n_genero no esté vacío
			if (!n_genero.equals(""))
			{
				//3-Inserto n_genero en t_generos
				int id_genero=AccesoDatos.insertarGenero(n_genero);
				//4-Inserto el libro en t_libros
				//4.1-Crear libro
				Libro l=new Libro(titulo, String.valueOf(id_genero), 0, 0);
				//5-Grabar libro
				AccesoDatos.insertarLibro(l);
			}
			
		}
		else if (accion.equals("insertarlibro"))
		{
			//1-Recupero generos de BD
			ArrayList<Genero> lista_generos=AccesoDatos.recuperarGeneros();
			//2-Meto los generos en el atributo lista_generos
			request.setAttribute("lista_generos", lista_generos);
			//3-Le mando a insertarlibros.jsp
			request.getRequestDispatcher("insertarlibros.jsp").forward(request, response);
		}
		//Lo que hay a continuación siempre se ejecuta
		ArrayList<Libro> lista_libros=AccesoDatos.recuperarLibros();
		request.setAttribute("lista_libros", lista_libros);
		request.getRequestDispatcher("verlibros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

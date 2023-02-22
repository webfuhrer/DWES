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
			
		}
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

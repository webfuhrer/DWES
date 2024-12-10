package paqueteexamen;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		switch (action) {
		case "ver":		
				redirectBooksList(request, response);
			break;
		case "login":
			String usr=request.getParameter("usr");
			String pwd=request.getParameter("pwd");
			int rol=AccesoDatos.getRol(usr, pwd);
			manageRol(rol, response);
			break;
		case "puntuar_libro":
			//1-Recupero el ISBN
			String ISBN=request.getParameter("ISBN");
			
			//2-Recupero la puntuacion
			String puntuacion=request.getParameter("puntuacion");
			//3-Se lo paso a Acceso DAtos y que se encargue
			AccesoDatos.updateReviews(ISBN, puntuacion);
			//4-Recupero de nuevo los libros y se los vuelvo a mostrar
			
				redirectBooksList(request, response);
			break;
		case "exportMongoDB":
			AccesoDatos.exportMongo();
			break;
		case "insertar_libro":
			//1-Recuperar los datos del libro
			//2-
			String nombre_=request.getParameter("nombre");
			String ISBN_=request.getParameter("ISBN");
			String autor=request.getParameter("autor");
			String puntuacion_=request.getParameter("puntuacion");
			String URL_portada=request.getParameter("URL_portada");
			//Libro(String iSBN, String nombre, String autor, String uRL_portada, String puntuaciones) {
			Libro l=new Libro(ISBN_, nombre_, autor, URL_portada, puntuacion_);
			AccesoDatos.insertarLibro(l);
			//AccesoDatos.insertarLibro(nombre, ISBN, .action..)
			break;
		case "importarCSV":
			AccesoDatos.importarCSV();
			break;
		case "exportCSV":
			AccesoDatos.exportCSV();
			break;
		}
			
	}

	private void redirectBooksList(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//1-REcuperar los libros
		ArrayList<Libro> libros=AccesoDatos.getLibros();
		//2-Meterlos en un attribute
		request.setAttribute("libros", libros);
		//3-Ir a mostrarlibros.jsp
		request.getRequestDispatcher("mostrarlibros.jsp").forward(request, response);
	
	}
	private void manageRol(int rol, HttpServletResponse response) throws IOException  {
		switch(rol) {
		case 0:
			response.sendRedirect("indice.jsp");
			break;
		case 1:
			response.sendRedirect("insertarlibros.jsp");
			break;
			
		case 2:
			response.sendRedirect("insertarusuariosylibros.jsp");
			break;
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

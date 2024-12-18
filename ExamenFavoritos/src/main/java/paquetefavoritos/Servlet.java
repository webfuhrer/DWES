package paquetefavoritos;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		try {
			switch (action) {
			case "listarfavoritos":
				ArrayList<Favorito> lista_favoritos=AccesoDatos.recuperarFavoritos();
				request.setAttribute("favoritos", lista_favoritos);
				request.getRequestDispatcher("listarfavoritos.jsp").forward(request, response);
				break;
			case "crearfavorito":
				ArrayList<Tematica> lista_tematicas=AccesoDatos.recuperarTematicas();
				request.setAttribute("lista_tematicas", lista_tematicas);
				request.getRequestDispatcher("crearfavorito.jsp").forward(request, response);
				break;
			case "creartematica":
				request.getRequestDispatcher("creartematica.jsp").forward(request, response);
				break;
			case "insertarfavorito":
				//Aquí se recuperan los datos y se meten en MongoDB...
				break;
			case "insertartematica":
				//Aquí se recuperan los datos y se meten en MongoDB...
				break;	
			}
			
		}
		catch(Exception e)
		{
			response.sendRedirect("error.jsp");
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

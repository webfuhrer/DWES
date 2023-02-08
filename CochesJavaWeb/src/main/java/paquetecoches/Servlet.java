package paquetecoches;

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
		// TODO Auto-generated method stub
		String marca=request.getParameter("marca");
		if (marca==null)
		{
			//Vengo del caso 1 (inicialización)
			
			
			
		}
		else
		{
			//Caso 4
			//Busco los modelos de la marca
			ArrayList<String> lista_modelos=AccesoDatos.recuperarModelosPorMarca(marca);
			
			//Enviar modelos a vercoches.jsp
			request.setAttribute("modelos", lista_modelos);
			request.setAttribute("marca_seleccionada", marca);
		}
		//Recuperar las marcas
		ArrayList<String> lista_marcas=AccesoDatos.recuperarMarcas();
		//Enviar las marcas a vercoches.jsp
		request.setAttribute("marcas", lista_marcas);
		request.getRequestDispatcher("vercoches.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

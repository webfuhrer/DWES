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
		String accion=request.getParameter("accion");
		if (accion==null)
		{
			//Vengo de caso 1
			
		}else if (accion.equals("vermodelospormarcas"))
		{
			//Vengo de caso 3
			String marca=request.getParameter("marca");
			ArrayList<String> lista_modelos=AccesoDatos.recuperarModelosPorMarca(marca);
			request.setAttribute("modelos", lista_modelos);
			request.setAttribute("marca_seleccionada", marca);
			
		}else if (accion.equals("insertarmarca"))
		{
			//Vengo de caso 4
			String marca=request.getParameter("marca");
			AccesoDatos.insertarMarca(marca);
				
						
		}else if (accion.equals("insertarmodelo"))
		{
			//Vengo de caso 5
			String marca=request.getParameter("marca");
			String modelo=request.getParameter("modelo");
			AccesoDatos.insertarModelo(marca, modelo);
			
		}
		
		
		/*Lo que se hace siempre:*/
		ArrayList<String> lista_marcas=AccesoDatos.recuperarMarcas();
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

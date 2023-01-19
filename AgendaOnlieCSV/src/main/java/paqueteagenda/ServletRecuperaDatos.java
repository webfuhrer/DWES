package paqueteagenda;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRecuperaDatos
 */
@WebServlet("/ServletRecuperaDatos")
public class ServletRecuperaDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRecuperaDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String accion=request.getParameter("accion");
		if (accion.equals("listar"))
		{
		ArrayList<String> contactos=AccesoDatos.leerDatos();
		request.setAttribute("datos", contactos);
		request.getRequestDispatcher("leercontactos.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre=request.getParameter("nombre");
		String telefono=request.getParameter("telefono");
		//Persona p=new Persona();
		//Persona j=new Persona();
		//p.setNombre("pepe");
		//objeto.metodo
		//Clase.metodo
		//double x=Math.random();
		AccesoDatos.grabarEnCSV(nombre, telefono);
		
	}

}

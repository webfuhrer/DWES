package paqueteservlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquetedatos.AccesoDatos;
import paqueteobjetos.Ejercicio;
import paqueteobjetos.Entrenamiento;

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
		switch(accion)
		{
		case "login":
			gestionarLogin(request, response);
			break;
		case "verentrenos":
			mostrarEntrenos(request, response);
			break;
		case "crearentreno":
			crearEntreno(request, response);
			break;
		case "crearusuario":
			crearUsuario(request, response);
			break;
		case "crearejercicio":
			crearEjercicio(request, response);
			break;
		case "exportar":
			exportarEntrenos(request, response);
			break;
		default:
			
			break;
		}
		/*if (accion.equals("login"))
		{
			gestionarLogin(request, response);
		}else if (accion.equals(""))*/
	}

	
	private void exportarEntrenos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String usuario=request.getParameter("usuario");
		ArrayList<Entrenamiento> lista_entrenos=AccesoDatos.recuperarEntrenos(usuario);
		AccesoDatos.exportarCSV(lista_entrenos);
	}

	private void crearEjercicio(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String nombre=request.getParameter("nombre_ejercicio");
		AccesoDatos.crearEjercicio(nombre);
		
	}

	private void crearUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//usuario password
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		
		AccesoDatos.registrar(usuario, password);
	}

	private void crearEntreno(HttpServletRequest request, HttpServletResponse response) {
		//Recuperar los parámetros ejercicio_x y observaciones_x
		Entrenamiento e=null;
		String[] ejercicios=new String[4];
		String[] observaciones=new String[4];
		for(int i=1; i<5; i++)
		{
			//Voy a ir recuperando ejercicio_x , observaciones_x
			String ejercicio=request.getParameter("ejercicio_"+i);
			String observacion=request.getParameter("observaciones_"+i);
			ejercicios[i-1]=ejercicio;
			observaciones[i-1]=observacion;
		}
		String usuario=request.getParameter("usuario");
		LocalDateTime l=LocalDateTime.now();
		int dia=l.getDayOfMonth();
		int mes=l.getMonthValue();
		int anyo=l.getYear();
		String fecha=dia+"/"+mes+"/"+anyo;
		//Entrenamiento(int id, String usuario, String fecha, String[] ejercicios, String[] observaciones) {
		e=new Entrenamiento(0, usuario, fecha, ejercicios, observaciones);
		AccesoDatos.grabarEntrenamiento(e);
	}

	private void mostrarEntrenos(HttpServletRequest request, HttpServletResponse response) {
		String usuario=request.getParameter("usuario");
		ArrayList<Entrenamiento> lista_entrenos=AccesoDatos.recuperarEntrenos(usuario);
		request.setAttribute("lista_entrenos", lista_entrenos);
		request.setAttribute("usuario", usuario);
		try {
			request.getRequestDispatcher("verentrenos.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void gestionarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		String rol=AccesoDatos.checkUser(usuario, password);
		//rol es null si el usuario no xiste
		if (rol==null)
		{
			//Podríamos meter un atributo de "usuario no encontrado"
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if (rol.equals("admin"))
		{
			//Le mandamos a crearejercicio.jsp
			request.setAttribute("master", "OK");
			request.getRequestDispatcher("crearejercicio.jsp").forward(request, response);
			
		}
		else if(rol.equals("user"))
		{
			//Le mandamos a crearentreno.jsp con los atributos usuario y 
			//y lista_ejercicios
			ArrayList<Ejercicio> lista_ejericios=AccesoDatos.getExercices();
			request.setAttribute("lista_ejercicios", lista_ejericios);
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("crearentreno.jsp").forward(request, response);;
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

package paquetenoticias;

import java.io.IOException;
import java.sql.SQLException;
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
		try {
			if (accion==null || accion.equals("cambiaridiomaES"))
			{
				//Acabo de llegar (o cambiar a español):
				//1-Recupero las noticias en español
				ArrayList<Noticia> lista_noticias=AccesoDatos.recuperarNoticias("ES");
				//2-Meto las noticias como atributo en el request
				request.setAttribute("lista_noticias", lista_noticias);
				//(lista_noticias)
				//3-Meto el idioma en un atributo en el request
				//(idioma=ES / EN)
				request.setAttribute("idioma", "ES");
				//4-Mando a vernoticia.jsp
				request.getRequestDispatcher("vernoticia.jsp").forward(request, response);
			}
			else if(accion.equals("cambiaridiomaEN"))
			{
				//significa que quiere ver las noticias en inglés (EN)
				//Acabo de llegar (o cambiar a español):
				//1-Recupero las noticias en español
				ArrayList<Noticia> lista_noticias=AccesoDatos.recuperarNoticias("EN");
				//2-Meto las noticias como atributo en el request
				request.setAttribute("lista_noticias", lista_noticias);
				//(lista_noticias)
				//3-Meto el idioma en un atributo en el request
				//(idioma=ES / EN)
				request.setAttribute("idioma", "EN");
				//4-Mando a vernoticia.jsp
				request.getRequestDispatcher("vernoticia.jsp").forward(request, response);
			}else if (accion.equals("grabar"))
			{
				String titular_ES=request.getParameter("titular_ES");
				String titular_EN=request.getParameter("titular_EN");
				String cuerpo_ES=request.getParameter("cuerpo_ES");
				String cuerpo_EN=request.getParameter("cuerpo_EN");
				Noticia n_ES=new Noticia("ES", titular_ES, cuerpo_ES);
				Noticia n_EN=new Noticia("EN", titular_EN, cuerpo_EN);
				AccesoDatos.insertarNoticia(n_ES);
				AccesoDatos.insertarNoticia(n_EN);
				
			}
			else if (accion.equals("exportar"))
			{
				AccesoDatos.exportarCSV();
			}
		}
		catch (SQLException e)
		{
			//Escribir en log qué ha pasado
			System.out.println(e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		catch(IOException e)
		{
			//Escribir en log qué ha pasado
			System.out.println(e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		catch(ClassNotFoundException e)
		{
			//Escribir en log qué ha pasado
			System.out.println(e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
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

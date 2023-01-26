package paqueteforo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario=request.getParameter("usuario");
		String comentario=request.getParameter("comentario");
		HttpSession session=request.getSession();
		if (usuario!=null)
		{
			//Vengo de indice.jsp
			
			session.setAttribute("usuario", usuario);
			
		}
		else if (comentario!=null)
		{
			//Vengo de vercomentarios.jsp
			//Grabar comentario. Necesito el usuario
			usuario=(String)session.getAttribute("usuario");
			AccesoDatos.grabarComentario(usuario, comentario);
		}
		cargarComentariosYEnviar(request, response);
	}

	private void cargarComentariosYEnviar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<Comentario> comentarios=AccesoDatos.cargarComentarios();
		request.setAttribute("comentarios", comentarios);
		try {
			request.getRequestDispatcher("vercomentarios.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import model.Usuario;

import java.util.ArrayList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Servelt Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//codigo de  login aqui
		String usuario = request.getParameter("usuario");
		String contra = request.getParameter("contra");

		UsuarioDao udao =new UsuarioDao();
		Usuario user = new Usuario();
		user.setUser(usuario);
		user.setPass(contra);


		if (udao.esValido(user)){
			//System.out.println(request.getParameterNames());
			HttpSession misesion = request.getSession();
			misesion.setAttribute("usuario", usuario);
			
			response.sendRedirect("app.jsp");
		}
		else{
			ArrayList<String> salida = new ArrayList<String>();
			salida.add("Usuario o contraseña no validos");
			request.setAttribute("error", salida);
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

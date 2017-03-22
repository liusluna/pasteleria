package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		
		Usuarios usuarios = new Usuarios();
		/*usuarios.addUsuario("1", "1");
		usuarios.addUsuario("Rafa", "Chagolla");
		usuarios.addUsuario("Jose", "Nador");
		usuarios.addUsuario("Sergio", "Galvan");
		usuarios.addUsuario("Jose", "Nabas");
		*/
		
		if(usuarios.getNumero()==0){
			ArrayList<String> salida = new ArrayList<String>();
			salida.add("No hay conexión a la base de datos");
			salida.add("o no hay usuarios registrados");
			salida.add("Favor de contactar al Administrador");
			request.setAttribute("error", salida);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
			
		


		if (usuarios.isvalid(usuario, contra)){
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

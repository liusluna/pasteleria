package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import model.*;

/**
 * Servlet implementation class PedidoServlet
 */
@WebServlet("/Pedido")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession misesion = request.getSession(false);
		
		if (misesion.getAttribute("usuario") == null) {	
			request.getRequestDispatcher("timeout.html").forward(request, response);
		}
		
		if (request.getParameter("operacion").equals("muestra")){
		
			ClipropedDao cdao = new ClipropedDao();
			
			List<Cliproped> lista = null;
			try {
				lista = cdao.getAll();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al intentar listar los clientes: " + e.getMessage());

			} 
				misesion.setAttribute("pedidos", lista);
				request.setAttribute("tipo","pedidos");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			
				
		//fin mostrar	
	}else if (request.getParameter("operacion").equals("actualiza")){
		PedidoDao pdao = new PedidoDao();
		ArrayList<String> salida = new ArrayList<String>();
		if (pdao.actualiza(Integer.parseInt(request.getParameter("pedido"))) ){
			salida.add("Cliente agregado: ");
			salida.add("de la base de datos");
			request.setAttribute("info", salida);
			request.setAttribute("tipo","info");
			request.setAttribute("pagina","1");
			request.getRequestDispatcher("Muestra.jsp").forward(request, response);
		}else {
			salida.add("Cliente NO agregado");
			salida.add("hubo un error al agregar cliente ");
			request.setAttribute("info", salida);
			request.setAttribute("tipo","info");
			request.setAttribute("pagina","1");
			request.getRequestDispatcher("Muestra.jsp").forward(request, response);
		}
	//fin actualiza	
	}else{
		Enumeration<?> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = (String)params.nextElement();
		 System.out.println("Parameter Name:["+paramName+"], Value:["+request.getParameter(paramName)+"]");
		}
		
		request.getRequestDispatcher("app.jsp").forward(request, response);
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

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
				misesion.setAttribute("pedido", lista);
				request.setAttribute("tipo","pedidos");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			
				
		//fin mostrar	
	}else if (request.getParameter("operacion").equals("actualiza")){
		PedidoDao pdao = new PedidoDao();
		
		if (pdao.actualiza(Integer.parseInt(request.getParameter("pedido"))) ){
			request.getRequestDispatcher("Pedido?operacion=muestra&").forward(request, response);
		}else {
			ArrayList<String> salida = new ArrayList<String>();
			salida.add("Pedido NO actualizdo");
			salida.add("hubo un error al actualizar pedio ");
			request.setAttribute("info", salida);
			request.setAttribute("tipo","info");
			request.setAttribute("pagina","1");
			request.getRequestDispatcher("Muestra.jsp").forward(request, response);
		}
	//fin actualiza	
	}else if (request.getParameter("operacion").equals("agregar")){
		
		ClipropedDao cdao = new ClipropedDao();
		
		if ( cdao.agrega(request.getParameter("descripcion"), request.getParameter("fecha")+" "+request.getParameter("hora")+":00", Integer.parseInt(request.getParameter("cliente")), Integer.parseInt(request.getParameter("producto"))) ){
			request.getRequestDispatcher("Pedido?operacion=muestra&").forward(request, response);
		}else {
			ArrayList<String> salida = new ArrayList<String>();
			salida.add("Pedido NO agregado");
			salida.add("hubo un error al agregar el pedio ");
			request.setAttribute("info", salida);
			request.setAttribute("tipo","info");
			request.setAttribute("pagina","1");
			request.getRequestDispatcher("Muestra.jsp").forward(request, response);
		}
	//fin agrega	
	}else if (request.getParameter("operacion").equals("eliminar")){
		//PedidoDao pdao = new PedidoDao();
		PedidoDao pdao = new PedidoDao();
		
		if ( pdao.elimina(Integer.parseInt(request.getParameter("pedido"))) ){
			request.getRequestDispatcher("Pedido?operacion=muestra&").forward(request, response);
		}else {
			ArrayList<String> salida = new ArrayList<String>();
			salida.add("Pedido NO eliminado");
			salida.add("hubo un error al eliminar el pedio ");
			request.setAttribute("info", salida);
			request.setAttribute("tipo","info");
			request.setAttribute("pagina","1");
			request.getRequestDispatcher("Muestra.jsp").forward(request, response);
		}
	//fin agrega	
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

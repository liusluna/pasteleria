package servlet;

import model.Cliente;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.io.IOException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/Cliente")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
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
		
			
			ClienteDao cdao = new ClienteDao();
			List<Cliente> listaClientes = null;
			try {
				listaClientes = cdao.getAll();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al intentar listar los clientes: " + e.getMessage());

			} 
				misesion.setAttribute("clientes", listaClientes);
				request.setAttribute("tipo","clientes");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			
				
		//fin mostrar
		}else if(request.getParameter("operacion").equals("eliminar")){
			int id = Integer.parseInt(request.getParameter("cliente"));
			ClienteDao cdao = new ClienteDao();
			
			if (cdao.borra(id) ){
				ArrayList<String> salida = new ArrayList<String>();
				salida.add("Cliente eliminado: "+id);
				salida.add("de la base de datos");
				request.setAttribute("info", salida);
				request.setAttribute("tipo","info");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			} else {
				ArrayList<String> salida = new ArrayList<String>();
				salida.add("Cliente NO eliminado");
				salida.add("hubo un error eliminar el usuario id: "+id);
				request.setAttribute("info", salida);
				request.setAttribute("tipo","info");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			}
			
			
		}else if(request.getParameter("operacion").equals("agregar")){
			//int id = Integer.parseInt(request.getParameter("cliente"));
			ClienteDao cdao = new ClienteDao();
			Cliente cliente = new Cliente();
			
			cliente.setRfc(request.getParameter("rfc"));
			cliente.setRazon(request.getParameter("razon"));
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApmaterno(request.getParameter("apmaterno"));
			cliente.setAppaterno(request.getParameter("appaterno"));
			cliente.setDireccion(request.getParameter("direccion"));
			cliente.setColonia(request.getParameter("colonia"));
			cliente.setMunicipio(request.getParameter("municipio"));
			cliente.setEstado(request.getParameter("estado"));
			
			
			if (cdao.agrega(cliente) ){
				ArrayList<String> salida = new ArrayList<String>();
				salida.add("Cliente agregado: ");
				salida.add("de la base de datos");
				request.setAttribute("info", salida);
				request.setAttribute("tipo","info");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			} else {
				ArrayList<String> salida = new ArrayList<String>();
				salida.add("Cliente NO agregado");
				salida.add("hubo un error al agregar cliente ");
				request.setAttribute("info", salida);
				request.setAttribute("tipo","info");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			}
			
		}else{
			Enumeration params = request.getParameterNames(); 
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

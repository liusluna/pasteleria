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

import dao.ProductoDao;
import model.Productos;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/Producto")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
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
		
			
			ProductoDao cdao = new ProductoDao();
			List<Productos> listaProductos = null;
			try {
				listaProductos = cdao.getAll();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al intentar listar los productos: " + e.getMessage());

			} 
				misesion.setAttribute("productos", listaProductos);
				request.setAttribute("tipo","productos");
				request.setAttribute("pagina","1");
				request.getRequestDispatcher("Muestra.jsp").forward(request, response);
			
				
		//fin mostrar
		}else if(request.getParameter("operacion").equals("eliminar")){
			int id = Integer.parseInt(request.getParameter("producto"));
			ProductoDao cdao = new ProductoDao();
			
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
			ProductoDao cdao = new ProductoDao();
			Productos producto = new Productos();
			
			producto.setNombre(request.getParameter("nombre"));
			producto.setDescripcion(request.getParameter("descripcion"));
			producto.setCosto(Double.parseDouble(request.getParameter("costo")));
			producto.setVenta(Double.parseDouble(request.getParameter("venta")));
			
			
			
			if (cdao.agrega(producto) ){
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

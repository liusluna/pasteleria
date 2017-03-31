<%@page import="java.util.*"%>

<%@page import="model.*"%>


<%
	String titulo="";
	String tipo="";
	if(request.getAttribute("tipo")!=null){
		tipo=(String) request.getAttribute("tipo");
	}else if (request.getParameter("tipo")!=null){
		tipo=(String) request.getParameter("tipo");
	}else{
		Enumeration params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = (String)params.nextElement();
		 System.out.println("Parameter Name:["+paramName+"], Value:["+request.getParameter(paramName)+"]");
		}
		ArrayList<String> salida = new ArrayList<String>();
		salida.add("No ha seleccionado ningun tipo a mostrar");
		salida.add("Usar el menu para motrar uno");
		request.setAttribute("error", salida);
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	if(tipo.equals("clientes") ){
		titulo="Clientes";
	}else if(tipo.equals("productos")){
		titulo="Productos";
		tipo="productos";
	}else if(tipo.equals("pedidos")){
		titulo="Pedidos";
		tipo="pedidos";
	}else if(tipo.equals("info")){
		titulo="Información";
		tipo="info";
	}else
		titulo="Sin datos";
	
	int pagina=1;
	if (request.getAttribute("pagina") != null)
		pagina=Integer.parseInt((String) request.getAttribute("pagina"));
	else if (request.getParameter("pagina") != null)
		pagina=Integer.parseInt((String) request.getParameter("pagina"));
	int maxxpag=5;
	int numeropag=1;
	
%>  
<%!
	public int numeroPaginas(int total, int max){
		int paginas=total/max;
		if (total%max != 0)
			paginas++;
		return paginas;
	}
	
	public int registrosuperior(int total, int actual, int max){
		if(actual*max<=total)
			return actual*max;
		return total;
	}
	
	public int registroInferior(int max, int sup){
		if(sup%max==0)
			return sup-max;
		return sup-sup%max;
	}

%>



<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:directive.include file="Encabezado.jsp" />

<div class="jumbotron">
        <h4><%= titulo %></h4>
     <%
      if(tipo.equals("info")){
    	  
		try
        {
		ArrayList<String> info = (ArrayList<String>)request.getAttribute("info");

		for (String str : info ){			
		%>
		<p>
		<%= str %>
		</p>
		<br>
		<%
	
		}

		}catch (Exception es) {
			System.err.println("Error en desconocido en la pagina de muestra\n" + es.getMessage());
		}
      }else{
	%>
	<table class="table table-striped table-hover">
		<%
        if(tipo.equals("clientes")){
        	
        	List<Cliente> arra = (List<Cliente>)misesion.getAttribute("clientes");
        	%>

		<thead>
			<tr>
				<th></th>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Direccion</th>
				<th>RFC</th>
			</tr>
		</thead>
		<tbody>

			<%  
				//if (arra == null){}
				//else 
				if (arra.size() >0 ){
				numeropag=(int) numeroPaginas(arra.size() , maxxpag );
				for (int i=registroInferior(maxxpag, registrosuperior(arra.size(), pagina, maxxpag));i< registrosuperior(arra.size(), pagina, maxxpag) ; i++ ){
					Cliente cliente =(Cliente) arra.get(i);
		        	  	//System.out.println("|"+alumno.getAlumnosId()+" | "+alumno.getNombre()+" | "+alumno.getAppaterno()+" | "+alumno.getApmaterno()+" | "+alumno.getDireccion()+" | "+alumno.getColonia()+" | "+alumno.getMunicipio()+" | "+alumno.getEstado()+"|");
		        	  	System.out.println("|"+cliente.getClientesId()+" | "+cliente.getNombre());
		        	  
		        %>
			<tr>
				<td class="actions-row"><a class="btn text-danger" data-toggle="confirmation" data-title="Desea Realmemte Eliminar" 
				href="Cliente?operacion=eliminar&cliente=<%= cliente.getClientesId() %>"
				data-placement="top" title="Eliminar cliente">
						<span class="glyphicon glyphicon-remove"></span>
				</a></td>
				<td><%= cliente.getClientesId() %></td>
				<td><%= cliente.getNombre() %></td>
				<td><%= cliente.getAppaterno() %> &nbsp; <%= cliente.getApmaterno() %>
				</td>
				<td><%= cliente.getDireccion() %> &nbsp; <%= cliente.getColonia() %>
					&nbsp; <%= cliente.getMunicipio() %> &nbsp; <%= cliente.getEstado() %>
				</td>
				<td><%= cliente.getRfc() %></td>
			</tr>
			<% 	  	
		        }
				}

			}else if( tipo.equals("productos")){
			        	List<Productos> arra = (List<Productos>)misesion.getAttribute("productos");
			%>
		
		<thead>
			<tr>
				<th></th>
				<th>ID</th>
				<th>Nombre</th>
				<th>P. Costo</th>
				<th>P. Venta</th>
				<th>Descripcion</th>
			</tr>
		</thead>
		<tbody>

			<%
				numeropag = (int) numeroPaginas(arra.size(), maxxpag);
				for (int i = registroInferior(maxxpag,
							registrosuperior(arra.size(), pagina, maxxpag)); i < registrosuperior(arra.size(), pagina,
									maxxpag); i++) {
					Productos producto = (Productos) arra.get(i);
						//System.out.println("|"+alumno.getAlumnosId()+" | "+alumno.getNombre()+" | "+alumno.getAppaterno()+" | "+alumno.getApmaterno()+" | "+alumno.getDireccion()+" | "+alumno.getColonia()+" | "+alumno.getMunicipio()+" | "+alumno.getEstado()+"|");
			%>
			<tr>
				<td class="actions-row"><a class="text-danger"
					href="Producto?operacion=eliminar&producto=<%=producto.getProductosId()%>"
					data-toggle="tooltip" data-placement="top" title="Eliminar Producto">
						<span class="glyphicon glyphicon-remove"></span>
				</a></td>
				<td><%=producto.getProductosId()%></td>
				<td><%=producto.getNombre()%></td>
				<td><%=producto.getCosto()%></td>
				<td><%=producto.getVenta()%></td>
				<td><%=producto.getDescripcion()%></td>
			</tr>
			<%
				}
			%>

			<%
				} else if (tipo.equals("pedidos")) {
					List<Cliproped> arra = (List<Cliproped>) misesion.getAttribute("pedidos");
			%>
		
		<thead>
			<tr>
				<th></th>
				<th>ID</th>
				<th>Descripcion</th>
				<th>Fecha Entrega</th>
				<th>Cliente</th>
				<th>Producto</th>
				<th>Entregado</th>
			</tr>
		</thead>
		<tbody>

			<%
				 numeropag = (int) numeroPaginas(arra.size(), maxxpag);
					for (int i = registroInferior(maxxpag,
							registrosuperior(arra.size(), pagina, maxxpag)); i < registrosuperior(arra.size(), pagina,
									maxxpag); i++) {
						Cliproped cpp = (Cliproped) arra.get(i);
						//System.out.println("|"+alumno.getAlumnosId()+" | "+alumno.getNombre()+" | "+alumno.getAppaterno()+" | "+alumno.getApmaterno()+" | "+alumno.getDireccion()+" | "+alumno.getColonia()+" | "+alumno.getMunicipio()+" | "+alumno.getEstado()+"|");
			%>
			<tr>
				<td class="actions-row"><a class="text-danger"
					href="Pedido?operacion=eliminar&pedido=<%= cpp.getPedido().getPedidosId() %>"
					data-toggle="tooltip" data-placement="top" title="Eliminar Pedido">
						<span class="glyphicon glyphicon-remove"></span>
				</a></td>
				<td><%=cpp.getCliproped_id()%></td>
				<td><%=cpp.getPedido().getDescripcion()%></td>
				<td><%=cpp.getPedido().getFechaentrega() %></td>
				<td><%=cpp.getCliente().getRazon() %> - <%= cpp.getCliente().getRfc() %> </td>
				<td><%=cpp.getProducto().getNombre() %></td>
				
				<td class="actions-row">
				<%
				 
				//System.out.println("Desc "+cpp.getPedido().getDescripcion()+" Boleano " + cpp.getPedido().getEstatus());
				 if (cpp.getPedido().getEstatus()){ 
					 
				 %>
						<span class="glyphicon glyphicon-thumbs-up" title="Pedido ya Entregado"></span>
				<%
				 }else{
					 
				 %>
					<a class="text-warning"
					href="Pedido?operacion=actualiza&pedido=<%= cpp.getPedido().getPedidosId() %>"
					data-toggle="tooltip" data-placement="top" title="Marcar como Entregado">
						<span class="glyphicon glyphicon-warning-sign"></span>
				</a>
				<% 
					}
				%>
				</td>
			</tr>
			<%
				}
			%>

			<%
		}
	%>
		
		</tbody>
	</table>



 <script type="text/javascript">
 //http://bootstrap-confirmation.js.org/
		
	  $('[data-toggle=confirmation]').confirmation({
		    rootSelector: '[data-toggle=confirmation]',
		    container: 'body'
		  });
		
</script>



	<!-- Paginación -->

    <nav aria-label="Page navigation">
  	<ul class="pagination">
    <%	
       	for(int i=1;i<=numeropag;i++){
       		if(i==pagina){
    		%> 
    		<li class="active"> 
    		<%
    		}else{
    		%> 
    		<li> 
    		<%
    		}
    		
    			
    			if (i!=pagina)
    				out.print("<a href=\"Muestra.jsp?pagina="+i+"&tipo="+tipo+"&\">");
    			else
    				out.print("<a href=\"#\">");
			
    			out.print(i);
   			
    				%>
    		</a>
    		</li>
    <%
    	}
    %>
	  </ul>
	</nav>
	<!-- Termina paginacion -->
   <%
   		//termina info
    }
   %>
	
  </div>
  

<jsp:directive.include file='Pie.jsp'/>
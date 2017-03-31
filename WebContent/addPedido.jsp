<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@page import="dao.*"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="Encabezado.jsp" />

<div class="jumbotron">
	
	<form class="form-horizontal" action="Pedido" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Alta de Pedido</legend>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="descripcion">Descripci&oacute;n</label>
				<div class="col-md-4">
					<input id="descripcion" name="descripcion" placeholder="Descripci&oacute;n"
						class="form-control input-md"  type="text" required  pattern="[A-Za-z0-9#.\s]{3,50}" maxlength="50"> 
						<span class="help-block">Escribe la descripci&oacute;n del pedido</span>
				</div>
			</div>
            
        
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="fecha">Fecha de entrega</label>
				<div class="col-md-4">
					<!--  jsp:directive.include file="Calendar.jsp" /-->
					<input id="venta" name="fecha" placeholder="Fecha de entrega" class="form-control input-md date"  type="text" required  pattern="[A-Za-z0-9#.\s]{3,50}"> 
						<span
						class="help-block">Escribe la Fecha de entrega en formato DIA-MES-AÑO ejemplo: 30-03-2017</span>
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="hora">Hora de Entrega</label>
				<div class="col-md-4">
					<input id="costo" name="hora" placeholder="hora 0:0"
						class="form-control input-md"  type="number" required  pattern="^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$" title="Formato Hora:Minutos"> <span
						class="help-block">Escribe la Hora de entrega en formato Hora:Minutos 00:00</span>
				</div>
			</div>
			
						<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="cliente">Cliente</label>
				<div class="col-md-4">
					<select id="materia" name="cliente" class="form-control">
						<% 
						ClienteDao cdao = new ClienteDao();
						// Abrir su try /cash / finally
						List<Cliente> lista = null;
						try {
							
							    lista = (List<Cliente>)cdao.getAll();
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al intentar listar los clientes: " + e.getMessage());

						} 
						
						for(Cliente cliente :lista){
						
						%>			
						<option value="<%= cliente.getClientesId()  %>"> <%= cliente.getRazon()%> - <%= cliente.getRfc() %> </option>
						<% 
						} 
						%>
					</select>
				</div>
			</div>
			
			
			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="producto">Producto</label>
				<div class="col-md-4">
					<select id="materia" name="producto" class="form-control">
						<% 
						ProductoDao pdao = new ProductoDao();
						// Abrir su try /cash / finally
						List<Productos> lista2 = null;
						try {
							
							    lista2 = (List<Productos>)pdao.getAll();
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error al intentar listar los productos: " + e.getMessage());

						} 
						
						for(Productos producto :lista2){
						
						%>			
						<option value="<%= producto.getProductosId() %>"> <%= producto.getNombre() %> </option>
						<% 
						} 
						%>
					</select>
				</div>
			</div>


			<input type="hidden" name="operacion" value="agregar">
	
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="guardar">Guardar</label>
				<div class="col-md-4">
					<button id="guardar" name="guardar" class="btn btn-primary">OK</button>
				</div>
			</div>

		</fieldset>
	</form>



</div>

<jsp:directive.include file='Pie.jsp'/>
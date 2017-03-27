<%@page import="java.util.*"%>
<%@page import="javax.persistence.*"%>


<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="Encabezado.jsp" />

<div class="jumbotron">
	
	<form class="form-horizontal" action="Producto" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Alta de Producto</legend>


			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nombre">Nombre</label>
				<div class="col-md-4">
					<input id="nombre" name="nombre" placeholder="Nombre"
						class="form-control input-md"  type="text" required  pattern="[A-Za-z\s]{2,50}" maxlength="50"> <span
						class="help-block">Escribe el nombre</span>
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="appaterno">Descripci&oacute;n</label>
				<div class="col-md-4">
					<input id="nombre" name="appaterno" placeholder="Apellido Paterno"
						class="form-control input-md"  type="text" required  pattern="[A-Za-z0-9#.\s]{3,50}" maxlength="50"> <span
						class="help-block">Escribe el Apellido Paterno</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="apmaterno">Precio de Venta</label>
				<div class="col-md-4">
					<input id="nombre" name="apmaterno" placeholder="Venta 0.0"
						class="form-control input-md"  type="number" required  pattern="[0-9]+([,\.][0-9]+)?" step="0.01"> <span
						class="help-block">Escribe el Precio de Venta</span>
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="direccion">Precio de Costo</label>
				<div class="col-md-4">
					<input id="nombre" name="direccion" placeholder="Costo 0.0"
						class="form-control input-md"  type="number" required  pattern="[0-9]+([,\.][0-9]+)?" step="0.01"> <span
						class="help-block">Escribe el Costo del Producto</span>
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
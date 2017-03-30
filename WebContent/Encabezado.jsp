<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

 <%
 	
 	//Verifica sesion valida
 		HttpSession misesion = request.getSession(false);
	if (misesion.getAttribute("usuario") == null) {		
		request.getRequestDispatcher("timeout.html").forward(request, response);
	}
	
%> 

<!DOCTYPE html>
<html >
  <head>
    <META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>;URL=timeout.html" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Pasteleria">
    <meta name="author" content="lius">
    <link rel="icon" href="favicon.ico">

    <title>Sistema de Administraci&oacute;n Pastelera</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Main CSS -->
    <link href="css/main.css" rel="stylesheet">
    


  <body>

    <div class="container">

      <!-- Static navbar -->
      <nav class="navbar-inverse navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <div class="navbar-brand" >Pasteleria</div>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="app.jsp">Inicio</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Clientes <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="Cliente?operacion=muestra&">Mostrar</a></li>
                  <li role="separator" class="divider"></li>
                  <li><a href="addCliente.jsp">Alta</a></li>
                </ul>
              </li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Productos <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="Producto?operacion=muestra&">Mostrar</a></li>
                  <li role="separator" class="divider"></li>
                  <li><a href="addProducto.jsp">Alta</a></li>
                </ul>
              </li> 
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pedidos <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="Pedido?operacion=muestra&">Mostrar</a></li>
                  <li role="separator" class="divider"></li>
                  <li><a href="addPedido.jsp">Alta</a></li>
                </ul>
              </li>     
              <li><a href="#aboutModal" data-toggle="modal" data-target="#myModal">Acerca de</a></li>
             
            </ul>
            <ul class="nav navbar-nav navbar-right">
                 <li><a href="Cerrarsesion.jsp">Salir</a></li>

            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

      
  <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title" id="myModalLabel">Acerca de Pasteleria </h4>
                    </div>
                <div class="modal-body">
                    <center>
                    <img src="images/carnage.jpg" name="aboutme" width="140" height="140" border="0" class="img-circle"></a>
                    <h3 class="media-heading">Rafael Mendoza <small>MEX</small></h3>
		    <br>
                    <img src="images/Lius.jpg" name="aboutme" width="140" height="140" border="0" class="img-circle"></a>
                    <h3 class="media-heading">Arturo Luna <small>MEX</small></h3>

                    <span><strong>Hecho con: </strong></span>
                        <span class="label label-warning">HTML5/CSS</span>
                        <span class="label label-info">Bootstrap</span>
                        <span class="label label-info">JQuery</span>
                    <span class="label label label-success">Mysql</span>
                        <!-- span class="label label-success">JPA</span -->
                    </center>
                    <hr>
                    <center>
                    <p class="text-left"><strong>Contacto: </strong><br>
                        lius.luna@gmail.com </p>
                    <br>
                    </center>
                </div>
                <div class="modal-footer">
                    <center>
                    <button type="button" class="btn btn-default" data-dismiss="modal">He oido suficiente</button>
                    </center>
                </div>
            </div>
        </div>
    </div>
   
   
      
      
      
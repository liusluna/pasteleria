<%@page import="java.util.*"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>;URL=timeout.html" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Escuela">
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
            <a class="navbar-brand" href="">Pasteleria</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="index.html">Inicio</a></li>
              <li><a href="#aboutModal" data-toggle="modal" data-target="#myModal">Acerca de</a></li>
             
            </ul>
            <ul class="nav navbar-nav navbar-right">

	        
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>



      <div class="jumbotron">
        <h1>Error</h1>
           <%
		try
        {
		ArrayList<String> errores = (ArrayList<String>)request.getAttribute("error");

		for (String str : errores ){			
		%>
		<p>
		<%= str %>
		</p>
		<br>
		<%
	
		}

		}catch (Exception es) {
			System.err.println("Error en desconocido en la pagina de error\n" + es.getMessage());
		}

	%>
	<br>
		<br>
	<%
		HttpSession misesion = request.getSession(false);
		if (misesion.getAttribute("usuario") == null) {			
	%><p>
		<a href="index.html">Inicio</a>
		</p>
	<%
	}else{
		%>
		<p>
		<a href="app.jsp">Regresar</a>
		</p>
	<%	
	}
	%>	
        

      </div>



<jsp:directive.include file='Pie.jsp'/>
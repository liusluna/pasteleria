<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="Encabezado.jsp" />


<!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="images/stand_expo.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Sistema de Administraci&oacute;n Pastelera</h1>
              <p>Bienvenido al Sistema de Administraci&oacute;n Pastelera</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="images/cupcakes.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Inovaci&oacute;n</h1>
              <p>Inovaci&oacute;n que deslumbra</p>
              
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="images/granja.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>C&oacute;digo</h1>
              <p>Con todos el c&oacute;digo necesario</p>
               <p><a class="btn btn-lg btn-primary" href="#aboutModal" data-toggle="modal" data-target="#myModal" role="button">Acerca de</a></p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->




<jsp:directive.include file='Pie.jsp'/>
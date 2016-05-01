<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Agregar una nueva ruta</title>
		<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>	
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@page import="modelos.Usuario"%>
		<%
			HttpSession sesion = request.getSession(true); 
		 	Usuario u = (Usuario) sesion.getAttribute("usuario");
		%>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/nueva_ruta" method="POST">
			<div class="form-group">
			    <label>Nombre de la ruta</label>
			    <input type="text" class="form-control" name="nombre" placeholder="Nombre de la ruta">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Descripción</label>
			    <input type="text" class="form-control" name="descripcion" placeholder="Descripción">
		  	</div>
		  	
		  	<div class="form-group">
				<label>Privacidad</label>
			  	<div class="radio-inline">
				  <label>
				    <input type="radio" name="privacidad" value="PUBLICA" checked>
				    Pública
				  </label>
				</div>
				<div class="radio-inline">
				  <label>
				    <input type="radio" name="privacidad" value="PRIVADA">
				    Privada
				  </label>
				</div>
			</div>
		  	
		  	<div class="form-group">
				<label for="recorrido">Recorrido</label>
				<input type="file" id="recorrido">
				<p class="help-block">Un dibujo del mapa o un archivo KML.</p>
			</div>
		  	
			<div class="form-group">
				<label>Formato</label>
			  	<div class="radio-inline">
				  <label>
				    <input type="radio" name="formato" value="SOLO_IDA" checked>
				    Solo ida
				  </label>
				</div>
				<div class="radio-inline">
				  <label>
				    <input type="radio" name="formato" value="CIRCULAR">
				    Circular
				  </label>
				</div>
			</div>
			
			<div class="form-group">
			    <label>Distancia</label>
			    <input type="text" class="form-control" name="distancia" placeholder="Distancia en kilómetros">
		  	</div>		  	
		  	
		  	<div class="form-group">
				<label>Dificultad</label>
			  	<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="FACIL" checked>
				    Fácil
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="MODERADO">
				    Moderado
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="DIFICIL">
				    Dificil
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="MUY_DIFICIL">
				    Muy Dificil
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="SOLO_EXPERTOS">
				    Sólo Expertos
				  </label>
				</div>
			</div>
			
		  	<select class="form-control" name="actividad">
		  		<c:forEach items="${actividades}" var="actividad">
		  			<c:choose>
			  			<c:when test="${actividad.getEsta_habilitada()}">
							<option value="${actividad.getNombre()}">${actividad.getNombre()}</option>
						</c:when>
					</c:choose>
				</c:forEach>
			</select>
					  	
		  	<div class="form-group">
			    <label>Tiempo Estimado</label>
			    <input type="text" class="form-control" name="tiempo" placeholder="Tiempo Estimado">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Fecha de Realización</label>
			    <%@page import="java.util.Date" %>
			    <% Date dt = new Date(); %>
			    
			    <input type="text" class="form-control" name="fecha" value="<%= dt.toString() %>" disabled>
		  	</div>		  			  	
		  	
		  	<div class="form-group">
				<label for="recorrido">Foto</label>
				<input type="file" id="foto">
				<p class="help-block">Una foto de la ruta.</p>
			</div>
		  	 
		  	<input type="hidden" value="<%= u.getUsuario() %>" name="usuario">
		  	 
		  	<button type="submit" class="btn btn-default">Enviar</button>
		  	<INPUT Type="button" class="btn btn-info" VALUE="Volver" onClick="history.go(-1);return true;">
		</form>		
	</body>
</html>
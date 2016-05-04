<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
  	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>Listado Rutas</title>
</head>
<body>
	<%@include file="../menu.jsp"  %>
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/ver_ruta" method="POST" >
				<div class="input-group">
			        <input type="text" class="form-control" placeholder="Buscar ruta" name="nombre">
			    </div>
			    <div class="input-group">
			        <input type="text" class="form-control" placeholder="Distancia" name="distancia">
			    </div>
			    <div class="input-group">
					<select class="form-control" name="actividad">
						<option value="TODAS">-Actividad-</option>
				  		<c:forEach items="${actividades}" var="actividad">
				  			<c:choose>
					  			<c:when test="${actividad.getEsta_habilitada()}">
									<option value="${actividad.getNombre()}">${actividad.getNombre()}</option>
								</c:when>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="input-group">
					<select class="form-control" name="dificultad">
						<option value="TODAS">-Dificultad-</option>
						<option value="FACIL">Fácil</option>
						<option value="MODERADO">Moderado</option>
						<option value="DIFICIL">Dificil</option>
						<option value="MUY_DIFICIL">Muy Dificil</option>
						<option value="SOLO_EXPERTOS">Solo Expertos</option>
					</select>
				</div>
				<div class="input-group">
					<select class="form-control" name="formato">
						 <option value="TODAS">-Formato-</option>
						 <option value="SOLO_IDA">Solo Ida</option>
						 <option value="CIRCULAR">Circular</option>
					</select>
				</div>
				<div class="input-group">
					<button name="Submit" value="buscar" type="Submit" class="btn btn-default">
						&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;
					</button>					
				</div>				
			</form>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<% if (u != null){%>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/nueva_ruta" role="button">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Nueva Ruta
				</a>
			<% } %>
		</ul>
	</div>
	<table class="table table-hover">
	 		<tr>
	 			<th>Nombre</th>
	 			<th>Formato</th>
	 			<th>Distancia</th>
	 			<th>Dificultad</th>
	 			<th>Actividad</th>
	 			<th>Tiempo estimado</th>
	 			<th>Fecha</th>
	 			<th colspan="3">Acción</th>
	 		</tr>
	 		
	 		<c:forEach items="${rutas}" var="ruta">
		 		<c:choose>
		 			<c:when test="${ruta.getUsuario().equals(user)}">
			 			<tr>			
				 			<td>${ruta.getNombre()}</td>
				 			<td>
				 				<c:choose>
						 			<c:when test="${ruta.getEs_circular()}">
						 				Circular
						 			</c:when>
						 			<c:otherwise>
						 				Solo ida
						 			</c:otherwise>
					 			</c:choose>
							</td>
				 			<td>${ruta.getDistancia()} kms</td>
				 			<td>${ruta.getDificultad()}</td>
				 			<td>${ruta.getActividad()}</td>
				 			<td>${ruta.getTiempo_estimado()}</td>
				 			<td>${ruta.getFecha_de_realizacion()}</td>
				 			<td><a class="btn btn-default btn-xs" href="ver_ruta?nombre=${ruta.nombre}">
				 			<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>&nbsp;Ver
				 			</a></td>
				 			<c:set var="user" value="${ruta.getUsuario()}"/>
				 			<% String user = pageContext.getAttribute("user").toString();
				 			if (u != null && (u.getEs_admin() || u.getUsuario().equals(user))){%>
				 				<td><a class="btn btn-primary btn-xs" href="editar_ruta?nombre=${ruta.nombre}">
				 				<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;Editar
				 				</a></td>
				 				<td><a class="btn btn-danger btn-xs" href="eliminar_ruta?nombre=${ruta.nombre}">
				 				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;Eliminar
				 				</a></td>
				 			<% } %>
				 		</tr>
		 			</c:when>
		 		</c:choose>		 		
	 		</c:forEach>
		</table>

</body>
</html>
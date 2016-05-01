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
	<% if (u != null){%>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/nueva_ruta" role="button">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Nueva Ruta
		</a>
	<% } %>
	<table class="table table-hover">
	 		<tr>
	 			<th>Nombre</th>
	 			<th>Descripcion</th>
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
		 			<c:when test="${ruta.getEs_publica()}">
			 			<tr>			
				 			<td>${ruta.getNombre()}</td>
				 			<td>${ruta.getDescripcion()}</td>
				 			<td>
				 				<c:choose>
						 			<c:when test="${ruta.getEs_circular()}">
						 				Es Circular
						 			</c:when>
						 			<c:otherwise>
						 				Es solo ida
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
				 			<% if (u != null && u.getEs_admin()){%>
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
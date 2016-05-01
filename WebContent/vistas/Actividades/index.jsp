<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
	<title>Listado Actividades</title>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<%@include file="../menu.jsp"  %>
	<% if (u != null && u.getEs_admin()){%>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/vistas/Actividades/nueva.jsp" role="button">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Nueva Actividad
		</a>
	<% } %>
	<table class="table table-hover">
	 		<tr>
	 			<th>ID</th>
	 			<th>Nombre</th>
	 			<th>Descripcion</th>
	 			<th>Estado</th>
	 			<th colspan="3">Acción</th>
	 		</tr>
	 		
	 		<c:forEach items="${actividades}" var="actividad">
		 		<tr>
		 			<td>${actividad.getId()}</td>	 			
		 			<td>${actividad.getNombre()}</td>	 
		 			<td>${actividad.getDescripcion()}</td>	 
		 			<td>
			 			<c:choose>
		 					<c:when test="${actividad.getEsta_habilitada()}">
		 						<a class="btn btn-info btn-xs" href="cambiar_estado_actividad?nombre=${actividad.nombre}">
		 						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;Habilitado
		 						</a>
		 					</c:when>
		 					
		 					<c:otherwise>
		 						<a class="btn btn-warning btn-xs" href="cambiar_estado_actividad?nombre=${actividad.nombre}">
		 						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp;Deshabilitado
		 						</a>
		 					</c:otherwise>
		 				</c:choose>		 			
		 			</td>
		 			<td><a class="btn btn-default btn-xs" href="ver_actividad?nombre=${actividad.nombre}">
		 			<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>&nbsp;Ver
		 			</a></td>
		 			<% if (u != null && u.getEs_admin()){%>
		 				<td><a class="btn btn-primary btn-xs" href="editar_actividad?nombre=${actividad.nombre}">
		 				<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;Editar
		 				</a></td>
		 				<td><a class="btn btn-danger btn-xs" href="eliminar_actividad?nombre=${actividad.nombre}">
		 				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;Eliminar
		 				</a></td>
		 			<% } %>
		 		</tr>
	 		</c:forEach>
		</table>

</body>
</html>
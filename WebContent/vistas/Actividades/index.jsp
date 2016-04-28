<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<title>Listado Actividades</title>
</head>
<body>
	<%@include file="../menu.jsp"  %>
	<% if (u != null && u.getEs_admin()){%>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/vistas/Actividades/nueva.jsp" role="button">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nueva Actividad
		</a>
	<% } %>
	<table class="table table-hover">
	 		<tr>
	 			<th>Nombre</th>
	 			<th>Descripcion</th>
	 			<th>Estado</th>
	 			<th colspan="3">Acción</th>
	 		</tr>
	 		
	 		<% for(int i = 0; i < 10; i++) { %>
		 		<tr>
		 			<% // Obtener todos los usuarios e iterar %>	 			
		 			<td>nombre</td>
		 			<td>descripcion de la actividad</td>
		 			<td>
		 			<% if ((i % 2)==0){ //Cambiar por comprobacion de habilitacion usuario%> 
		 			<a class="btn btn-info btn-xs" href="#">
		 			<span class="glyphicon glyphicon-flag" aria-hidden="true"></span>Habilitada
		 			</a>
		 			<% }else{ %>
		 				<a class="btn btn-info btn-xs" href="#">
		 				<span class="glyphicon glyphicon-flag" aria-hidden="true"></span>Deshabilitada
		 				</a>
		 			<% } %>
		 			</td>
		 			<td><a class="btn btn-default btn-xs" href="#">
		 			<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>Ver
		 			</a></td>
		 			<% if (u != null && u.getEs_admin()){%>
		 				<td><a class="btn btn-primary btn-xs" href="#">
		 				<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>Editar
		 				</a></td>
		 				<td><a class="btn btn-danger btn-xs" href="#">
		 				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Eliminar
		 				</a></td>
		 			<% } %>
		 		</tr>
	 		<% } %>
		</table>

</body>
</html>
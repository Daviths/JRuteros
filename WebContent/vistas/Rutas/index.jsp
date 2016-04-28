<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<title>Listado Rutas</title>
</head>
<body>
	<%@include file="../menu.jsp"  %>
	<a class="btn btn-default" href="/nueva.jsp" role="button">Nueva Ruta</a>
	<table class="table table-hover">
	 		<tr>
	 			<th>Nombre</th>
	 			<th>Descripcion</th>
	 			<th>Privacidad</th>
	 			<th>Recorrido</th>
	 			<th>Formato</th>
	 			<th>Distancia</th>
	 			<th>Dificultad</th>
	 			<th>Actividad</th>
	 			<th>Tiempo estimado</th>
	 			<th>Fecha</th>
	 			<th>Fotos</th>
	 			<th colspan="3">Acción</th>
	 		</tr>
	 		
	 		<% for(int i = 0; i < 10; i++) { %>
		 		<tr>
		 			<% // Obtener todos los usuarios e iterar %>	 			
		 			<td>nombre</td>
		 			<td>descripcion de la ruta</td>
		 			<td>Publica</td>
		 			<td>Mapita</td>
		 			<td>Solo ida</td>
		 			<td><%= i*7 %> kms</td>
		 			<td>Facil</td>
		 			<td>Mountain Bike</td>
		 			<td>Unas horas</td>
		 			<td>HOY</td>
		 			<td>Fotos</td>
		 			<td><a class="btn btn-default btn-xs" href="#">Ver</a></td>
		 			<td><a class="btn btn-primary btn-xs" href="#">Editar</a></td>
		 			<td><a class="btn btn-danger btn-xs" href="#">Eliminar</a></td>
		 		</tr>
	 		<% } %>
		</table>

</body>
</html>
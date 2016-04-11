<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>Listado Actividades</title>
</head>
<body>
	<%@include file="../menu.html"  %>
	<a class="btn btn-default" href="#" role="button">Nueva Actividad</a>
	<table class="table table-hover">
	 		<tr>
	 			<th>Nombre</th>
	 			<th>Descripcion</th>
	 			<th>Usuario</th>
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
		 			<a class="btn btn-info btn-xs" href="#">Habilitada</a>
		 			<% }else{ %>
		 				<a class="btn btn-info btn-xs" href="#">Deshabilitada</a>
		 			<% } %>
		 			</td>
		 			<td><a class="btn btn-default btn-xs" href="#">Ver</a></td>
		 			<td><a class="btn btn-primary btn-xs" href="#">Editar</a></td>
		 			<td><a class="btn btn-danger btn-xs" href="#">Eliminar</a></td>
		 		</tr>
	 		<% } %>
		</table>

</body>
</html>
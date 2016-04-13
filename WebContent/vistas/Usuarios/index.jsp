<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Bootstrap -->	
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<title>Indice de Usuarios</title>
	</head>
	<body>
		<%@include file="../menu.html"  %>
		<table class="table table-hover">
	 		<tr>
	 			<th>ID</th>
	 			<th>Nombre</th>
	 			<th>Apellido</th>
	 			<th>Usuario</th>
	 			<th>Estado</th>
	 			<th colspan="3">Acci�n</th>
	 		</tr>
	 		
	 		<c:forEach items="${usuarios}" var="usuario">
	 			<tr>
	 				<td>ID?</td>
	 				<td>${usuario.getNombre()}</td>
	 				<td>${usuario.getApellido()}</td>
	 				<td>${usuario.getUsuario()}</td>
	 				<td>${usuario.getEmail()}</td>
	 				<td>${usuario.getEsta_habilitado()}</td>
	 			</tr>
	 		</c:forEach>
		</table>
	</body>
</html>
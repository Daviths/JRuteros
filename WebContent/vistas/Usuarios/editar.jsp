<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Editar usuario</title>
		<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>	
	<body>
		<h1>Editar usuario</h1>
		
		<form action="actualizar_usuario" method="POST">
			<div class="form-group">
			    <label>Nombre de usuario</label>
			    <input type="text" class="form-control" value="${usuario.usuario}" name="usuario" placeholder="Nombre de usuario">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>DNI</label>
			    <input type="text" class="form-control" value="${usuario.dni}" name="dni" placeholder="DNI">
		  	</div>  	
		  	
		  	<div class="form-group">
			    <label>Nombre</label>
			    <input type="text" class="form-control" value="${usuario.nombre}" name="nombre" placeholder="Nombre">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Domicilio</label>
			    <input type="text" class="form-control" value="${usuario.domicilio}" name="domicilio" placeholder="Domicilio">
		  	</div>		 
		  	 
		  	<button type="submit" class="btn btn-default">Guardar cambios</button>
		</form>		
	</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Editar la actividad</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form action="editar_actividad" method="POST">
			<div class="form-group">
			    <label>Nombre de la actividad</label>
			    <input type="text" class="form-control" value="${actividad.nombre}" name="nombre_nuevo" placeholder="Nombre de la actividad">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Descripción</label>
			    <input type="text" class="form-control" value="${actividad.descripcion}" name="descripcion" placeholder="Descripción">
		  	</div>
		   	  	
		   	<input type="hidden" name="nombre_original" value="${actividad.nombre}">
		   	 
		  	<button type="submit" class="btn btn-default">Guardar Cambios</button>
		  	<INPUT Type="button" class="btn btn-info" VALUE="Volver" onClick="history.go(-1);return true;">
		</form>		
		
	</body>
</html>
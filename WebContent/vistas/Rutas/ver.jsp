<!DOCTYPE html>
<html>
	<head>
	<title>Informacion de ${ruta.getNombre()}</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
	<c:choose>
		<c:when test="${not empty ruta}">
			<h1>Información de la ruta:</h1>
			<div class="row">
				<div class="col-sm-8">
					<div class="panel panel-primary">
					  <div class="panel-heading">
					  	<h3 class="panel-title">Nombre</h3>
					  </div>
					  <div class="panel-body">
					  	${ruta.getNombre()}
					  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-8">
					<div class="panel panel-info">
					  <div class="panel-heading">
					  	<h3 class="panel-title">Descripción</h3>
					  </div>
					  <div class="panel-body">
					  	${ruta.getDescripcion()}
					  </div>
					</div>
				</div>
			</div>
			
			<div class="row">
		        <div class="col-sm-4">
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">Privacidad</h3>
						</div>
						<div class="panel-body">
							<c:choose>
								<c:when test="${ruta.getEs_publica()}">
									Pública
								</c:when>
								<c:otherwise>
									Privada
								</c:otherwise>
							</c:choose>
						</div>
					</div>
		        </div>
		        <div class="col-sm-4">
					<div class="panel panel-success">
						<div class="panel-heading">
							<h3 class="panel-title">Formato</h3>
						</div>
						<div class="panel-body">
							<c:choose>
								<c:when test="${ruta.getEs_circular()}">
									Circular
								</c:when>
								<c:otherwise>
									Solo ida
								</c:otherwise>
							</c:choose>
						</div>
					</div>
		        </div>
	        </div>
	        
	        <div class="row">
		        <div class="col-sm-4">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Distancia</h3>
						</div>
						<div class="panel-body">
							${ruta.getDistancia()} kms
						</div>
					</div>
		        </div>
		        <div class="col-sm-4">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Tiempo estimado</h3>
						</div>
						<div class="panel-body">
							${ruta.getTiempo_estimado()}
						</div>
					</div>
		        </div>
	        </div>
			
			<div class="row">
		        <div class="col-sm-4">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Actividad</h3>
						</div>
						<div class="panel-body">
							${ruta.getActividad()}
						</div>
					</div>
		        </div>
		        <div class="col-sm-4">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Dificultad</h3>
						</div>
						<div class="panel-body">
							${ruta.getDificultad()}
						</div>
					</div>
		        </div>
	        </div>
	        
	        <div class="row">
		        <div class="col-sm-4">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Subida por</h3>
						</div>
						<div class="panel-body">
							${ruta.getUsuario()}
						</div>
					</div>
		        </div>
		        <div class="col-sm-4">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">El día</h3>
						</div>
						<div class="panel-body">
							${ruta.getFecha_de_realizacion()}
						</div>
					</div>
		        </div>
	        </div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger" role="alert">Ruta no encontrada o inexistente</div>
		</c:otherwise>
	</c:choose>
		<FORM><INPUT Type="button" class="btn btn-info" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
	</body>
</html>
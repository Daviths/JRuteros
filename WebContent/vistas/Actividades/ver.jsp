<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Perfil de ${actividad.getNombre()}</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<h1>Información de ${actividad.getNombre()}:</h1>
		<div class="row">
			<div class="col-sm-8">
				<div class="panel panel-primary">
				  <div class="panel-heading">
				  	<h3 class="panel-title">Nombre</h3>
				  </div>
				  <div class="panel-body">
				  	${actividad.getNombre()}
				  </div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-8">
				<div class="panel panel-info">
				  <div class="panel-heading">
				  	<h3 class="panel-title">Descripcion</h3>
				  </div>
				  <div class="panel-body">
				  	${actividad.getDescripcion()}
				  </div>
				</div>
			</div>
		</div>
				
		<FORM><INPUT Type="button" class="btn btn-info" VALUE="Volver" onClick="history.go(-1);return true;"></FORM>
	</body>
</html>
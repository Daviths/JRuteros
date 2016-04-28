<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Perfil de ${usuario.getUsuario()}</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<h1>Información de ${usuario.getUsuario()}:</h1>
		<div class="row">
			<div class="col-sm-8">
				<div class="panel panel-primary">
				  <div class="panel-heading">
				  	<h3 class="panel-title">DNI</h3>
				  </div>
				  <div class="panel-body">
				  	${usuario.getDni()}
				  </div>
				</div>
			</div>
		</div>
		<div class="row">
	        <div class="col-sm-4">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Apellido</h3>
					</div>
					<div class="panel-body">
						${usuario.getApellido()}
					</div>
				</div>
	        </div>
	        <div class="col-sm-4">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Nombre</h3>
					</div>
					<div class="panel-body">
						${usuario.getNombre()}
					</div>
				</div>
	        </div>
        </div>
        
        <div class="row">
	        <div class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Domicilio</h3>
					</div>
					<div class="panel-body">
						${usuario.getDomicilio()}
					</div>
				</div>
	        </div>
	        <div class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Fecha de nacimiento</h3>
					</div>
					<div class="panel-body">
						${usuario.getFecha_de_nacimiento()}
					</div>
				</div>
	        </div>
        </div>
		
		<div class="row">
	        <div class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Sexo</h3>
					</div>
					<div class="panel-body">
						${usuario.getSexo()}
					</div>
				</div>
	        </div>
	        <div class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Email</h3>
					</div>
					<div class="panel-body">
						${usuario.getEmail()}
					</div>
				</div>
	        </div>
        </div>
		
		<FORM><INPUT Type="button" class="btn btn-info" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
	</body>
</html>
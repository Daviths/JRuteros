<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Registro de Usuario</title>
	<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form action="../../nuevo_usuario" method="POST">
			<div class="form-group">
			    <label>Nombre de usuario</label>
			    <input type="text" class="form-control" name="usuario" placeholder="Nombre de usuario" required>
		  	</div>
		  	
		  	<div class="form-group">
			    <label>DNI</label>
			    <input type="text" class="form-control" name="dni" placeholder="DNI" >
		  	</div>
		  	
			<div class="form-group">
			    <label>Apellido</label>
			    <input type="text" class="form-control" name="apellido" placeholder="Apellido">
		  	</div>		  	
		  	
		  	<div class="form-group">
			    <label>Nombre</label>
			    <input type="text" class="form-control" name="nombre" placeholder="Nombre">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Domicilio</label>
			    <input type="text" class="form-control" name="domicilio" placeholder="Domicilio">
		  	</div>		  	
		  	
		  	<div class="form-group">
			    <label>Fecha de nacimiento</label>
			    <input type="date" class="form-control" name="fecha_de_nacimiento" placeholder="Fecha de nacimiento">
		  	</div>		  	

			<div class="form-group">
				<label>Sexo</label>
			  	<div class="radio">
				  <label>
				    <input type="radio" name="sexo" value="MASCULINO" checked>
				    Masculino
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="sexo" value="FEMENINO">
				    Femenino
				  </label>
				</div>
			</div>
		  	
		  	<div class="form-group">
			    <label>Email</label>
			    <input type="email" class="form-control" name="email" placeholder="Email" required>
		  	</div>		  	
		  	  	
		  	<button type="submit" class="btn btn-default">Registrarse</button>
		</form>		
		<a class="btn btn-info" role="button" href="../login.html">Volver</a>
	</body>
</html>
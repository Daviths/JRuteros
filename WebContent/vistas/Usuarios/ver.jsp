<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Registro de Usuario</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>		
		<h1>Información del usuario seleccionado:</h1>
		
		<h3>Nombre de usuario</h3>
		<p>${usuario.getUsuario()}</p>
		
		<h3>DNI</h3>
		<p>${usuario.getDni()}</p>
		
		<h3>Apellido</h3>
		<p>${usuario.getApellido()}</p>
		
		<h3>Nombre</h3>
		<p>${usuario.getNombre()}</p>
		
		<h3>Domicilio</h3>
		<p>${usuario.getDomicilio()}</p>
		
		<h3>Fecha de nacimiento</h3>
		<p>${usuario.getFecha_de_nacimiento()}</p>
		
		<h3>Sexo</h3>
		<p>${usuario.getSexo()}</p>
		
		<h3>Email</h3>
		<p>${usuario.getEmail()}</p>
		
		<FORM><INPUT Type="button" class="btn btn-info" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
	</body>
</html>
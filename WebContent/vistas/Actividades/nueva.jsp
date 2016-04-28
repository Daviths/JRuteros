<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Agregar una nueva actividad</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form action="CrearRuta" method="POST">
			<div class="form-group">
			    <label>Nombre de la actividad</label>
			    <input type="text" class="form-control" name="nombre" placeholder="Nombre de la actividad">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Descripción</label>
			    <input type="text" class="form-control" name="descripcion" placeholder="Descripción">
		  	</div>
		  	
		  	<div class="form-group">
				<label>Estado</label>
			  	<div class="radio">
				  <label>
				    <input type="radio" name="estado" value="HABILITADA" checked>
				    Habilitada
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="estado" value="DESHABILITADA">
				    Deshabilitada
				  </label>
				</div>				
			</div>
		   	  	
		  	<button type="submit" class="btn btn-default">Submit</button>
		  	<INPUT Type="button" class="btn btn-info" VALUE="Back" onClick="history.go(-1);return true;">
		</form>		
		
	</body>
</html>
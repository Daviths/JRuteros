<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Agregar una nueva actividad</title>
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form action="../../nueva_actividad" method="POST">
			<div class="form-group">
			    <label>Nombre de la actividad</label>
			    <input type="text" class="form-control" name="nombre" placeholder="Nombre de la actividad">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Descripci�n</label>
			    <input type="text" class="form-control" name="descripcion" placeholder="Descripci�n">
		  	</div>
		   	  	
		  	<button type="submit" class="btn btn-default">Submit</button>
		  	<INPUT Type="button" class="btn btn-info" VALUE="Back" onClick="history.go(-1);return true;">
		</form>		
		
	</body>
</html>
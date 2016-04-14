<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Agregar una nueva ruta</title>
	<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<form action="CrearRuta" method="POST">
			<div class="form-group">
			    <label>Nombre de la ruta</label>
			    <input type="text" class="form-control" name="nombre" placeholder="Nombre de la ruta">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Descripción</label>
			    <input type="text" class="form-control" name="descripcion" placeholder="Descripción">
		  	</div>
		  	
		  	<div class="form-group">
				<label>Privacidad</label>
			  	<div class="radio-inline">
				  <label>
				    <input type="radio" name="privacidad" value="PUBLICA" checked>
				    Pública
				  </label>
				</div>
				<div class="radio-inline">
				  <label>
				    <input type="radio" name="privacidad" value="PRIVADA">
				    Privada
				  </label>
				</div>
			</div>
		  	
		  	<div class="form-group">
				<label for="recorrido">Recorrido</label>
				<input type="file" id="recorrido">
				<p class="help-block">Un dibujo del mapa o un archivo KML.</p>
			</div>
		  	
			<div class="form-group">
				<label>Formato</label>
			  	<div class="radio-inline">
				  <label>
				    <input type="radio" name="formato" value="SOLO_IDA" checked>
				    Solo ida
				  </label>
				</div>
				<div class="radio-inline">
				  <label>
				    <input type="radio" name="formato" value="CIRCULAR">
				    Circular
				  </label>
				</div>
			</div>
			
			<div class="form-group">
			    <label>Distancia</label>
			    <input type="text" class="form-control" name="distancia" placeholder="Distancia en kilómetros">
		  	</div>		  	
		  	
		  	<div class="form-group">
				<label>Dificultad</label>
			  	<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="FACIL" checked>
				    Fácil
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="MODERADO">
				    Moderado
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="DIFICIL">
				    Dificil
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="MUY_DIFICIL">
				    Muy Dificil
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="dificultad" value="SOLO_EXPERTOS">
				    Sólo Expertos
				  </label>
				</div>
			</div>
			
		  	<div class="form-group">
				<label>Actividad (Por ser reemplazado por el contenido de la BD)</label>
			  	<div class="radio">
				  <label>
				    <input type="radio" name="actividad" value="MOUNTAIN_BIKE" checked>
				    Mountain Bike
				  </label>
				</div>
				<div class="radio">
				  <label>
				    <input type="radio" name="actividad" value="OTRA">
				    Otra
				  </label>
				</div>
			</div>
		  	
		  	<div class="form-group">
			    <label>Tiempo Estimado</label>
			    <input type="text" class="form-control" name="tiempo" placeholder="Tiempo Estimado">
		  	</div>
		  	
		  	<div class="form-group">
			    <label>Fecha de Realización</label>
			    <%@page import="java.util.Date" %>
			    <% Date dt = new Date(); %>
			    
			    <input type="text" class="form-control" name="domicilio" value="<%= dt.toString() %>" disabled>
		  	</div>		  			  	
		  	
		  	<div class="form-group">
				<label for="recorrido">Foto</label>
				<input type="file" id="foto">
				<p class="help-block">Una foto de la ruta.</p>
			</div>
		  	  	
		  	<button type="submit" class="btn btn-default">Submit</button>
		</form>		
		
	</body>
</html>
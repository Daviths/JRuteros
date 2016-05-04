<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Perfil de ${usuario.getUsuario()}</title>
		<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/flot/styles.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
	  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/flot/jquery.flot.js"></script>
		<script src="${pageContext.request.contextPath}/flot/jquery.flot.pie.js"></script>
		<script type="text/javascript">

			$(function() {
		
				// Example Data
		
				//var data = [
				//	{ label: "Series1",  data: 10},
				//	{ label: "Series2",  data: 30},
				//	{ label: "Series3",  data: 90},
				//	{ label: "Series4",  data: 70},
				//	{ label: "Series5",  data: 80},
				//	{ label: "Series6",  data: 110}
				//];
		
				//var data = [
				//	{ label: "Series1",  data: [[1,10]]},
				//	{ label: "Series2",  data: [[1,30]]},
				//	{ label: "Series3",  data: [[1,90]]},
				//	{ label: "Series4",  data: [[1,70]]},
				//	{ label: "Series5",  data: [[1,80]]},
				//	{ label: "Series6",  data: [[1,0]]}
				//];
		
				//var data = [
				//	{ label: "Series A",  data: 0.2063},
				//	{ label: "Series B",  data: 38888}
				//];
		
				// Randomly Generated Data
		
				var data = [],
					series = Math.floor(Math.random() * 6) + 3;
		
				for (var i = 0; i < series; i++) {
					data[i] = {
						label: "Series" + (i + 1),
						data: Math.floor(Math.random() * 100) + 1
					}
				}
		
				var placeholder = $("#placeholder");
				
		
				$("#dona").click(function() {
		
					placeholder.unbind();
		
					$("#title").text("Interactivity");
					$("#description").text("The pie can be made interactive with hover and click events.");
		
					$.plot(placeholder, data, {
						series: {
							pie: { 
								innerRadius: 0.5,
								show: true
							}
						},
						grid: {
							hoverable: true,
							clickable: true
						}
					});
		
					placeholder.bind("plothover", function(event, pos, obj) {
		
						if (!obj) {
							return;
						}
		
						var percent = parseFloat(obj.series.percent).toFixed(2);
						$("#hover").html("<span style='font-weight:bold; color:" + obj.series.color + "'>" + obj.series.label + " (" + percent + "%)</span>");
					});
		
					placeholder.bind("plotclick", function(event, pos, obj) {
		
						if (!obj) {
							return;
						}
		
						percent = parseFloat(obj.series.percent).toFixed(2);
						alert(""  + obj.series.label + ": " + percent + "%");
					});
				});
		
				// Show the initial default chart
		
				$("#dona").click();			

			});
		
			// A custom label formatter used by several of the plots
		
			function labelFormatter(label, series) {
				return "<div style='font-size:8pt; text-align:center; padding:2px; color:white;'>" + label + "<br/>" + Math.round(series.percent) + "%</div>";
			}
		
			//
		

	</script>
	</head>
	<body>
	<%@include file="../menu.jsp"  %>
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#informacion">Información</a></li>
		<li><a data-toggle="tab" href="#estadisticas">Estadísticas</a></li>
	</ul>
	
	<div class="tab-content">
		<div id="informacion" class="tab-pane fade in active">
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
		</div>
			
		<div id="estadisticas" class="tab-pane fade">
			<div id="header">
				<h2>Pie Charts</h2>
			</div>
		
			<div id="content">
		
				<h3 id="title"></h3>
				<div class="demo-container">
					<div id="placeholder" class="demo-placeholder" ></div>
						<div class="menu">
						<button id="example-1">Uno</button>
						<button id="dona">Once</button>
						</div>
					</div>
				</div>
		
				<p id="description"></p>
		
			</div>			
		</div>
		<FORM><INPUT Type="button" class="btn btn-info" VALUE="Back" onClick="history.go(-1);return true;"></FORM>
	</body>
</html>
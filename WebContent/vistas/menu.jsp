<%@page import="modelos.Usuario"%>
<%
	HttpSession sesion = request.getSession(true); 
 	Usuario u = (Usuario) sesion.getAttribute("usuario");
%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">JRuteros</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<% 	if(u != null){
      			if(u.getEs_admin()){ %>
        			<li><a href="usuarios">Usuarios<span class="sr-only"></span></a></li>
        <%		}
      		} %>
        <li><a href="actividades">Activides</a></li>
        <li><a href="rutas">Rutas</a></li>
        
      </ul>
      <form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/ver_ruta" method="POST" >
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Buscar ruta" name="nombre" required>
        </div>
		<div class="btn-group">
			<button name="Submit" value="buscar" type="Submit" class="btn btn-default">
				&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;
			</button>
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				&nbsp;<span class="caret"></span>&nbsp;
			</button>
			<ul class="dropdown-menu">
				<li><a href="#">Busqueda avanzada</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="#">Otro tipo de busqueda(?)</a></li>
			</ul>
		</div>
	</form>
    <ul class="nav navbar-nav navbar-right">
		<% if(u != null){ %>			
			<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
			<span class="caret"></span><%=u.getUsuario()%></a>
			<ul class="dropdown-menu">
				<li><a href="ver_usuario?usuario=<%=u.getUsuario()%>">Mi Perfil</a></li>
				<li><a href="editar_usuario?usuario=<%=u.getUsuario()%>">Editar mi perfil</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="#">Ver mis rutas</a></li>		
				<li role="separator" class="divider"></li>		
				<li><a href="TerminarSesion">Desloguearse</a></li>
			</ul>
		<%}else{ %>
			<li><a href="${pageContext.request.contextPath}/vistas/login.html">Loguearse</a></li>
		<%} %>
		</ul>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
package controladores.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAOImplementacion;
import modelos.Usuario;

@WebServlet("/nuevo_usuario")
public class Nuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setDni(request.getParameter("dni"));
		usuario.setDomicilio(request.getParameter("domicilio"));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setApellido(request.getParameter("apellido"));
		usuario.setFecha_de_nacimiento(request.getParameter("fecha_de_nacimiento"));
		usuario.setSexo(request.getParameter("sexo"));
		usuario.setEmail(request.getParameter("email"));
		
		//UsuarioDAO.addNew(usuario);
		
		response.sendRedirect("./vistas/login.html");	
	}

}

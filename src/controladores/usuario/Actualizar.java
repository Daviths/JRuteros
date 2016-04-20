package controladores.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;

@WebServlet("/actualizar_usuario")
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String dni = request.getParameter("dni");
		String domicilio = request.getParameter("domicilio");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		UsuarioDAO usuario_dao = new UsuarioDAO();
		usuario_dao.edit(usuario, dni, domicilio, nombre, apellido);
		
		response.sendRedirect("usuarios");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

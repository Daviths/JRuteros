package controladores.sesion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import modelos.Usuario;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Usuario u = UsuarioDAO.getUsuario(usuario);
		
		if(u != null) {
			if(u.getPassword().equals(password)) {
				if(u.getEsta_habilitado()){
					System.out.println("SESION INICIADA CORRECTAMENTE");
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("usuario", u);
					if(u.getEs_admin()){
						response.sendRedirect("usuarios");
					}else{
						response.sendRedirect("actividades");
					}
				}else{
					System.out.println("Usuario Deshabilitado");
					response.sendRedirect("../JRuteros/vistas/login.html?error=Usuario_deshabilitado");
				}
			} else {
				System.out.println("PASSWORD INCORRECTA");
				response.sendRedirect("../JRuteros/vistas/login.html?error=Password_incorrecta");
			}
		} else {
			System.out.println("USUARIO INCORRECTO O NO EXISTE");
			response.sendRedirect("../JRuteros/vistas/login.html?error=Usuario_incorrecto");
		}
		
	}
}

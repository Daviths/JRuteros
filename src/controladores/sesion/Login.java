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

@WebServlet("/LoginUsr")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Usuario u = UsuarioDAO.getUsuario(usuario);
		
		if(u != null) {
			if(u.getPassword().equals(password)) {
				System.out.println("SESION INICIADA CORRECTAMENTE");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("usuario", u);
				response.sendRedirect("../JRuteros/vistas/Actividades/index.jsp");
			} else {
				System.out.println("PASSWORD INCORRECTA");
				response.sendRedirect("../JRuteros/vistas/login.html");
			}
		} else {
			System.out.println("USUARIO INCORRECTO O NO EXISTE");
		}
		
	}
}

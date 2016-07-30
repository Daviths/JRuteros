package controladores.usuario;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.istack.internal.logging.Logger;

//import dao.UsuarioDAOImplementacion;
import modelos.Usuario;

@WebServlet("/ver_usuario")
public class Ver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		//Usuario u = UsuarioDAO.getUsuario(usuario);
		//request.setAttribute("usuario", u);
		RequestDispatcher rd = request.getRequestDispatcher("/vistas/Usuarios/ver.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException ex) {
            Logger.getLogger(Editar.class.getName(), null).log(Level.SEVERE, null, ex);
        }	
	}

}

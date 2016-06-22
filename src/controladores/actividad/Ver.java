package controladores.actividad;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.istack.internal.logging.Logger;

import dao.ActividadDAOImplementacion;
import modelos.Actividad;

@WebServlet("/ver_actividad")
public class Ver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actividad = request.getParameter("nombre");
		//Actividad u = ActividadDAO.getActividad(actividad);
		//request.setAttribute("actividad", u);
		RequestDispatcher rd = request.getRequestDispatcher("/vistas/Actividades/ver.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException ex) {
            Logger.getLogger(Editar.class.getName(), null).log(Level.SEVERE, null, ex);
        }	
	}

}

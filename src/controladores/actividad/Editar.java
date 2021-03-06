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

//import dao.ActividadDAOImplementacion;
import modelos.Actividad;

@WebServlet("/editar_actividad")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		//Actividad u = ActividadDAO.getActividad(nombre);
		//request.setAttribute("actividad", u);
		RequestDispatcher rd = request.getRequestDispatcher("/vistas/Actividades/editar.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException ex) {
            Logger.getLogger(Editar.class.getName(), null).log(Level.SEVERE, null, ex);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion = request.getParameter("descripcion");
		String nombre_nuevo = request.getParameter("nombre_nuevo");
		String nombre_original = request.getParameter("nombre_original");
		//ActividadDAO.edit(nombre_original, nombre_nuevo, descripcion);
		response.sendRedirect("actividades");
	}

}

package controladores.actividad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import dao.ActividadDAOImplementacion;
import modelos.Actividad;

@WebServlet("/nueva_actividad")
public class Nuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Actividad actividad = new Actividad();
		actividad.setNombre(request.getParameter("nombre"));
		actividad.setDescripcion(request.getParameter("descripcion"));
		//ActividadDAO.addNew(actividad);		
		response.sendRedirect("actividades");	
	}

}

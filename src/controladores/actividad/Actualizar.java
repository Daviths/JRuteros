package controladores.actividad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActividadDAO;

@WebServlet("/actualizar_actividad")
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descripcion = request.getParameter("descripcion");
		String nombre_nuevo = request.getParameter("nombre_nuevo");
		String nombre_original = request.getParameter("nombre_original");
		ActividadDAO.edit(nombre_original, nombre_nuevo, descripcion);
		
		response.sendRedirect("actividades");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

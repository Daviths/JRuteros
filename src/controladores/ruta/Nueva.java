package controladores.ruta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Ruta;

@WebServlet("/nueva_ruta")
public class Nueva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("actividades", ActividadDAO.getAll());
		RequestDispatcher rs = request.getRequestDispatcher("/vistas/Rutas/nueva.jsp"); 
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ruta ruta = new Ruta();
		ruta.setNombre(request.getParameter("nombre"));
		ruta.setDescripcion(request.getParameter("descripcion"));
		ruta.setEs_publica(request.getParameter("privacidad").equals("PUBLICA"));		
		ruta.setEs_circular(request.getParameter("formato").equals("CIRCULAR"));
		ruta.setDistancia(Double.parseDouble(request.getParameter("distancia")));
		ruta.setDificultad(request.getParameter("dificultad"));
		//ruta.setActividad(request.getParameter("actividad"));
		ruta.setTiempo_estimado(Double.parseDouble(request.getParameter("tiempo")));
		//ruta.setUsuario(request.getParameter("usuario"));
		ruta.setFecha_de_realizacion(request.getParameter("fecha"));
		//RutaDAO.addNew(ruta);		
		response.sendRedirect("rutas");	
	}

}

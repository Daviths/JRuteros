package controladores.ruta;

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
//import dao.RutaDAOImplementacion;
import modelos.Ruta;

@WebServlet("/editar_ruta")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		//Ruta u = RutaDAO.getRuta(nombre);
		//request.setAttribute("ruta", u);
		//request.setAttribute("actividades", ActividadDAO.getAll());
		RequestDispatcher rd = request.getRequestDispatcher("/vistas/Rutas/editar.jsp");
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
		Boolean es_publica = request.getParameter("privacidad").equals("PUBLICA");
		Boolean es_circular = request.getParameter("formato").equals("CIRCULAR");
		Float distancia= Float.parseFloat(request.getParameter("distancia"));
		Float tiempo_estimado = Float.parseFloat(request.getParameter("tiempo"));
		String actividad= request.getParameter("actividad");
		String dificultad= request.getParameter("dificultad");
		//RutaDAO.edit(nombre_original, nombre_nuevo, descripcion,es_publica,es_circular,distancia,tiempo_estimado,actividad,dificultad);
		
		response.sendRedirect("rutas");
	}

}

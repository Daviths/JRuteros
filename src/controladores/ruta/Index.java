package controladores.ruta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import dao.ActividadDAOImplementacion;
//import dao.RutaDAOImplementacion;

@WebServlet("/rutas")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//request.setAttribute("actividades", ActividadDAO.getAll());
		//request.setAttribute("rutas", RutaDAO.getAll());
		RequestDispatcher rs = request.getRequestDispatcher("/vistas/Rutas/index.jsp"); 
		rs.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

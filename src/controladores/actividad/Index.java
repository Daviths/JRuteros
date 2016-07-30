package controladores.actividad;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import dao.ActividadDAOImplementacion;

@WebServlet("/actividades")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//request.setAttribute("actividades", ActividadDAO.getAll());
		RequestDispatcher rs = request.getRequestDispatcher("/vistas/Actividades/index.jsp"); 
		rs.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("/vistas/Actividades/index.jsp");
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("/vistas/Actividades/index.jsp");
		processRequest(request, response);
		
	}

}

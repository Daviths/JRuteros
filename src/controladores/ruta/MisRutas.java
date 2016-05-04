package controladores.ruta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ActividadDAO;
import dao.RutaDAO;
import modelos.Usuario;

/**
 * Servlet implementation class MisRutas
 */
@WebServlet("/MisRutas")
public class MisRutas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Usuario u = (Usuario) sesion.getAttribute("usuario");
		request.setAttribute("user", u.getUsuario());
		request.setAttribute("actividades", ActividadDAO.getAll());
		request.setAttribute("rutas", RutaDAO.getAll());
		RequestDispatcher rs = request.getRequestDispatcher("/vistas/Rutas/propias.jsp"); 
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package test;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Actividad;

/**
 * Servlet implementation class TestActividad
 */
@WebServlet("/TestActividad")
public class TestActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		emf = Persistence.createEntityManagerFactory("JRPA2");
		em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		
		Actividad a = new Actividad();
		a.setNombre("Aglo");
		a.setDescripcion("Otro");
		a.setEsta_habilitada(true);
		
		em.persist(a);
		/*
		List<Actividad> actividades=(List<Actividad>)(em.createQuery("from modelos.Actividad")).getResultList();
		for (Actividad ac:actividades) {
			response.getWriter().append("Nombre: ").append(ac.getNombre()).append('\n');
		}	*/	
		etx.commit();
		em.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

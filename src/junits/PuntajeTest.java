package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.PuntajeDAOImplementacion;
import modelos.Puntaje;

public class PuntajeTest {
	
	private PuntajeDAOImplementacion puntajeDAO = new PuntajeDAOImplementacion();
	private Puntaje puntaje;
	private int puntaje_id;

	private void cargarPuntaje(int id) {
		puntaje = new Puntaje(id, 99, "UNA_FECHA");
		puntajeDAO.addNew(puntaje);
	}

	@Test
	public void testAddNew() {
		puntaje_id = 1111;		
		
		cargarPuntaje(puntaje_id);
		
		Integer puntaje_puntos = puntaje.getPuntos();
		
		puntaje = puntajeDAO.getPuntaje(puntaje_id);
		
		Assert.assertEquals(puntaje_puntos, puntaje.getPuntos());
	}

	@Test
	public void testGetAll() {
		cargarPuntaje(2222);
		
		List<Puntaje> puntaje = puntajeDAO.getAll();
		
		Assert.assertNotNull("Puntaje es null", puntaje);
	}

	@Test	
	public void testEdit() {
		cargarPuntaje(3333);

		int puntaje_id = puntajeDAO.getPuntaje(3333).getId();		
		
		puntajeDAO.edit(puntaje_id, 99, "NUEVA_FECHA");		
		puntaje = puntajeDAO.getPuntaje(puntaje_id);
		
		Assert.assertEquals((Integer)99, puntaje.getPuntos());
		Assert.assertEquals("NUEVA_FECHA", puntaje.getFecha());
	}

	@Test	
	public void testDelete() {
		cargarPuntaje(4444);

		int puntaje_id = puntajeDAO.getPuntaje(4444).getId();
		puntajeDAO.delete(puntaje_id);
		
		puntaje = puntajeDAO.getPuntaje(puntaje_id);
		
		Assert.assertNull("Puntaje no es null.", puntaje);
	}
	
}

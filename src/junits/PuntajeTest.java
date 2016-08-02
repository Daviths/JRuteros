package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import modelos.Puntaje;
import servicios.PuntajeServicio;

public class PuntajeTest {	

	private PuntajeServicio puntajeServicio = new PuntajeServicio();
	private Puntaje puntaje, aux;	
	
	private void cargarPuntaje(int puntos) {
		
		puntaje = new Puntaje();
		puntaje.setPuntos(puntos);
		puntajeServicio.persist(puntaje);
	}
	
	private void recuperarPuntaje(Integer id) {		
		//List<Puntaje> puntajes = puntajeServicio.findAll();
		//aux = puntajes.get(0);	
		aux = puntajeServicio.findById(id);
	}

	@Test
	public void testPersist() {		
		cargarPuntaje(1);
		recuperarPuntaje(puntaje.getId());		
		Assert.assertEquals(puntaje.getPuntos(), aux.getPuntos());		
	}

	@Test
	public void testUpdate() {
		cargarPuntaje(2);
		recuperarPuntaje(puntaje.getId());
		
		aux.setPuntos(50);
		puntajeServicio.update(aux);		
		recuperarPuntaje(aux.getId());
		
		Assert.assertNotEquals(puntaje.getPuntos(), aux.getPuntos());
	}

	@Test
	public void testFindById() {
		cargarPuntaje(3);
		recuperarPuntaje(puntaje.getId());
		Integer puntaje_id = aux.getId();
		aux = puntajeServicio.findById(puntaje_id);
		
		Assert.assertEquals(puntaje.getPuntos(), aux.getPuntos());
	}

	@Test
	public void testDelete() {
		cargarPuntaje(4);
		recuperarPuntaje(puntaje.getId());
		Integer puntaje_id = aux.getId();
		
		puntajeServicio.delete(puntaje_id);
		aux = puntajeServicio.findById(puntaje_id);
		
		Assert.assertNull(aux);
	}

	@Test
	public void testFindAll() {
		cargarPuntaje(5);
		List<Puntaje> puntajes = puntajeServicio.findAll();
		
		Assert.assertNotNull("Puntajees es null", puntajes);
	}

	@Test
	public void testDeleteAll() {
		cargarPuntaje(6);
		puntajeServicio.deleteAll();
		List<Puntaje> puntajes = puntajeServicio.findAll();
		Assert.assertEquals(puntajes.isEmpty(), true);
		//Assert.assertNull(puntajes);
	}

}
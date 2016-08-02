package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import modelos.Coordenada;
import servicios.CoordenadaServicio;

public class CoordenadaTest {	

	private CoordenadaServicio coordenadaServicio = new CoordenadaServicio();
	private Coordenada coordenada, aux;	
	
	private void cargarCoordenada(double x, double y) {
		
		coordenada = new Coordenada();
		coordenada.setX(x);
		coordenada.setY(y);
		coordenadaServicio.persist(coordenada);
	}
	
	private void recuperarCoordenada(Integer id) {		
		//List<Coordenada> coordenadas = coordenadaServicio.findAll();
		//aux = coordenadas.get(0);	
		aux = coordenadaServicio.findById(id);
	}

	@Test
	public void testPersist() {		
		cargarCoordenada(1,2);
		recuperarCoordenada(coordenada.getId());		
		Assert.assertEquals(coordenada.getX(), aux.getX());		
		Assert.assertEquals(coordenada.getY(), aux.getY());	
	}

	@Test
	public void testUpdate() {
		cargarCoordenada(2,3);
		recuperarCoordenada(coordenada.getId());
		
		aux.setX(20.0);
		aux.setY(30.0);
		coordenadaServicio.update(aux);		
		recuperarCoordenada(aux.getId());
		
		Assert.assertNotEquals(coordenada.getX(), aux.getX());		
		Assert.assertNotEquals(coordenada.getY(), aux.getY());
	}

	@Test
	public void testFindById() {
		cargarCoordenada(3,4);
		recuperarCoordenada(coordenada.getId());
		Assert.assertNotNull(aux);
	}

	@Test
	public void testDelete() {
		cargarCoordenada(4,5);
		recuperarCoordenada(coordenada.getId());
		Integer coordenada_id = aux.getId();
		
		coordenadaServicio.delete(coordenada_id);
		aux = coordenadaServicio.findById(coordenada_id);
		
		Assert.assertNull(aux);
	}

	@Test
	public void testFindAll() {
		cargarCoordenada(5,6);
		List<Coordenada> coordenadas = coordenadaServicio.findAll();
		
		Assert.assertNotNull("Coordenadaes es null", coordenadas);
	}

	@Test
	public void testDeleteAll() {
		cargarCoordenada(7,8);
		coordenadaServicio.deleteAll();
		List<Coordenada> coordenadas = coordenadaServicio.findAll();
		Assert.assertEquals(coordenadas.isEmpty(), true);
		//Assert.assertNull(coordenadas);
	}

}
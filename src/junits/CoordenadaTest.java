package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.CoordenadaDAOImplementacion;
import modelos.Coordenada;

public class CoordenadaTest {
	private CoordenadaDAOImplementacion coordenadaDAO = new CoordenadaDAOImplementacion();
	private Coordenada coordenada;

	private void cargarcoordenada(String coordenada_nombre) {		
		coordenada = new Coordenada();
		
		coordenadaDAO.addNew(coordenada);
	}

	@Test
	public void testAddNew() {
		cargarcoordenada("testAddNew");
		
		coordenada = coordenadaDAO.findByName("testAddNew");
		
		Assert.assertEquals("testAddNew", coordenada.getCoordenada());
	}
	
	/*
	@Test
	public void testGetcoordenada(Integer id) {
		
	}
	*/

	@Test
	public void testGetAll() {
		cargarcoordenada("testGetAll");
		
		List<Coordenada> coordenadas = coordenadaDAO.getAll();
		
		Assert.assertNotNull("Coordenada es null", coordenadas);
	}
	
	@Test
	public void testEdit() {
		cargarcoordenada("testEdit");

		int coordenada_id = coordenadaDAO.findByName("testEdit").getId();		
		
		coordenadaDAO.edit();
		
		coordenada = coordenadaDAO.getCoordenada(coordenada_id);
		
		//Assert.assertEquals("NUEVO_DNI", coordenada.getDni());
	}
	
	@Test
	public void testDelete() {
		cargarcoordenada("testDelete");

		int coordenada_id = coordenadaDAO.findByName("testDelete").getId();
		coordenadaDAO.delete(coordenada_id);
		
		coordenada = coordenadaDAO.getCoordenada(coordenada_id);
		
		Assert.assertNull("Coordenada no es null.", coordenada);
	}
}

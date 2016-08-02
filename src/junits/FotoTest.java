package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import modelos.Foto;
import servicios.FotoServicio;

public class FotoTest {	

	private FotoServicio fotoServicio = new FotoServicio();
	private Foto foto, aux;	
	
	private void cargarFoto(String foto_nombre) {
		
		foto = new Foto();		
		fotoServicio.persist(foto);
	}
	
	private void recuperarFoto(Integer id) {		
		//List<Foto> fotos = fotoServicio.findAll();
		//aux = fotos.get(0);	
		aux = fotoServicio.findById(id);
	}

	@Test
	public void testPersist() {		
		cargarFoto("testPersist");
		recuperarFoto(foto.getId());		
		Assert.assertEquals(foto.getNombre(), aux.getNombre());		
	}

	@Test
	public void testUpdate() {
		cargarFoto("testUpdate");
		recuperarFoto(foto.getId());
		
		aux.setNombre("NUEVO_NOMBRE");
		fotoServicio.update(aux);		
		recuperarFoto(aux.getId());
		
		Assert.assertNotEquals(foto.getNombre(), aux.getNombre());
	}

	@Test
	public void testFindById() {
		cargarFoto("testFindById");
		recuperarFoto(foto.getId());
		Integer foto_id = aux.getId();
		aux = fotoServicio.findById(foto_id);
		
		Assert.assertEquals(foto.getNombre(), aux.getNombre());
	}

	@Test
	public void testDelete() {
		cargarFoto("testDelete");
		recuperarFoto(foto.getId());
		Integer foto_id = aux.getId();
		
		fotoServicio.delete(foto_id);
		aux = fotoServicio.findById(foto_id);
		
		Assert.assertNull(aux);
	}

	@Test
	public void testFindAll() {
		cargarFoto("testFindAll");
		List<Foto> fotos = fotoServicio.findAll();
		
		Assert.assertNotNull("Fotos es null", fotos);
	}

	@Test
	public void testDeleteAll() {
		cargarFoto("testDeleteAll");
		fotoServicio.deleteAll();
		List<Foto> fotos = fotoServicio.findAll();
		Assert.assertEquals(fotos.isEmpty(), true);
		//Assert.assertNull(fotos);
	}

}
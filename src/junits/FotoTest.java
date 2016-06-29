package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.FotoDAOImplementacion;
import modelos.Foto;

public class FotoTest {
	private FotoDAOImplementacion fotoDAO = new FotoDAOImplementacion();
	private Foto foto;
	
	private void cargarFoto(String nombre) {
		foto = new Foto(nombre, "TIPO", "CONTENIDO");
		fotoDAO.addNew(foto);
	}

	@Test
	public void testAddNew() {
		cargarFoto("testAddNew");
		
		foto = fotoDAO.findByName("testAddNew");
		
		Assert.assertEquals("testAddNew", foto.getNombre());
	}

	@Test
	public void testGetAll() {
		cargarFoto("testGetAll");
		
		List<Foto> foto = fotoDAO.getAll();
		
		Assert.assertNotNull("Foto es null", foto);
	}

	@Test	
	public void testEdit() {
		cargarFoto("testEdit");

		int foto_id = fotoDAO.findByName("testEdit").getId();		
		
		fotoDAO.edit(foto_id, "NUEVO_NOMBRE", "NUEVO_TIPO", "NUEVO_CONTENIDO");		
		foto = fotoDAO.getFoto(foto_id);
		
		Assert.assertEquals("NUEVO_NOMBRE", foto.getNombre());
		Assert.assertEquals("NUEVO_TIPO", foto.getTipo());
		Assert.assertEquals("NUEVO_CONTENIDO", foto.getContenido());
	}

	@Test	
	public void testDelete() {
		cargarFoto("testDelete");

		int foto_id = fotoDAO.findByName("testDelete").getId();
		fotoDAO.delete(foto_id);
		
		foto = fotoDAO.getFoto(foto_id);
		
		Assert.assertNull("Foto no es null.", foto);
	}
	/*
	@Test	
	public void testFindByName() {
		
	}
	
	@Test	
	public void testGetFoto() {
		
	}
	*/
	
}

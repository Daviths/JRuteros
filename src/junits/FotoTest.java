package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.ActividadDAOImplementacion;
import dao.FotoDAOImplementacion;
import dao.RutaDAOImplementacion;
import dao.UsuarioDAOImplementacion;
import modelos.Actividad;
import modelos.Foto;
import modelos.Ruta;
import modelos.Usuario;

public class FotoTest {
	private FotoDAOImplementacion fotoDAO = new FotoDAOImplementacion();
	private RutaDAOImplementacion rutaDAO = new RutaDAOImplementacion();
	private ActividadDAOImplementacion actividadDAO = new ActividadDAOImplementacion();
	private UsuarioDAOImplementacion usuarioDAO = new UsuarioDAOImplementacion();
	private Ruta ruta;
	private Usuario usuario;
	private Actividad actividad;
	private Foto foto;
	
	private void cargarFoto(String nombre) {
		ruta = new Ruta("Ruta"+nombre, "Neque pilro quisquam est qui dolorem", "2016-06-06",
				"UNA_DIFICULTAD", true, true, 20.55, 43.33);
		actividad = new Actividad(nombre+"Act", 
				"Neque pilro quisquam est qui dolorem",
				true);
		usuario = new Usuario("User"+nombre, "gaspar", "dni",
				"apellido", "nombre", "domicilio",
				"MASCULINO", "fecha_de_nacimiento", "email",
				false, true);
		usuarioDAO.addNew(usuario);
		actividadDAO.addNew(actividad);
		//ruta = new Ruta(nombre, null, null, null, null, null, null, null);
		ruta.setActividad(actividad);
		ruta.setUsuario(usuario); 
		rutaDAO.addNew(ruta); //Se carga
		
		foto = new Foto();
		foto.setNombre(nombre);
		foto.setContenido(nombre+"contenido");
		foto.setTipo("tipo");
		foto.setRuta(ruta);
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
		//cargarFoto("testGetAll");
		
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

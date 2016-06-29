package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.ActividadDAOImplementacion;
import dao.PuntajeDAOImplementacion;
import dao.RutaDAOImplementacion;
import dao.UsuarioDAOImplementacion;
import modelos.Actividad;
import modelos.Puntaje;
import modelos.Ruta;
import modelos.Usuario;

public class PuntajeTest {
	
	private PuntajeDAOImplementacion puntajeDAO = new PuntajeDAOImplementacion();
	private RutaDAOImplementacion rutaDAO = new RutaDAOImplementacion();
	private ActividadDAOImplementacion actividadDAO = new ActividadDAOImplementacion();
	private UsuarioDAOImplementacion usuarioDAO = new UsuarioDAOImplementacion();
	private Ruta ruta;
	private Usuario usuario;
	private Actividad actividad;
	private Puntaje puntaje;

	private void cargarPuntaje(String nombre) {
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
		puntaje = new Puntaje(99, "UNA_FECHA");
		puntaje.setUsuario(usuario);
		puntaje.setRuta(ruta);
		puntajeDAO.addNew(puntaje);
	}

	@Test
	public void testAddNew() {
		
		cargarPuntaje("Nuevo");
		
		Integer puntaje_puntos = puntaje.getPuntos();
		
		puntaje = puntajeDAO.getPuntajePorId(puntaje.getId());
		
		Assert.assertEquals(puntaje_puntos, puntaje.getPuntos());
	}

	@Test
	public void testGetAll() {
		cargarPuntaje("GetAll");
		
		List<Puntaje> puntaje = puntajeDAO.getAll();
		
		Assert.assertNotNull("Puntaje es null", puntaje);
	}

	@Test	
	public void testEdit() {
		cargarPuntaje("Edit");

		int puntaje_id = puntajeDAO.getPuntajePorId(puntaje.getId()).getId();
		
		puntajeDAO.edit(puntaje_id, 100, "NUEVA_FECHA");		
		puntaje = puntajeDAO.getPuntajePorId(puntaje_id);
		
		Assert.assertEquals((Integer)100, puntaje.getPuntos());
		Assert.assertEquals("NUEVA_FECHA", puntaje.getFecha());
	}

	@Test	
	public void testDelete() {
		cargarPuntaje("Delete");

		int puntaje_id =  puntajeDAO.getPuntajePorId(puntaje.getId()).getId();
		puntajeDAO.delete(puntaje_id);
		
		puntaje = puntajeDAO.getPuntajePorId(puntaje.getId());
		
		Assert.assertNull("Puntaje no es null.", puntaje);
	}
	
}

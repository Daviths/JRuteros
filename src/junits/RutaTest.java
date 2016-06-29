package junits;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.ActividadDAOImplementacion;
import dao.RutaDAOImplementacion;
import dao.UsuarioDAOImplementacion;
import modelos.Actividad;
import modelos.Ruta;
import modelos.Usuario;

public class RutaTest {
	private RutaDAOImplementacion rutaDAO = new RutaDAOImplementacion();
	private ActividadDAOImplementacion actividadDAO = new ActividadDAOImplementacion();
	private UsuarioDAOImplementacion usuarioDAO = new UsuarioDAOImplementacion();
	private Ruta ruta;
	private Usuario usuario;
	private Actividad actividad;

	private void cargarRuta(String nombre) {
		ruta = new Ruta(nombre, "Neque pilro quisquam est qui dolorem", "2016-06-06",
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
	}

	@Test
	public void testAddNew() {
		cargarRuta("testAddNew");
		
		ruta = rutaDAO.findByName("testAddNew");
		
		Assert.assertEquals("testAddNew", ruta.getNombre());
	}

	@Test
	public void testGetAll() {
		//cargarRuta("testGetAll");
		
		List<Ruta> rutas = rutaDAO.getAll();
		
		Assert.assertNotNull("Ruta es null", rutas);
	}

	@Test
	public void testEdit() {
		cargarRuta("testEdit");

		int ruta_id = rutaDAO.findByName("testEdit").getId();		
		
		rutaDAO.edit(ruta_id, "NUEVO_NOMBRE", "NUEVA_DESCRIPCION", "2222-02-02",
						"NUEVA_DIFICULTAD", false, false, 99.99, 11.11);
		
		Ruta AUX = rutaDAO.getRuta(ruta_id);
		
		Assert.assertEquals("NUEVO_NOMBRE", AUX.getNombre());
		Assert.assertEquals("NUEVA_DESCRIPCION", AUX.getDescripcion());
	}

	@Test
	public void testCambiarEstado() {
		cargarRuta("testCambiarEstado");
		
		ruta = rutaDAO.findByName("testCambiarEstado");
		int ruta_id = ruta.getId();
		Boolean es_publica = !ruta.getEs_publica();
		rutaDAO.cambiarEstado(ruta_id);
		
		ruta = rutaDAO.getRuta(ruta_id);
		
		Assert.assertEquals(es_publica, ruta.getEs_publica());
	}

	@Test
	public void testDelete() {
		cargarRuta("testDelete");

		int ruta_id = rutaDAO.findByName("testDelete").getId();
		rutaDAO.delete(ruta_id);
		
		ruta = rutaDAO.getRuta(ruta_id);
		
		Assert.assertNull("Ruta no es null.", ruta);
	}
}

package junits;

import org.junit.Test;

import dao.ActividadDAOImplementacion;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import modelos.Actividad;

public class ActividadTest {	
	private ActividadDAOImplementacion actividadDAO = new ActividadDAOImplementacion();
	private Actividad actividad;
	
	private void cargarActividad(String nombre) {
		actividad = new Actividad(nombre, 
				"Neque pilro quisquam est qui dolorem",
				true);
		
		actividadDAO.addNew(actividad);
	}
	
	@Test
	public void testAddNew() {
		cargarActividad("testAddNew");
		
		actividad = actividadDAO.findByName("testAddNew");
		
		Assert.assertEquals("testAddNew", actividad.getNombre());
	}
		
	@Test
	public void testGetAll() {
		cargarActividad("testGetAll");
		
		List<Actividad> actividades = actividadDAO.getAll();
		
		Assert.assertNotNull("Actividad es null", actividades);
	}
	
	@Test
	public void testEdit() {
		cargarActividad("testEdit");

		int actividad_id = actividadDAO.findByName("testEdit").getId();		
		
		actividadDAO.edit(actividad_id, "NUEVO_NOMBRE", "NUEVA_DESCRIPCION");		
		actividad = actividadDAO.getActividad(actividad_id);
		
		Assert.assertEquals("NUEVO_NOMBRE", actividad.getNombre());
		Assert.assertEquals("NUEVA_DESCRIPCION", actividad.getDescripcion());
	}
	
	@Test
	public void testCambiarEstado() {
		cargarActividad("testCambiarEstado");
		
		actividad = actividadDAO.findByName("testCambiarEstado");
		int actividad_id = actividad.getId();
		Boolean esta_habilitada = !actividad.getEsta_habilitada();
		actividadDAO.cambiarEstado(actividad_id);
		
		actividad = actividadDAO.getActividad(actividad_id);
		
		assertEquals(esta_habilitada, actividad.getEsta_habilitada());
	}	
	
	@Test
	public void testDelete() {
		cargarActividad("testDelete");

		int actividad_id = actividadDAO.findByName("testDelete").getId();
		actividadDAO.delete(actividad_id);
		
		actividad = actividadDAO.getActividad(actividad_id);
		
		Assert.assertNull("Actividad no es null.", actividad);
	}
}
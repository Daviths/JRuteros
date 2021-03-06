package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import modelos.Actividad;
import servicios.ActividadServicio;

public class ActividadTest {	

	private ActividadServicio actividadServicio = new ActividadServicio();
	private Actividad actividad, aux;	
	
	private void cargarActividad(String actividad_nombre) {
		
		actividad = new Actividad(
			actividad_nombre,
			"Neque pilro quisquam est qui dolorem",
			true
		);		
		actividadServicio.persist(actividad);
	}
	
	private void recuperarActividad(Integer id) {		
		//List<Actividad> actividades = actividadServicio.findAll();
		//aux = actividades.get(0);	
		aux = actividadServicio.findById(id);
	}

	@Test
	public void testPersist() {		
		cargarActividad("testPersist");
		recuperarActividad(actividad.getId());		
		Assert.assertEquals(actividad.getNombre(), aux.getNombre());		
	}

	@Test
	public void testUpdate() {
		cargarActividad("testUpdate");
		recuperarActividad(actividad.getId());
		
		aux.setNombre("NUEVO_NOMBRE");
		actividadServicio.update(aux);		
		recuperarActividad(aux.getId());
		
		Assert.assertNotEquals(actividad.getNombre(), aux.getNombre());
	}

	@Test
	public void testFindById() {
		cargarActividad("testFindById");
		recuperarActividad(actividad.getId());
		Integer actividad_id = aux.getId();
		aux = actividadServicio.findById(actividad_id);
		
		Assert.assertEquals(actividad.getNombre(), aux.getNombre());
	}

	@Test
	public void testDelete() {
		cargarActividad("testDelete");
		recuperarActividad(actividad.getId());
		Integer actividad_id = aux.getId();
		
		actividadServicio.delete(actividad_id);
		aux = actividadServicio.findById(actividad_id);
		
		Assert.assertNull(aux);
	}

	@Test
	public void testFindAll() {
		cargarActividad("testFindAll");
		List<Actividad> actividades = actividadServicio.findAll();
		
		Assert.assertNotNull("Actividades es null", actividades);
	}

	@Test
	public void testDeleteAll() {
		cargarActividad("testDeleteAll");
		actividadServicio.deleteAll();
		List<Actividad> actividades = actividadServicio.findAll();
		Assert.assertEquals(actividades.isEmpty(), true);
		//Assert.assertNull(actividades);
	}

}
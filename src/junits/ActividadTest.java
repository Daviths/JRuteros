package junits;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

import dao.implementacion.ActividadDao;
import modelos.Actividad;
import servicios.ActividadServicio;

public class ActividadTest {	

	private ActividadDao ActividadDAO = new ActividadDao();
	//private ActividadServicio actividadServicio = new ActividadServicio();
	private Actividad actividad, aux;	
	
	private void cargarActividad(String actividad_nombre) {
		
		actividad = new Actividad(
			actividad_nombre,
			"Neque pilro quisquam est qui dolorem",
			true
		);
		
		ActividadDAO.openCurrentSessionwithTransaction();
		ActividadDAO.persist(actividad);
		ActividadDAO.closeCurrentSessionwithTransaction();
	}
	
	private void recuperarActividad() {

		ActividadDAO.openCurrentSessionwithTransaction();
		List<Actividad> actividades = ActividadDAO.findAll();
		aux = actividades.get(0);
		ActividadDAO.closeCurrentSessionwithTransaction();
	}

	@Test
	public void testPersist() {		
		cargarActividad("testPersist");
		recuperarActividad();		
		Assert.assertEquals(actividad.getNombre(), aux.getNombre());
		
	}

	//@Test
	public void testUpdate() {
		cargarActividad("testUpdate");
		recuperarActividad();
		
		aux.setNombre("NUEVO_NOMBRE");
		ActividadDAO.update(aux);		
		recuperarActividad();
		
		Assert.assertNotEquals(actividad.getNombre(), aux.getNombre());
	}

	//@Test
	public void testFindById() {
		cargarActividad("testFindById");
		recuperarActividad();
		Integer actividad_id = aux.getId();
		aux = ActividadDAO.findById(actividad_id);
		
		Assert.assertEquals(actividad.getNombre(), aux.getNombre());
	}

	//@Test
	public void testDelete() {
		cargarActividad("testDelete");
		recuperarActividad();
		Integer actividad_id = aux.getId();
		
		ActividadDAO.delete(ActividadDAO.findById(actividad_id));
		aux = ActividadDAO.findById(actividad_id);
		
		Assert.assertNull(aux);
	}

	//@Test
	public void testFindAll() {
		cargarActividad("testFindAll");
		List<Actividad> actividades = ActividadDAO.findAll();
		
		Assert.assertNotNull("Actividades es null", actividades);
	}

	//@Test
	public void testDeleteAll() {
		cargarActividad("testDeleteAll");
		ActividadDAO.deleteAll();
		List<Actividad> actividades = ActividadDAO.findAll();
		
		Assert.assertNull("Actividades no es null", actividades);
	}

}
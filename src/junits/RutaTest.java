package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import modelos.Ruta;
import servicios.RutaServicio;

public class RutaTest {	

	private RutaServicio rutaServicio = new RutaServicio();
	private Ruta ruta, aux;	
	
	private void cargarRuta(String ruta_nombre) {		
		ruta = new Ruta();	
		/*Actividad actividad = new Actividad(ruta_nombre+"_act","Descripcion",true);
		Usuario usuario = new Usuario();
		usuario.setUsuario(ruta_nombre+"_usuario");
		actividadServicio.persist(actividad);
		usuarioServicio.persist(usuario);
		actividad.setId(7);
		usuario.setId(7);
		ruta.setActividad(actividad);
		ruta.setUsuario(usuario);*/
		ruta.setNombre(ruta_nombre);
		rutaServicio.persist(ruta);
	}
	
	private void recuperarRuta(Integer id) {		
		//List<Ruta> rutas = rutaServicio.findAll();
		//aux = rutas.get(0);	
		aux = rutaServicio.findById(id);
		System.out.println(aux.getNombre());
	}

	@Test
	public void testPersist() {		
		cargarRuta("testPersist");
		recuperarRuta(ruta.getId());
		Assert.assertEquals(ruta.getNombre(), aux.getNombre());		
	}

	@Test
	public void testUpdate() {
		cargarRuta("testUpdate");
		recuperarRuta(ruta.getId());
		
		aux.setNombre("NUEVO_NOMBRE");
		rutaServicio.update(aux);		
		recuperarRuta(aux.getId());
		
		Assert.assertNotEquals(ruta.getNombre(), aux.getNombre());
	}

	@Test
	public void testFindById() {
		cargarRuta("testFindById");
		recuperarRuta(ruta.getId());
		Integer ruta_id = aux.getId();
		aux = rutaServicio.findById(ruta_id);
		
		Assert.assertEquals(ruta.getNombre(), aux.getNombre());
	}

	@Test
	public void testDelete() {
		cargarRuta("testDelete");
		recuperarRuta(ruta.getId());
		Integer ruta_id = aux.getId();
		
		rutaServicio.delete(ruta_id);
		aux = rutaServicio.findById(ruta_id);
		
		Assert.assertNull(aux);
	}

	@Test
	public void testFindAll() {
		cargarRuta("testFindAll");
		List<Ruta> rutas = rutaServicio.findAll();		
		Assert.assertNotNull("Rutas es null", rutas);
	}

	@Test
	public void testDeleteAll() {
		cargarRuta("testDeleteAll");
		rutaServicio.deleteAll();
		List<Ruta> rutas = rutaServicio.findAll();
		Assert.assertEquals(rutas.isEmpty(), true);
		//Assert.assertNull(rutas);
	}

}
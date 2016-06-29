package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.ActividadDAOImplementacion;
import dao.CoordenadaDAOImplementacion;
import dao.RutaDAOImplementacion;
import dao.UsuarioDAOImplementacion;
import modelos.Actividad;
import modelos.Coordenada;
import modelos.Ruta;
import modelos.Usuario;

public class CoordenadaTest {
	private CoordenadaDAOImplementacion coordenadaDAO = new CoordenadaDAOImplementacion();
	private RutaDAOImplementacion rutaDAO = new RutaDAOImplementacion();
	private ActividadDAOImplementacion actividadDAO = new ActividadDAOImplementacion();
	private UsuarioDAOImplementacion usuarioDAO = new UsuarioDAOImplementacion();
	private Ruta ruta;
	private Usuario usuario;
	private Actividad actividad;
	private Coordenada coordenada;

	private void cargarcoordenada(String nombre) {		
		coordenada = new Coordenada();
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
		coordenada.setX((double)5);
		coordenada.setY((double)10);
		coordenada.setRuta(ruta);
		coordenadaDAO.addNew(coordenada);
	}

	@Test
	public void testAddNew() {
		cargarcoordenada("testAddNew");
		
		double x = coordenada.getX();
		double y = coordenada.getY();
		
		coordenada = coordenadaDAO.getCoordenada(coordenada.getId());
		
		Assert.assertEquals(x, (double) coordenada.getX(), 0.01); 
		Assert.assertEquals(y, (double) coordenada.getY(), 0.01); 
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

		int coordenada_id = coordenadaDAO.getCoordenada(coordenada.getId()).getId();		
		
		coordenadaDAO.edit(coordenada_id, (double)7,(double)15);
		
		coordenada = coordenadaDAO.getCoordenada(coordenada_id);
		
		Assert.assertEquals((double)7, (double) coordenada.getX(), 0.01); 
		Assert.assertEquals((double)15, (double) coordenada.getY(), 0.01); 
	}
	
	@Test
	public void testDelete() {
		cargarcoordenada("testDelete");

		int coordenada_id = coordenadaDAO.getCoordenada(coordenada.getId()).getId();	
		coordenadaDAO.delete(coordenada_id);
		
		coordenada = coordenadaDAO.getCoordenada(coordenada_id);
		
		Assert.assertNull("Coordenada no es null.", coordenada);
	}
}

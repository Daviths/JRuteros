package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import modelos.Usuario;
import servicios.UsuarioServicio;

public class UsuarioTest {	

	private UsuarioServicio usuarioServicio = new UsuarioServicio();
	private Usuario usuario, aux;	
	
	private void cargarUsuario(String usuario_nombre) {
		
		usuario = new Usuario();
		usuario.setUsuario(usuario_nombre);
		usuario.setEsta_habilitado(true);
		usuario.setEs_admin(false);
		usuarioServicio.persist(usuario);
	}
	
	private void recuperarUsuario(Integer id) {		
		//List<Usuario> usuarios = usuarioServicio.findAll();
		//aux = usuarios.get(0);	
		aux = usuarioServicio.findById(id);
	}

	@Test
	public void testPersist() {		
		cargarUsuario("testPersist");
		recuperarUsuario(usuario.getId());		
		Assert.assertEquals(usuario.getNombre(), aux.getNombre());		
	}

	@Test
	public void testUpdate() {
		cargarUsuario("testUpdate");
		recuperarUsuario(usuario.getId());
		
		aux.setNombre("NUEVO_NOMBRE");
		usuarioServicio.update(aux);		
		recuperarUsuario(aux.getId());
		
		Assert.assertNotEquals(usuario.getNombre(), aux.getNombre());
	}

	@Test
	public void testFindById() {
		cargarUsuario("testFindById");
		recuperarUsuario(usuario.getId());
		Integer usuario_id = aux.getId();
		aux = usuarioServicio.findById(usuario_id);
		
		Assert.assertEquals(usuario.getNombre(), aux.getNombre());
	}

	@Test
	public void testDelete() {
		cargarUsuario("testDelete");
		recuperarUsuario(usuario.getId());
		Integer usuario_id = aux.getId();
		
		usuarioServicio.delete(usuario_id);
		aux = usuarioServicio.findById(usuario_id);
		
		Assert.assertNull(aux);
	}

	@Test
	public void testFindAll() {
		cargarUsuario("testFindAll");
		List<Usuario> usuarios = usuarioServicio.findAll();
		
		Assert.assertNotNull("Usuarioes es null", usuarios);
	}

	@Test
	public void testDeleteAll() {
		cargarUsuario("testDeleteAll");
		usuarioServicio.deleteAll();
		List<Usuario> usuarios = usuarioServicio.findAll();
		Assert.assertEquals(usuarios.isEmpty(), true);
		//Assert.assertNull(usuarios);
	}

}
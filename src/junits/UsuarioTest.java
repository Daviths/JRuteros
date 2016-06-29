package junits;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.UsuarioDAOImplementacion;
import modelos.Usuario;

public class UsuarioTest {
	private UsuarioDAOImplementacion usuarioDAO = new UsuarioDAOImplementacion();
	private Usuario usuario;

	private void cargarUsuario(String usuario_nombre) {
		/*usuario = new Usuario(usuario_nombre, "gaspar", null,
				null, null, null,
				null, null, null,
				false, true);*/
		
		usuario = new Usuario(usuario_nombre, "gaspar", "dni",
				"apellido", "nombre", "domicilio",
				"MASCULINO", "fecha_de_nacimiento", "email",
				false, true);
		
		usuarioDAO.addNew(usuario);
	}

	@Test
	public void testAddNew() {
		cargarUsuario("testAddNew");
		
		usuario = usuarioDAO.findByName("testAddNew");
		
		Assert.assertEquals("testAddNew", usuario.getUsuario());
	}
	
	@Test
	public void testGetAll() {
		cargarUsuario("testGetAll");
		
		List<Usuario> usuarios = usuarioDAO.getAll();
		
		Assert.assertNotNull("Usuario es null", usuarios);
	}
	/*
	@Test
	public void testGetUsuario(Integer id) {
		
	}
	*/
	@Test
	public void testEdit() {
		cargarUsuario("testEdit");

		int usuario_id = usuarioDAO.findByName("testEdit").getId();		
		
		usuarioDAO.edit(usuario_id, "NUEVO_DNI", "NUEVO_DOMICILIO", "NUEVO_NOMBRE",
				"NUEVO_APELLIDO", "FEMENINO", "NUEVO_EMAIL");
		
		usuario = usuarioDAO.getUsuario(usuario_id);
		
		Assert.assertEquals("NUEVO_DNI", usuario.getDni());
		Assert.assertEquals("NUEVO_DOMICILIO", usuario.getDomicilio());
		Assert.assertEquals("NUEVO_NOMBRE", usuario.getNombre());
		Assert.assertEquals("NUEVO_APELLIDO", usuario.getApellido());
		Assert.assertEquals("FEMENINO", usuario.getSexo());
		Assert.assertEquals("NUEVO_EMAIL", usuario.getEmail());
	}
	
	@Test
	public void testCambiarEstado() {
		cargarUsuario("testCambiarEstado");
		
		usuario = usuarioDAO.findByName("testCambiarEstado");
		int usuario_id = usuario.getId();
		Boolean es_publica = !usuario.getEsta_habilitado();
		usuarioDAO.cambiarEstado(usuario_id);
		
		usuario = usuarioDAO.getUsuario(usuario_id);
		
		Assert.assertEquals(es_publica, usuario.getEsta_habilitado());
	}
	
	@Test
	public void testDelete() {
		cargarUsuario("testDelete");

		int usuario_id = usuarioDAO.findByName("testDelete").getId();
		usuarioDAO.delete(usuario_id);
		
		usuario = usuarioDAO.getUsuario(usuario_id);
		
		Assert.assertNull("Usuario no es null.", usuario);
	}
}

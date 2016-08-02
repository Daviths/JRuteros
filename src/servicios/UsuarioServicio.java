package servicios;

import java.util.List;

import dao.implementacion.UsuarioDao;
import modelos.Usuario;

public class UsuarioServicio {
	
	private static UsuarioDao UsuarioDAO;
	
	public UsuarioServicio() {
		UsuarioDAO = new UsuarioDao();
	}
	
	public void cambiarEstado(Integer usuario_id) {
		UsuarioDAO.openCurrentSessionwithTransaction();
		UsuarioDAO.cambiarEstado(usuario_id);
		UsuarioDAO.closeCurrentSessionwithTransaction();
	}
	
	public void persist(Usuario usuario) {
		UsuarioDAO.openCurrentSessionwithTransaction();
		UsuarioDAO.persist(usuario);
		UsuarioDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(Usuario usuario) {
		UsuarioDAO.openCurrentSessionwithTransaction();
		UsuarioDAO.update(usuario);
		UsuarioDAO.closeCurrentSessionwithTransaction();		
	}
	
	public Usuario findById(Integer usuario_id) {
		UsuarioDAO.openCurrentSession();
		Usuario usuario = UsuarioDAO.findById(usuario_id);
		UsuarioDAO.closeCurrentSession();		
		return usuario;
	}
	
	public void delete(Integer usuario_id) {
		UsuarioDAO.openCurrentSessionwithTransaction();
		Usuario usuario = UsuarioDAO.findById(usuario_id);
		UsuarioDAO.delete(usuario);
		UsuarioDAO.closeCurrentSessionwithTransaction();	
	}
	
	public List<Usuario> findAll() {
		UsuarioDAO.openCurrentSessionwithTransaction();
		List<Usuario> usuarios = UsuarioDAO.findAll();
		UsuarioDAO.closeCurrentSessionwithTransaction();		
		return usuarios;
	}
	
	public void deleteAll() {
		UsuarioDAO.openCurrentSessionwithTransaction();
		UsuarioDAO.deleteAll();
		UsuarioDAO.closeCurrentSessionwithTransaction();	
	}
	
}

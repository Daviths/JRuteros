package servicios;

import java.util.List;

import dao.implementacion.UsuarioDao;
import modelos.Usuario;
import utils.JpaUtil;

public class UsuarioServicio {
	
	private static UsuarioDao usuarioDao;
	
	public UsuarioServicio() {
		usuarioDao = new UsuarioDao();
	}
	
	public void persist(Usuario usuario) {
		JpaUtil.beginTransaction();
		usuarioDao.persist(usuario);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public void update(Usuario usuario) {
		JpaUtil.beginTransaction();
		usuarioDao.update(usuario);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public Usuario findById(Integer usuario_id) {
		JpaUtil.getSession();
		Usuario usuario = usuarioDao.findById(usuario_id);
		JpaUtil.closeSession();
		
		return usuario;
	}
	
	public void delete(Integer usuario_id) {
		JpaUtil.beginTransaction();
		Usuario usuario = usuarioDao.findById(usuario_id);
		usuarioDao.delete(usuario);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public List<Usuario> findAll() {
		JpaUtil.getSession();
		List<Usuario> usuarios = usuarioDao.findAll();
		JpaUtil.closeSession();
		
		return usuarios;
	}
	
	public void deleteAll() {
		JpaUtil.beginTransaction();
		usuarioDao.deleteAll();
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}

}

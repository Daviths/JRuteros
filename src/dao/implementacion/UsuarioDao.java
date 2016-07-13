package dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.UsuarioDaoInterfaz;
import modelos.Usuario;
import utils.JpaUtil;

public class UsuarioDao implements UsuarioDaoInterfaz {	
	
	protected EntityManager getEntityManager() {
		return JpaUtil.getSession();
	}

	@Override
	public void persist(Usuario usuario) {
		getEntityManager().persist(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		getEntityManager().merge(usuario);
	}

	@Override
	public Usuario findById(Integer usuario_id) {
		Usuario usuario = getEntityManager().find(Usuario.class, usuario_id);
		return usuario;
	}

	@Override
	public void delete(Usuario usuario) {
		getEntityManager().merge(usuario);
		getEntityManager().remove(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		String query = "FROM usuarios";
		List<Usuario> usuarios = getEntityManager().createQuery(query).getResultList();
		return usuarios;
	}

	@Override
	public void deleteAll() {
		List<Usuario> usuarios = findAll();
		for (Usuario usuario: usuarios) {
			delete(usuario);
		}
	}

}

package dao.interfaces;

import java.util.List;

import modelos.Usuario;

public interface UsuarioDaoInterfaz {

	void persist(Usuario usuario);
	void update(Usuario usuario);
	Usuario findById(Integer usuario_id);
	void delete(Usuario usuario);
	List<Usuario> findAll();
	void deleteAll();
	
}

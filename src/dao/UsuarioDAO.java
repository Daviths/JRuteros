package dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface UsuarioDAO {
	public Integer addNew(Object o, EntityManager em);
	public List<?> getAll(EntityManager em);
	public void edit(Integer UsuarioID, String dni, String domicilio, String nombre, String apellido, String sexo, String email,  EntityManager em);
	public void cambiarEstado(Integer a, EntityManager em);
	public void delete(Integer a, EntityManager em);
}

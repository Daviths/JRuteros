package dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface ActividadDAO {
	public Integer addNew(Object o, EntityManager em);
	public List<?> getAll(EntityManager em);
	public void edit(Integer a, String s1, String s2, EntityManager em);
	public void cambiarEstado(Integer a, EntityManager em);
	public void delete(Integer a, EntityManager em);
}

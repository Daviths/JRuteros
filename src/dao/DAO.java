package dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO {
	public Integer addNew(Object o, EntityManager em);
	public List<?> getAll(EntityManager em);
	//public void edit(); Varia depende de la clase
	public void cambiarEstado(Integer a, EntityManager em);
	public void delete(Integer a, EntityManager em);
}

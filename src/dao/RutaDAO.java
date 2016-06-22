package dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface RutaDAO {
	public Integer addNew(Object o, EntityManager em);
	public List<?> getAll(EntityManager em);
	public void edit(Integer RutaID, String nombre_nuevo,String descripcion, Boolean es_publica, Boolean es_circular, Float distancia, Float tiempo_estimado, String actividad, String dificultad, EntityManager em);
	public void cambiarEstado(Integer a, EntityManager em);
	public void delete(Integer a, EntityManager em);
}

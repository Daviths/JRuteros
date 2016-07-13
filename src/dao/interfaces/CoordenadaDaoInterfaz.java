package dao.interfaces;

import java.util.List;

import modelos.Coordenada;

public interface CoordenadaDaoInterfaz {
	
	void persist(Coordenada coordenada);
	void update(Coordenada coordenada);
	Coordenada findById(Integer coordenada_id);
	void delete(Coordenada coordenada);
	List<Coordenada> findAll();
	void deleteAll();
	
}

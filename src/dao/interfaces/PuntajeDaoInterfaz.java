package dao.interfaces;

import java.util.List;

import modelos.Puntaje;

public interface PuntajeDaoInterfaz {
	
	void persist(Puntaje puntaje);
	void update(Puntaje puntaje);
	Puntaje findById(Integer puntaje_id);
	void delete(Puntaje puntaje);
	List<Puntaje> findAll();
	void deleteAll();
	
}

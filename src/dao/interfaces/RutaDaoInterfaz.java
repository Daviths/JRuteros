package dao.interfaces;

import java.util.List;

import modelos.Ruta;

public interface RutaDaoInterfaz {

	void persist(Ruta ruta);
	void update(Ruta ruta);
	Ruta findById(Integer ruta_id);
	void delete(Ruta ruta);
	List<Ruta> findAll();
	void deleteAll();
	
}

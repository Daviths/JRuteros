package dao.interfaces;

import java.util.List;
import modelos.Actividad;

public interface ActividadDaoInterfaz {
	
	void persist(Actividad actividad);
	void update(Actividad actividad);
	Actividad findById(Integer actividad_id);
	void delete(Actividad actividad);
	List<Actividad> findAll();
	void deleteAll();
	
}

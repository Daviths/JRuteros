package servicios;

import java.util.List;

import dao.implementacion.PuntajeDao;
import modelos.Puntaje;

public class PuntajeServicio {

	private static PuntajeDao puntajeDao;
	
	public PuntajeServicio() {
		puntajeDao = new PuntajeDao();
	}
	
	public void persist(Puntaje puntaje) {
		puntajeDao.openCurrentSessionwithTransaction();
		puntajeDao.persist(puntaje);
		puntajeDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Puntaje puntaje) {
		puntajeDao.openCurrentSessionwithTransaction();
		puntajeDao.update(puntaje);
		puntajeDao.closeCurrentSessionwithTransaction();
	}
	
	public Puntaje findById(Integer puntaje_id) {
		puntajeDao.openCurrentSession();
		Puntaje puntaje = puntajeDao.findById(puntaje_id);
		puntajeDao.closeCurrentSession();
		
		return puntaje;
	}
	
	public void delete(Integer puntaje_id) {
		puntajeDao.openCurrentSessionwithTransaction();
		Puntaje puntaje = puntajeDao.findById(puntaje_id);
		puntajeDao.delete(puntaje);
		puntajeDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Puntaje> findAll() {
		puntajeDao.openCurrentSession();
		List<Puntaje> puntajes = puntajeDao.findAll();
		puntajeDao.closeCurrentSession();
		
		return puntajes;
	}
	
	public void deleteAll() {
		puntajeDao.openCurrentSessionwithTransaction();
		puntajeDao.deleteAll();
		puntajeDao.closeCurrentSessionwithTransaction();
	}
	
}

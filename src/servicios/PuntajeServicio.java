package servicios;

import java.util.List;

import dao.implementacion.PuntajeDao;
import modelos.Puntaje;
import utils.JpaUtil;

public class PuntajeServicio {

	private static PuntajeDao puntajeDao;
	
	public PuntajeServicio() {
		puntajeDao = new PuntajeDao();
	}
	
	public void persist(Puntaje puntaje) {
		JpaUtil.beginTransaction();
		puntajeDao.persist(puntaje);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public void update(Puntaje puntaje) {
		JpaUtil.beginTransaction();
		puntajeDao.update(puntaje);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public Puntaje findById(Integer puntaje_id) {
		JpaUtil.getSession();
		Puntaje puntaje = puntajeDao.findById(puntaje_id);
		JpaUtil.closeSession();
		
		return puntaje;
	}
	
	public void delete(Integer puntaje_id) {
		JpaUtil.beginTransaction();
		Puntaje puntaje = puntajeDao.findById(puntaje_id);
		puntajeDao.delete(puntaje);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public List<Puntaje> findAll() {
		JpaUtil.getSession();
		List<Puntaje> puntajes = puntajeDao.findAll();
		JpaUtil.closeSession();
		
		return puntajes;
	}
	
	public void deleteAll() {
		JpaUtil.beginTransaction();
		puntajeDao.deleteAll();
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
}

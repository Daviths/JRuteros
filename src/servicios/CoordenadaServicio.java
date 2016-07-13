package servicios;

import java.util.List;

import dao.implementacion.CoordenadaDao;
import modelos.Coordenada;
import utils.JpaUtil;

public class CoordenadaServicio {

	private static CoordenadaDao coordenadaDao;
	
	public CoordenadaServicio() {
		coordenadaDao = new CoordenadaDao();
	}
	
	public void persist(Coordenada coordenada) {
		JpaUtil.beginTransaction();
		coordenadaDao.persist(coordenada);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public void update(Coordenada coordenada) {
		JpaUtil.beginTransaction();
		coordenadaDao.update(coordenada);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public Coordenada findById(Integer coordenada_id) {
		JpaUtil.getSession();
		Coordenada coordenada = coordenadaDao.findById(coordenada_id);
		JpaUtil.closeSession();
		
		return coordenada;
	}
	
	public void delete(Integer coordenada_id) {
		JpaUtil.beginTransaction();
		Coordenada coordenada = coordenadaDao.findById(coordenada_id);
		coordenadaDao.delete(coordenada);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public List<Coordenada> findAll() {
		JpaUtil.getSession();
		List<Coordenada> coordenadaes = coordenadaDao.findAll();
		JpaUtil.closeSession();
		
		return coordenadaes;
	}
	
	public void deleteAll() {
		JpaUtil.beginTransaction();
		coordenadaDao.deleteAll();
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
}

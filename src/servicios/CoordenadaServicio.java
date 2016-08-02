package servicios;

import java.util.List;

import dao.implementacion.CoordenadaDao;
import modelos.Coordenada;

public class CoordenadaServicio {

	private static CoordenadaDao coordenadaDao;
	
	public CoordenadaServicio() {
		coordenadaDao = new CoordenadaDao();
	}
	
	public void persist(Coordenada coordenada) {
		coordenadaDao.openCurrentSessionwithTransaction();
		coordenadaDao.persist(coordenada);
		coordenadaDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Coordenada coordenada) {
		coordenadaDao.openCurrentSessionwithTransaction();
		coordenadaDao.update(coordenada);
		coordenadaDao.closeCurrentSessionwithTransaction();
	}
	
	public Coordenada findById(Integer coordenada_id) {
		coordenadaDao.openCurrentSession();
		Coordenada coordenada = coordenadaDao.findById(coordenada_id);
		coordenadaDao.closeCurrentSession();
		
		return coordenada;
	}
	
	public void delete(Integer coordenada_id) {
		coordenadaDao.openCurrentSessionwithTransaction();
		Coordenada coordenada = coordenadaDao.findById(coordenada_id);
		coordenadaDao.delete(coordenada);
		coordenadaDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Coordenada> findAll() {
		coordenadaDao.openCurrentSession();
		List<Coordenada> coordenadaes = coordenadaDao.findAll();
		coordenadaDao.closeCurrentSession();
		
		return coordenadaes;
	}
	
	public void deleteAll() {
		coordenadaDao.openCurrentSessionwithTransaction();
		coordenadaDao.deleteAll();
		coordenadaDao.closeCurrentSessionwithTransaction();
	}
	
}

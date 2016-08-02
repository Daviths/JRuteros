package servicios;

import java.util.List;

import dao.implementacion.RutaDao;
import modelos.Ruta;
import utils.JpaUtil;

public class RutaServicio {
	
	private static RutaDao rutaDao;
	
	public RutaServicio() {
		rutaDao = new RutaDao();
	}
	
	public void persist(Ruta ruta) {
		rutaDao.openCurrentSessionwithTransaction();
		rutaDao.persist(ruta);
		rutaDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Ruta ruta) {
		rutaDao.openCurrentSessionwithTransaction();
		rutaDao.update(ruta);
		rutaDao.closeCurrentSessionwithTransaction();
	}
	
	public Ruta findById(Integer ruta_id) {
		rutaDao.openCurrentSession();
		Ruta ruta = rutaDao.findById(ruta_id);
		rutaDao.closeCurrentSession();	
		return ruta;
	}
	
	public void delete(Integer ruta_id) {
		rutaDao.openCurrentSessionwithTransaction();
		Ruta ruta = rutaDao.findById(ruta_id);
		rutaDao.delete(ruta);
		rutaDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Ruta> findAll() {
		rutaDao.openCurrentSession();
		List<Ruta> rutas = rutaDao.findAll();
		rutaDao.closeCurrentSession();
		
		return rutas;
	}
	
	public void deleteAll() {
		rutaDao.openCurrentSessionwithTransaction();
		rutaDao.deleteAll();
		rutaDao.closeCurrentSessionwithTransaction();
	}

}

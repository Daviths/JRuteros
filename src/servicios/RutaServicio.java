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
		JpaUtil.beginTransaction();
		rutaDao.persist(ruta);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public void update(Ruta ruta) {
		JpaUtil.beginTransaction();
		rutaDao.update(ruta);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public Ruta findById(Integer ruta_id) {
		JpaUtil.getSession();
		Ruta ruta = rutaDao.findById(ruta_id);
		JpaUtil.closeSession();
		
		return ruta;
	}
	
	public void delete(Integer ruta_id) {
		JpaUtil.beginTransaction();
		Ruta ruta = rutaDao.findById(ruta_id);
		rutaDao.delete(ruta);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public List<Ruta> findAll() {
		JpaUtil.getSession();
		List<Ruta> rutas = rutaDao.findAll();
		JpaUtil.closeSession();
		
		return rutas;
	}
	
	public void deleteAll() {
		JpaUtil.beginTransaction();
		rutaDao.deleteAll();
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}

}

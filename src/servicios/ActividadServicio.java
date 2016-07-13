package servicios;

import java.util.List;

import dao.implementacion.ActividadDao;
import modelos.Actividad;
import utils.JpaUtil;

public class ActividadServicio {
	
	private static ActividadDao actividadDao;
	
	public ActividadServicio() {
		actividadDao = new ActividadDao();
	}
	
	public void cambiarEstado(Integer actividad_id) {
		JpaUtil.beginTransaction();
		actividadDao.cambiarEstado(actividad_id);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public void persist(Actividad actividad) {
		JpaUtil.beginTransaction();
		actividadDao.persist(actividad);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public void update(Actividad actividad) {
		JpaUtil.beginTransaction();
		actividadDao.update(actividad);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public Actividad findById(Integer actividad_id) {
		JpaUtil.getSession();
		Actividad actividad = actividadDao.findById(actividad_id);
		JpaUtil.closeSession();
		
		return actividad;
	}
	
	public void delete(Integer actividad_id) {
		JpaUtil.beginTransaction();
		Actividad actividad = actividadDao.findById(actividad_id);
		actividadDao.delete(actividad);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public List<Actividad> findAll() {
		JpaUtil.getSession();	
		List<Actividad> actividades = actividadDao.findAll();
		JpaUtil.closeSession();
		
		return actividades;
	}
	
	public void deleteAll() {
		JpaUtil.beginTransaction();
		actividadDao.deleteAll();
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
}

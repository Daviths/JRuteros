package servicios;

import java.util.List;

import dao.implementacion.ActividadDao;
import modelos.Actividad;

public class ActividadServicio {
	
	private static ActividadDao ActividadDAO;
	
	public ActividadServicio() {
		ActividadDAO = new ActividadDao();
	}
	
	public void cambiarEstado(Integer actividad_id) {
		ActividadDAO.openCurrentSessionwithTransaction();
		ActividadDAO.cambiarEstado(actividad_id);
		ActividadDAO.closeCurrentSessionwithTransaction();
	}
	
	public void persist(Actividad actividad) {
		ActividadDAO.openCurrentSessionwithTransaction();
		ActividadDAO.persist(actividad);
		ActividadDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(Actividad actividad) {
		ActividadDAO.openCurrentSessionwithTransaction();
		ActividadDAO.update(actividad);
		ActividadDAO.closeCurrentSessionwithTransaction();		
	}
	
	public Actividad findById(Integer actividad_id) {
		ActividadDAO.openCurrentSession();
		Actividad actividad = ActividadDAO.findById(actividad_id);
		ActividadDAO.closeCurrentSession();		
		return actividad;
	}
	
	public void delete(Integer actividad_id) {
		ActividadDAO.openCurrentSessionwithTransaction();
		Actividad actividad = ActividadDAO.findById(actividad_id);
		ActividadDAO.delete(actividad);
		ActividadDAO.closeCurrentSessionwithTransaction();	
	}
	
	public List<Actividad> findAll() {
		ActividadDAO.openCurrentSessionwithTransaction();
		List<Actividad> actividades = ActividadDAO.findAll();
		ActividadDAO.closeCurrentSessionwithTransaction();		
		return actividades;
	}
	
	public void deleteAll() {
		ActividadDAO.openCurrentSessionwithTransaction();
		ActividadDAO.deleteAll();
		ActividadDAO.closeCurrentSessionwithTransaction();	
	}
	
}

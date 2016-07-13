package dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.ActividadDaoInterfaz;
import modelos.Actividad;
import utils.JpaUtil;

public class ActividadDao implements ActividadDaoInterfaz {
	
	public ActividadDao() {
		
	}
	
	protected EntityManager getEntityManager() {
		return JpaUtil.getSession();
	}
	
	public void cambiarEstado(Integer actividad_id) {
		Actividad actividad = findById(actividad_id);
		Boolean esta_habilitada = !actividad.getEsta_habilitada();
		actividad.setEsta_habilitada(esta_habilitada);
	}
	
	@Override
	public void persist(Actividad actividad) {
		getEntityManager().persist(actividad);		
	}

	@Override
	public void update(Actividad actividad) {
		getEntityManager().merge(actividad);		
	}

	@Override
	public Actividad findById(Integer actividad_id) {
		Actividad actividad = getEntityManager().find(Actividad.class, actividad_id);
		return actividad;
	}

	@Override
	public void delete(Actividad actividad) {
		getEntityManager().remove(actividad);		
	}

	@Override
	public List<Actividad> findAll() {
		String query ="SELECT * FROM actividades";
		@SuppressWarnings("unchecked")
		List<Actividad> actividades = getEntityManager().createQuery(query).getResultList();
		//List<Actividad> actividades = (List<Actividad>) JpaUtil.getSession().createQuery(query).getResultList();		
		
		return actividades;
	}

	@Override
	public void deleteAll() {
		List<Actividad> actividades = findAll();
		for(Actividad actividad: actividades) {
			delete(actividad);
		}		
	}
	
}
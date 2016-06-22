package dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import modelos.Actividad;

public class ActividadDAOImplementacion implements ActividadDAO {
	
	public Integer addNew(Object o, EntityManager em){
		EntityTransaction etx = em.getTransaction();		
	    Integer actividadID = null;
	    Actividad actividad = (Actividad) o;
	    try{
	    	etx.begin();
	    	em.persist(actividad);
	    	etx.commit();
	    }catch (HibernateException e) {
	       e.printStackTrace(); 
	    }finally {	    	
			em.close();
	    }
	    return actividadID;
	}
	
	public List<Actividad> getAll(EntityManager em) {
		EntityTransaction etx = em.getTransaction();
		List<Actividad> listaactividades = new LinkedList<Actividad>();
		try{
			etx.begin();
			Query q = em.createQuery("from actividades");
			List<Actividad> actividades=(List<Actividad>)(q).getResultList();
			for (Iterator<?> iterator = actividades.iterator(); iterator.hasNext();){
				Actividad actividad = (Actividad) iterator.next(); 
				listaactividades.add(actividad);
			}
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}finally {
			em.close();
		}
		return listaactividades;
	}
	
	public Actividad getActividad(Integer ActividadID, EntityManager em) {
		Actividad u = null;
		EntityTransaction etx = em.getTransaction();
	    try{
	    	etx.begin();
	    	u = (Actividad)em.find(Actividad.class, ActividadID); 
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
		return u;
	}
	
	public void edit(Integer ActividadID, String nombre_nuevo, String descripcion, EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	    	etx.begin();
	    	Actividad actividad = (Actividad)em.find(Actividad.class, ActividadID); 
			actividad.setDescripcion(descripcion);
			actividad.setNombre(nombre_nuevo);
			em.merge(actividad); 
			etx.commit();
	    }catch (HibernateException e) {
	      	e.printStackTrace(); 
	    }finally {
	         em.close(); 
	    }
	}
	
	public void cambiarEstado(Integer ActividadID, EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	    	etx.begin();
			Actividad actividad = (Actividad)em.find(Actividad.class, ActividadID); 
			actividad.setEsta_habilitada(!actividad.getEsta_habilitada());
			em.merge(actividad); 
			etx.commit();
	    }catch (HibernateException e) {
	      	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
	}
	
	public void delete(Integer ActividadID, EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	    	etx.begin();
	    	Actividad actividad = (Actividad)em.find(Actividad.class, ActividadID);
	    	em.detach(actividad);	
	    	etx.commit();
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
	}

}
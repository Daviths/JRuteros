package dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelos.Actividad;

public class ActividadDAO {
	
	public static Integer addNew(Actividad actividad, SessionFactory factory){
		Session session = factory.openSession();
	    Transaction tx = null;
	    Integer actividadID = null;
	    try{
	       tx = session.beginTransaction();
	       actividadID = (Integer) session.save(actividad); 
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace(); 
	    }finally {
	       session.close(); 
	    }
	    return actividadID;
	}
	
	public static List<Actividad> getAll(SessionFactory factory) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Actividad> listaactividades = new LinkedList<Actividad>();
		try{
			tx = session.beginTransaction();
			List<?> actividades = session.createQuery("FROM actividades").list(); 
			for (Iterator<?> iterator = actividades.iterator(); iterator.hasNext();){
				Actividad actividad = (Actividad) iterator.next(); 
				listaactividades.add(actividad);
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return listaactividades;
	}
	
	public static Actividad getActividad(Integer ActividadID, SessionFactory factory) {
		Actividad u = null;
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       u = (Actividad)session.get(Actividad.class, ActividadID);
	    }catch (HibernateException e) {
	    if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
		return u;
	}
	
	public static void edit(Integer ActividadID, String nombre_nuevo, String descripcion, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Actividad actividad = (Actividad)session.get(Actividad.class, ActividadID); 
	       actividad.setDescripcion(descripcion);
	       actividad.setNombre(nombre_nuevo);
	       session.update(actividad); 
	       tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	      	e.printStackTrace(); 
	    }finally {
	         session.close(); 
	    }
	}
	
	public static void cambiarEstado(Integer ActividadID, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Actividad actividad = (Actividad)session.get(Actividad.class, ActividadID); 
	       actividad.setEsta_habilitada(!actividad.getEsta_habilitada());
	       session.update(actividad); 
	       tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	      	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	}
	
	public static void delete(Integer ActividadID, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	Actividad actividad = (Actividad)session.get(Actividad.class, ActividadID); 
	    	session.delete(actividad); 
	    	tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	}
}
package dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelos.Ruta;

public class RutaDAO {
	
	public static Integer addNew(Ruta ruta, SessionFactory factory){
		Session session = factory.openSession();
	    Transaction tx = null;
	    Integer rutaID = null;
	    try{
	       tx = session.beginTransaction();
	       rutaID = (Integer) session.save(ruta); 
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace(); 
	    }finally {
	       session.close(); 
	    }
	    return rutaID;
	}
	
	public static List<Ruta> getAll(SessionFactory factory) {
		List<Ruta> rutas = new LinkedList<Ruta>();
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<?> listarutas = session.createQuery("FROM rutas").list(); 
			for (Iterator<?> iterator = listarutas.iterator(); iterator.hasNext();){
				Ruta r = (Ruta) iterator.next(); 
				rutas.add(r);
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return rutas;
	}
	
	public static Ruta getRuta(Integer RutaID, SessionFactory factory) {
		Ruta u = null;
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       u = (Ruta)session.get(Ruta.class, RutaID);
	    }catch (HibernateException e) {
	    if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
		return u;
	}
	
	public static void edit(Integer RutaID, String nombre_nuevo,String descripcion, Boolean es_publica, Boolean es_circular, Float distancia, Float tiempo_estimado, String actividad, String dificultad, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Ruta ruta = (Ruta)session.get(Ruta.class, RutaID); 
	       ruta.setNombre(nombre_nuevo);
	       ruta.setDescripcion(descripcion);
	       ruta.setEs_publica(es_publica);
	       ruta.setEs_circular(es_circular);
	       ruta.setActividad(actividad);
	       ruta.setDificultad(dificultad);
	       ruta.setDistancia(distancia);
	       ruta.setTiempo_estimado(tiempo_estimado);
	       session.update(ruta); 
	       tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	      	e.printStackTrace(); 
	    }finally {
	         session.close(); 
	    }
	}
	
	public static void cambiarEstado(Integer RutaID, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Ruta ruta = (Ruta)session.get(Ruta.class, RutaID); 
	       ruta.setEs_publica(!ruta.getEs_publica());
	       session.update(ruta); 
	       tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	      	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	}
	
	public static void delete(Integer RutaID, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	Ruta ruta = (Ruta)session.get(Ruta.class, RutaID); 
	    	session.delete(ruta); 
	    	tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	}
}

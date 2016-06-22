package dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import modelos.Ruta;

public class RutaDAOImplementacion implements RutaDAO {
	
	public Integer addNew(Object o, EntityManager em){
		Ruta ruta = (Ruta) o;
		EntityTransaction etx = em.getTransaction();
	    Integer rutaID = null;
	    try{
	    	etx.begin();
	    	em.persist(ruta);
	    	etx.commit();
	    }catch (HibernateException e) {
	       e.printStackTrace(); 
	    }finally {
	       em.close(); 
	    }
	    return rutaID;
	}
	
	public List<Ruta> getAll(EntityManager em) {
		List<Ruta> rutas = new LinkedList<Ruta>();
		EntityTransaction etx = em.getTransaction();
		try{
			etx.begin();
			Query q = em.createQuery("from rutas");
			List<Ruta> listarutas=(List<Ruta>)(q).getResultList();
			for (Iterator<?> iterator = listarutas.iterator(); iterator.hasNext();){
				Ruta r = (Ruta) iterator.next(); 
				rutas.add(r);
			}
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}finally {
			em.close(); 
		}
		return rutas;
	}
	
	public Ruta getRuta(Integer RutaID, EntityManager em) {
		Ruta u = null;
		EntityTransaction etx = em.getTransaction();
	    try{
	    	etx.begin();
	    	u = (Ruta)em.find(Ruta.class, RutaID); 
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
		return u;
	}
	
	public void edit(Integer RutaID, String nombre_nuevo,String descripcion, Boolean es_publica, Boolean es_circular, Float distancia, Float tiempo_estimado, String actividad, String dificultad, EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	       etx.begin();
	       Ruta ruta = (Ruta)em.find(Ruta.class, RutaID); 
	       ruta.setNombre(nombre_nuevo);
	       ruta.setDescripcion(descripcion);
	       ruta.setEs_publica(es_publica);
	       ruta.setEs_circular(es_circular);
	       ruta.setActividad(actividad);
	       ruta.setDificultad(dificultad);
	       ruta.setDistancia(distancia);
	       ruta.setTiempo_estimado(tiempo_estimado);
	       em.merge(ruta); 
	       etx.commit();
	    }catch (HibernateException e) {
	      	e.printStackTrace(); 
	    }finally {
	         em.close(); 
	    }
	}
	
	public void cambiarEstado(Integer RutaID, EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	       etx.begin();
	       Ruta ruta = (Ruta)em.find(Ruta.class, RutaID); 
	       ruta.setEs_publica(!ruta.getEs_publica());
	       em.merge(ruta); 
	       etx.commit();
	    }catch (HibernateException e) {
	      	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
	}
	
	public void delete(Integer RutaID, EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	    	etx.begin();
	    	Ruta ruta = (Ruta)em.find(Ruta.class, RutaID); 
	    	em.detach(ruta); 
	    	etx.commit();
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
	}
}

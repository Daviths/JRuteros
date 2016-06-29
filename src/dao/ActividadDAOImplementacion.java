package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.Actividad;

public class ActividadDAOImplementacion implements ActividadDAO {
	
	private SessionFactory factory;	
	private Session session;
	
	private void prepararTransaccion() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Actividad.class)
				.buildSessionFactory();

		session = factory.getCurrentSession();
	}
	
	public void addNew(Actividad actividad) {		
		prepararTransaccion();
		
		try {
			session.beginTransaction();
			session.save(actividad);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Actividad> getAll() {		
		prepararTransaccion();
		
		List<Actividad> actividades = new LinkedList<>();
		
		try {
			session.beginTransaction();	
			
			actividades = session.createQuery("from Actividad").list();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return actividades;
	}
	
	public Actividad getActividad(Integer id) {			
		prepararTransaccion();			
		Actividad actividad;		
		
	    try {
	    	session.beginTransaction();	    	
	    	actividad = session.get(Actividad.class, id);
	    	session.getTransaction().commit();	    	
	    } finally {
	    	factory.close(); 
	    }
	    
		return actividad;
	}
	
	public void edit(Integer id, String nombre, String descripcion) {
		Actividad actividad = getActividad(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();		    	
	    	actividad.setNombre(nombre);
	    	actividad.setDescripcion(descripcion);
	    	session.update(actividad);
	    	session.getTransaction().commit();
	    } finally {
	         factory.close(); 
	    }
	}
	
	public void cambiarEstado(Integer id) {
		Actividad actividad = getActividad(id);
		Boolean esta_habilitada = !actividad.getEsta_habilitada();
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	actividad.setEsta_habilitada(esta_habilitada);
	    	session.update(actividad);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
	}
	
	public void delete(int id) {
		Actividad actividad = getActividad(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	//Actividad actividad = session.get(Actividad.class, id);	    	
	    	session.delete(actividad);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
	}
	
	public Actividad findByName(String nombre) {
		List<Actividad> actividades = getAll();
		
		for(Actividad actividad: actividades) {
			if(actividad.getNombre().equals(nombre)) {
				return actividad;
			}
		}
		
		return null;
	}	
}
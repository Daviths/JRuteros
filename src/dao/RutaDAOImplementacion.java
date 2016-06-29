package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.Ruta;

public class RutaDAOImplementacion implements RutaDAO {

	private SessionFactory factory;	
	private Session session;
	
	private void prepararTransaccion() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		session = factory.getCurrentSession();
	}

	public void addNew(Ruta ruta) {
		prepararTransaccion();

		try {
			session.beginTransaction();
			session.save(ruta);
			session.getTransaction().commit();	 			
		} finally {
			factory.close();
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Ruta> getAll() {		
		prepararTransaccion();
		
		List<Ruta> rutas = new LinkedList<>();
		
		try {
			session.beginTransaction();	
			
			rutas = session.createQuery("from Ruta").list();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return rutas;
	}

	public Ruta getRuta(Integer id) {			
		prepararTransaccion();			
		Ruta ruta;
		
	    try {
	    	session.beginTransaction();	    	
	    	ruta = session.get(Ruta.class, id);
	    	session.getTransaction().commit();	    	
	    } finally {
	    	factory.close(); 
	    }
	    
		return ruta;
	}

	public void edit(Integer id, String nombre, String descripcion, String fecha_de_realizacion, String dificultad,
			Boolean es_publica, Boolean es_circular, Double distancia, Double tiempo_estimado) {

		Ruta ruta = getRuta(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();		

		    ruta.setNombre(nombre);
		    ruta.setDescripcion(descripcion);
	    	ruta.setEs_publica(es_publica);
	        ruta.setEs_circular(es_circular);
	        ruta.setDificultad(dificultad);
	        ruta.setDistancia(distancia);
	        ruta.setTiempo_estimado(tiempo_estimado);

    	    session.update(ruta);
	    	session.getTransaction().commit();
	    } finally {
	         factory.close(); 
	    }
	}

	public void cambiarEstado(Integer id) {
		Ruta ruta = getRuta(id);
		Boolean es_publica = !ruta.getEs_publica();

		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	
	    	ruta.setEs_publica(es_publica);

	    	session.update(ruta);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
	}

	public void delete(Integer id) {
		Ruta ruta = getRuta(id);
		prepararTransaccion();
				
	    try {
	    	session.beginTransaction();	    	
	    	session.delete(ruta);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
	}
	
	public Ruta findByName(String nombre) {
		List<Ruta> rutas = getAll();
		
		for(Ruta ruta: rutas) {
			if(ruta.getNombre().equals(nombre)) {
				return ruta;
			}
		}
		
		return null;
	}	
}

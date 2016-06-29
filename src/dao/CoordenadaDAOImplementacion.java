package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.Coordenada;

public class CoordenadaDAOImplementacion implements CoordenadaDAO {
	private SessionFactory factory;	
	private Session session;

	private void prepararTransaccion() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		session = factory.getCurrentSession();
	}
	
	@Override
	public void addNew(Coordenada coordenada) {
		prepararTransaccion();
		
		try {
			session.beginTransaction();
			session.save(coordenada);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	@Override
	public Coordenada getCoordenada(Integer id) {			
		prepararTransaccion();			
		Coordenada coordenada;		
		
	    try {
	    	session.beginTransaction();	    	
	    	coordenada = session.get(Coordenada.class, id);
	    	session.getTransaction().commit();	    	
	    } finally {
	    	factory.close(); 
	    }
	    
		return coordenada;
	}

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Coordenada> getAll() {		
		prepararTransaccion();
		
		List<Coordenada> coordenadas = new LinkedList<>();
		
		try {
			session.beginTransaction();	
			
			coordenadas = session.createQuery("from Coordenada").list();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return coordenadas;
	}
	
	@Override
	public void edit(Integer id, Double x, Double y) {
		Coordenada coordenada = getCoordenada(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();		 
	    	
	    	coordenada.setX(x);
	    	coordenada.setY(y);
	    	
	    	session.update(coordenada);
	    	session.getTransaction().commit();
	    } finally {
	         factory.close(); 
	    }
		
	}
	
	@Override
	public void delete(Integer id) {
		Coordenada coordenada = getCoordenada(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	//Coordenada coordenada = session.get(Coordenada.class, id);	    	
	    	session.delete(coordenada);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
		
	}
	
}

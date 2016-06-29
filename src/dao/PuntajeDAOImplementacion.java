package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.Puntaje;
import modelos.Ruta;
import modelos.Usuario;

public class PuntajeDAOImplementacion implements PuntajeDAO {

	private SessionFactory factory;	
	private Session session;

	private void prepararTransaccion() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		session = factory.getCurrentSession();
	}

	@Override
	public void addNew(Puntaje puntaje) {
		prepararTransaccion();

		try {
			session.beginTransaction();
			session.save(puntaje);
			session.getTransaction().commit();	 			
		} finally {
			factory.close();
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Puntaje> getAll() {
		prepararTransaccion();
		
		List<Puntaje> puntajes = new LinkedList<>();
		
		try {
			session.beginTransaction();	
			
			puntajes = session.createQuery("from Puntaje").list();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return puntajes;
	}

	@Override
	public Puntaje getPuntaje(Usuario usuario, Ruta ruta) {
		prepararTransaccion();			
	    List<Puntaje> puntajes = getAll();
	    
	    for(Puntaje p:puntajes){
	    	if((p.getRuta().getId()==ruta.getId()) && (p.getUsuario().getId()==usuario.getId())){
	    		return p;
	    	}
	    }
	    
		return null;
	}
	
	public Puntaje getPuntajePorId(Integer id) {
		prepararTransaccion();			
		Puntaje puntaje;
		
	    try {
	    	session.beginTransaction();	    	
	    	puntaje = session.get(Puntaje.class, id);
	    	session.getTransaction().commit();	    	
	    } finally {
	    	factory.close(); 
	    }
	    
		return puntaje;
	}

	@Override
	public void edit(Integer id, Integer puntos, String fecha) {
		Puntaje puntaje = getPuntajePorId(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();		

		  	puntaje.setPuntos(puntos);
		  	puntaje.setFecha(fecha);

    	    session.update(puntaje);
	    	session.getTransaction().commit();
	    } finally {
	         factory.close(); 
	    }
	}

	@Override
	public void delete(Integer id) {
		Puntaje puntaje = getPuntajePorId(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	session.delete(puntaje);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
	}

}

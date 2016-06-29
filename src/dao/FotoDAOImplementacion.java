package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.Foto;

public class FotoDAOImplementacion implements FotoDAO {

	private SessionFactory factory;	
	private Session session;

	private void prepararTransaccion() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Foto.class)
				.buildSessionFactory();

		session = factory.getCurrentSession();
	}

	@Override
	public void addNew(Foto foto) {
		prepararTransaccion();
			
		try {
			session.beginTransaction();
			session.save(foto);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Foto> getAll() {
		prepararTransaccion();
			
		List<Foto> fotos = new LinkedList<>();
		
		try {
			session.beginTransaction();	
			
			fotos = session.createQuery("from Foto").list();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return fotos;
	}

	
	public void edit(Integer id, String nombre, String tipo, String contenido) {
		Foto foto = getFoto(id);
			
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();		

	    	foto.setNombre(nombre);
	    	foto.setTipo(tipo);
	    	foto.setContenido(contenido);

	    	session.update(foto);
	    	session.getTransaction().commit();
	    } finally {
	         factory.close(); 
	    }
	}

	@Override
	public void delete(int id) {
		Foto foto = getFoto(id);
			
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	//Foto foto = session.get(Foto.class, id);	    	
	    	session.delete(foto);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
	}

	@Override
	public Foto findByName(String nombre) {
		List<Foto> fotos = getAll();
			
		for(Foto foto: fotos) {
			if(foto.getNombre().equals(nombre)) {
				return foto;
			}
		}
		
		return null;
	}

	@Override
	public Foto getFoto(Integer id) {			
		prepararTransaccion();			
		Foto foto;		
		
	    try {
	    	session.beginTransaction();	    	
	    	foto = session.get(Foto.class, id);
	    	session.getTransaction().commit();	    	
	    } finally {
	    	factory.close(); 
	    }
	    
		return foto;
	}

}

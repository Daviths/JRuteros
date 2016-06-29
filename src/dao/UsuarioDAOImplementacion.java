package dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.Usuario;

public class UsuarioDAOImplementacion implements UsuarioDAO {	
	
	private SessionFactory factory;	
	private Session session;

	private void prepararTransaccion() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		session = factory.getCurrentSession();
	}

	@Override
	public void addNew(Usuario usuario) {
		prepararTransaccion();
		
		try {
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Usuario> getAll() {		
		prepararTransaccion();
		
		List<Usuario> usuarios = new LinkedList<>();
		
		try {
			session.beginTransaction();	
			
			usuarios = session.createQuery("from Usuario").list();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return usuarios;
	}

	public Usuario getUsuario(Integer id) {			
		prepararTransaccion();			
		Usuario usuario;		
		
	    try {
	    	session.beginTransaction();	    	
	    	usuario = session.get(Usuario.class, id);
	    	session.getTransaction().commit();	    	
	    } finally {
	    	factory.close(); 
	    }
	    
		return usuario;
	}

	@Override
	public void edit(Integer id, String dni, String domicilio, String nombre, String apellido, String sexo,
			String email) {
		Usuario usuario = getUsuario(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();		 
	    	
	    	usuario.setDni(dni);
	    	usuario.setDomicilio(domicilio);	    	
	    	usuario.setNombre(nombre);
	    	usuario.setApellido(apellido);
	    	usuario.setSexo(sexo);
	    	usuario.setEmail(email);
	    	
	    	session.update(usuario);
	    	session.getTransaction().commit();
	    } finally {
	         factory.close(); 
	    }
		
	}

	@Override
	public void cambiarEstado(Integer id) {
		Usuario usuario = getUsuario(id);
		Boolean esta_habilitado = !usuario.getEsta_habilitado();
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	usuario.setEsta_habilitado(esta_habilitado);
	    	session.update(usuario);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
	}

	@Override
	public void delete(Integer id) {
		Usuario usuario = getUsuario(id);
		
		prepararTransaccion();
		
	    try {
	    	session.beginTransaction();	    	
	    	//Usuario usuario = session.get(Usuario.class, id);	    	
	    	session.delete(usuario);
	    	session.getTransaction().commit();
	    } finally {
	    	factory.close(); 
	    }
		
	}

	 @Override
	 public Usuario findByName(String usuario_nombre) {
		List<Usuario> usuarios = getAll();
		
		for(Usuario usuario: usuarios) {
			if(usuario.getUsuario().equals(usuario_nombre)) {
				return usuario;
			}
		}
		
		return null;
	}	
}

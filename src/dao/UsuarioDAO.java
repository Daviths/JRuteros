package dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import modelos.Usuario;

public class UsuarioDAO implements DAO {	
	
	public Integer addNew(Object o ,  EntityManager em) {
		Usuario usuario = (Usuario) o;
		EntityTransaction etx = em.getTransaction();
	    Integer usuarioID = null;
	    try{
	      etx.begin();
		   em.persist(usuario); 
	       etx.commit();
	    }catch (HibernateException e) {
	       e.printStackTrace(); 
	    }finally {
	       em.close(); 
	    }
	    return usuarioID;
	}
	
	public List<Usuario> getAll( EntityManager em) {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		EntityTransaction etx = em.getTransaction();
		try{
			etx.begin();
			Query q = em.createQuery("from usuarios");
			List<Usuario> listausuarios =(List<Usuario>)(q).getResultList();
			for (Iterator<Usuario> iterator = listausuarios.iterator(); iterator.hasNext();){
				Usuario u = (Usuario) iterator.next(); 
				usuarios.add(u);
			}
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}finally {
			em.close(); 
		}
		return usuarios;
	}
	
	public Usuario getUsuario(Integer UsuarioID,  EntityManager em) {
		Usuario u = null;
		EntityTransaction etx = em.getTransaction();
	    try{
	       etx.begin();
	       u = (Usuario)em.find(Usuario.class, UsuarioID);
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
		return u;
	}
	
	public void edit(Integer UsuarioID, String dni, String domicilio, String nombre, String apellido, String sexo, String email,  EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	      etx.begin();
	       Usuario usuario = (Usuario)em.find(Usuario.class, UsuarioID); 
	       usuario.setApellido(apellido);
	       usuario.setDni(dni);
	       usuario.setDomicilio(domicilio);
	       usuario.setEmail(email);
	       usuario.setNombre(nombre);
	       usuario.setSexo(sexo);
	       em.merge(usuario); 
	       etx.commit();
	    }catch (HibernateException e) {
	      	e.printStackTrace(); 
	    }finally {
	         em.close(); 
	    }
	}
	
	public void cambiarEstado(Integer UsuarioID,  EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	      etx.begin();
	       Usuario usuario = (Usuario)em.find(Usuario.class, UsuarioID); 
	       usuario.setEsta_habilitado(!usuario.getEsta_habilitado());
	       em.merge(usuario); 
	       etx.commit();
	    }catch (HibernateException e) {
	      	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
	}
	
	public void delete(Integer UsuarioID,  EntityManager em) {
		EntityTransaction etx = em.getTransaction();
	    try{
	    	etx.begin();
	    	Usuario usuario = (Usuario)em.find(Usuario.class, UsuarioID); 
	    	em.detach(usuario); 
	    	etx.commit();
	    }catch (HibernateException e) {
	    	e.printStackTrace(); 
	    }finally {
	    	em.close(); 
	    }
	}
}

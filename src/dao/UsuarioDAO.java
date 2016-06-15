package dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.sun.istack.internal.logging.Logger;

import db.DBUtils;
import modelos.Ruta;
import modelos.Usuario;

public class UsuarioDAO {	
	public static Integer addNew(Usuario usuario, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    Integer usuarioID = null;
	    try{
	       tx = session.beginTransaction();
		   usuarioID = (Integer) session.save(usuario); 
	       tx.commit();
	    }catch (HibernateException e) {
	       if (tx!=null) tx.rollback();
	       e.printStackTrace(); 
	    }finally {
	       session.close(); 
	    }
	    return usuarioID;
	}
	
	public static List<Usuario> getAll(SessionFactory factory) {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<?> listausuarios = session.createQuery("FROM usuarios").list(); 
			for (Iterator<?> iterator = listausuarios.iterator(); iterator.hasNext();){
				Usuario u = (Usuario) iterator.next(); 
				usuarios.add(u);
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return usuarios;
	}
	
	public static Usuario getUsuario(Integer UsuarioID, SessionFactory factory) {
		Usuario u = null;
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       u = (Usuario)session.get(Usuario.class, UsuarioID);
	    }catch (HibernateException e) {
	    if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
		return u;
	}
	
	public void edit(Integer UsuarioID, String dni, String domicilio, String nombre, String apellido, String sexo, String email, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Usuario usuario = (Usuario)session.get(Usuario.class, UsuarioID); 
	       usuario.setApellido(apellido);
	       usuario.setDni(dni);
	       usuario.setDomicilio(domicilio);
	       usuario.setEmail(email);
	       usuario.setNombre(nombre);
	       usuario.setSexo(sexo);
	       session.update(usuario); 
	       tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	      	e.printStackTrace(); 
	    }finally {
	         session.close(); 
	    }
	}
	
	public static void cambiarEstado(Integer UsuarioID, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	       tx = session.beginTransaction();
	       Usuario usuario = (Usuario)session.get(Usuario.class, UsuarioID); 
	       usuario.setEsta_habilitado(!usuario.getEsta_habilitado());
	       session.update(usuario); 
	       tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	      	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	}
	
	public void delete(Integer UsuarioID, SessionFactory factory) {
		Session session = factory.openSession();
	    Transaction tx = null;
	    try{
	    	tx = session.beginTransaction();
	    	Usuario usuario = (Usuario)session.get(Usuario.class, UsuarioID); 
	    	session.delete(usuario); 
	    	tx.commit();
	    }catch (HibernateException e) {
	    	if (tx!=null) tx.rollback();
	    	e.printStackTrace(); 
	    }finally {
	    	session.close(); 
	    }
	}
}

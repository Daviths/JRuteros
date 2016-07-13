package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManager em;
	
	static {
		try{
			em = Persistence.createEntityManagerFactory("persistence-unit").createEntityManager();
		}
		catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static EntityManager getSession() {
		return em;
	}
	
	public static void beginTransaction(){
		EntityTransaction etx = em.getTransaction();
		etx.begin();
	}
	
	public static void commitTransaction(){
		getSession().getTransaction().commit();
	}
	
	public static void closeSession() {
		getSession().close();
	}
}

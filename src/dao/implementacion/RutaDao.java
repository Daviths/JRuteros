package dao.implementacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import dao.interfaces.RutaDaoInterfaz;
import modelos.Ruta;

public class RutaDao implements RutaDaoInterfaz {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public RutaDao() {
		
	}
	
	
	public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
	
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Ruta.class);
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	@Override
	public void persist(Ruta ruta) {
		getCurrentSession().save(ruta);
	}

	@Override
	public void update(Ruta ruta) {
		getCurrentSession().update(ruta);		
	}

	@Override
	public Ruta findById(Integer ruta_id) {
		Ruta ruta = (Ruta) getCurrentSession().get(Ruta.class, ruta_id);
		return ruta;
	}

	@Override
	public void delete(Ruta ruta) {
		getCurrentSession().delete(ruta);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruta> findAll() {
		/*String query ="SELECT * FROM rutas";		
		List<Ruta> rutas = getEntityManager().createQuery(query).getResultList();		
		return rutas;*/		
		List<Ruta> rutas = (List<Ruta>) getCurrentSession().createQuery("from Ruta").list();
		return rutas;
	}

	@Override
	public void deleteAll() {
		List<Ruta> rutas = findAll();
		for(Ruta ruta: rutas) {
			delete(ruta);
		}		
	}
	
}
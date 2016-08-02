package dao.implementacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import dao.interfaces.CoordenadaDaoInterfaz;
import modelos.Coordenada;

public class CoordenadaDao implements CoordenadaDaoInterfaz {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public CoordenadaDao() {
		
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
		configuration.addAnnotatedClass(Coordenada.class);
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
	public void persist(Coordenada coordenada) {
		getCurrentSession().save(coordenada);
	}

	@Override
	public void update(Coordenada coordenada) {
		getCurrentSession().update(coordenada);		
	}

	@Override
	public Coordenada findById(Integer coordenada_id) {
		Coordenada coordenada = (Coordenada) getCurrentSession().get(Coordenada.class, coordenada_id);
		return coordenada;
	}

	@Override
	public void delete(Coordenada coordenada) {
		getCurrentSession().delete(coordenada);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Coordenada> findAll() {
		/*String query ="SELECT * FROM coordenadaes";		
		List<Coordenada> coordenadaes = getEntityManager().createQuery(query).getResultList();		
		return coordenadaes;*/		
		List<Coordenada> coordenadaes = (List<Coordenada>) getCurrentSession().createQuery("from Coordenada").list();
		return coordenadaes;
	}

	@Override
	public void deleteAll() {
		List<Coordenada> coordenadaes = findAll();
		for(Coordenada coordenada: coordenadaes) {
			delete(coordenada);
		}		
	}
	
}
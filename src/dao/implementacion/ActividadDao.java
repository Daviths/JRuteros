package dao.implementacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import dao.interfaces.ActividadDaoInterfaz;
import modelos.Actividad;

public class ActividadDao implements ActividadDaoInterfaz {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public ActividadDao() {
		
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
		configuration.addAnnotatedClass(Actividad.class);
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
	
	
	
	public void cambiarEstado(Integer actividad_id) {
		Actividad actividad = findById(actividad_id);
		Boolean esta_habilitada = !actividad.getEsta_habilitada();
		actividad.setEsta_habilitada(esta_habilitada);
	}
	
	@Override
	public void persist(Actividad actividad) {
		getCurrentSession().save(actividad);
	}

	@Override
	public void update(Actividad actividad) {
		getCurrentSession().update(actividad);		
	}

	@Override
	public Actividad findById(Integer actividad_id) {
		Actividad actividad = (Actividad) getCurrentSession().get(Actividad.class, actividad_id);
		return actividad;
	}

	@Override
	public void delete(Actividad actividad) {
		getCurrentSession().delete(actividad);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividad> findAll() {
		/*String query ="SELECT * FROM actividades";		
		List<Actividad> actividades = getEntityManager().createQuery(query).getResultList();		
		return actividades;*/		
		List<Actividad> actividades = (List<Actividad>) getCurrentSession().createQuery("from Actividad").list();
		return actividades;
	}

	@Override
	public void deleteAll() {
		List<Actividad> actividades = findAll();
		for(Actividad actividad: actividades) {
			delete(actividad);
		}		
	}
	
}
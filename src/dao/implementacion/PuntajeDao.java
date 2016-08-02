package dao.implementacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import dao.interfaces.PuntajeDaoInterfaz;
import modelos.Actividad;
import modelos.Coordenada;
import modelos.Puntaje;
import modelos.Foto;
import modelos.Ruta;
import modelos.Usuario;

public class PuntajeDao implements PuntajeDaoInterfaz {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public PuntajeDao() {
		
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
		configuration.addAnnotatedClass(Puntaje.class);
		configuration.addAnnotatedClass(Usuario.class);
		configuration.addAnnotatedClass(Ruta.class);
		configuration.addAnnotatedClass(Actividad.class);
		configuration.addAnnotatedClass(Coordenada.class);
		configuration.addAnnotatedClass(Foto.class);
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
	public void persist(Puntaje puntaje) {
		getCurrentSession().save(puntaje);
	}

	@Override
	public void update(Puntaje puntaje) {
		getCurrentSession().update(puntaje);		
	}

	@Override
	public Puntaje findById(Integer puntaje_id) {
		//Puntaje puntaje = (Puntaje) getCurrentSession().get(Puntaje.class, puntaje_id);
		Puntaje puntaje = null;
		for (Puntaje p: findAll()){
			if(p.getId() == puntaje_id){
				puntaje = p;
			}
		}
		return puntaje;
	}

	@Override
	public void delete(Puntaje puntaje) {
		getCurrentSession().delete(puntaje);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Puntaje> findAll() {
		/*String query ="SELECT * FROM puntajees";		
		List<Puntaje> puntajees = getEntityManager().createQuery(query).getResultList();		
		return puntajees;*/		
		List<Puntaje> puntajes = (List<Puntaje>) getCurrentSession().createQuery("from Puntaje").list();
		return puntajes;
	}

	@Override
	public void deleteAll() {
		List<Puntaje> puntajes = findAll();
		for(Puntaje puntaje: puntajes) {
			delete(puntaje);
		}		
	}
	
}
package dao.implementacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import dao.interfaces.FotoDaoInterfaz;
import modelos.Actividad;
import modelos.Coordenada;
import modelos.Foto;
import modelos.Ruta;
import modelos.Usuario;

public class FotoDao implements FotoDaoInterfaz {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public FotoDao() {
		
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
	public void persist(Foto foto) {
		getCurrentSession().save(foto);
	}

	@Override
	public void update(Foto foto) {
		getCurrentSession().update(foto);		
	}

	@Override
	public Foto findById(Integer foto_id) {
		Foto foto = (Foto) getCurrentSession().get(Foto.class, foto_id);
		return foto;
	}

	@Override
	public void delete(Foto foto) {
		getCurrentSession().delete(foto);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> findAll() {
		/*String query ="SELECT * FROM fotos";		
		List<Foto> fotos = getEntityManager().createQuery(query).getResultList();		
		return fotos;*/		
		List<Foto> fotos = (List<Foto>) getCurrentSession().createQuery("from Foto").list();
		return fotos;
	}

	@Override
	public void deleteAll() {
		List<Foto> fotos = findAll();
		for(Foto foto: fotos) {
			delete(foto);
		}		
	}
	
}
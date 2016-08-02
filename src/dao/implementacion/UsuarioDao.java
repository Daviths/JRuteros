package dao.implementacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import dao.interfaces.UsuarioDaoInterfaz;
import modelos.Actividad;
import modelos.Coordenada;
import modelos.Foto;
import modelos.Ruta;
import modelos.Usuario;

public class UsuarioDao implements UsuarioDaoInterfaz {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public UsuarioDao() {
		
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
	
	
	
	public void cambiarEstado(Integer usuario_id) {
		Usuario usuario = findById(usuario_id);
		Boolean esta_habilitada = !usuario.getEsta_habilitado();
		usuario.setEsta_habilitado(esta_habilitada);
	}
	
	@Override
	public void persist(Usuario usuario) {
		getCurrentSession().save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		getCurrentSession().update(usuario);		
	}

	@Override
	public Usuario findById(Integer usuario_id) {
		Usuario usuario = (Usuario) getCurrentSession().get(Usuario.class, usuario_id);
		return usuario;
	}

	@Override
	public void delete(Usuario usuario) {
		getCurrentSession().delete(usuario);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		/*String query ="SELECT * FROM usuarios";		
		List<Usuario> usuarios = getEntityManager().createQuery(query).getResultList();		
		return usuarios;*/		
		List<Usuario> usuarios = (List<Usuario>) getCurrentSession().createQuery("from Usuario").list();
		return usuarios;
	}

	@Override
	public void deleteAll() {
		List<Usuario> usuarios = findAll();
		for(Usuario usuario: usuarios) {
			delete(usuario);
		}		
	}
	
}
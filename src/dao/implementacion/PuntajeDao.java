package dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.PuntajeDaoInterfaz;
import modelos.Puntaje;
import utils.JpaUtil;

public class PuntajeDao implements PuntajeDaoInterfaz {

	protected EntityManager getEntityManager() {
		return JpaUtil.getSession();
	}

	@Override
	public void persist(Puntaje puntaje) {
		getEntityManager().persist(puntaje);
	}

	@Override
	public void update(Puntaje puntaje) {
		getEntityManager().merge(puntaje);
	}

	@Override
	public Puntaje findById(Integer puntaje_id) {
		Puntaje puntaje = getEntityManager().find(Puntaje.class, puntaje_id);
		return puntaje;
	}

	@Override
	public void delete(Puntaje puntaje) {
		getEntityManager().merge(puntaje);
		getEntityManager().remove(puntaje);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Puntaje> findAll() {
		String query = "FROM puntajes";
		List<Puntaje> puntajes = getEntityManager().createQuery(query).getResultList();
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

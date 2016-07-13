package dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.CoordenadaDaoInterfaz;
import modelos.Coordenada;
import utils.JpaUtil;

public class CoordenadaDao implements CoordenadaDaoInterfaz {

	protected EntityManager getEntityManager() {
		return JpaUtil.getSession();
	}

	@Override
	public void persist(Coordenada coordenada) {
		getEntityManager().persist(coordenada);		
	}

	@Override
	public void update(Coordenada coordenada) {
		getEntityManager().merge(coordenada);
	}

	@Override
	public Coordenada findById(Integer coordenada_id) {
		Coordenada coordenada = getEntityManager().find(Coordenada.class, coordenada_id);
		return coordenada;
	}

	@Override
	public void delete(Coordenada coordenada) {
		getEntityManager().merge(coordenada);
		getEntityManager().remove(coordenada);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Coordenada> findAll() {
		String query = "FROM coordenadas";
		List<Coordenada> coordenadas = getEntityManager().createQuery(query).getResultList();
		return coordenadas;
	}

	@Override
	public void deleteAll() {
		List<Coordenada> coordenadas = findAll();
		for(Coordenada coordenada: coordenadas) {
			delete(coordenada);
		}
	}	
	
}

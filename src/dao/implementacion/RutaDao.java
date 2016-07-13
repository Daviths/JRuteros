package dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.RutaDaoInterfaz;
import modelos.Ruta;
import utils.JpaUtil;

public class RutaDao implements RutaDaoInterfaz {

	protected EntityManager getEntityManager() {
		return JpaUtil.getSession();
	}
	
	/* Pasarlo a metodo de clase
	 
	public void cambiarEstado(Integer id) {
		
	}
*/

	@Override
	public void persist(Ruta ruta) {
		getEntityManager().persist(ruta);
	}

	@Override
	public void update(Ruta ruta) {
		getEntityManager().merge(ruta);
	}

	@Override
	public Ruta findById(Integer ruta_id) {
		Ruta ruta = getEntityManager().find(Ruta.class, ruta_id);
		return ruta;
	}

	@Override
	public void delete(Ruta ruta) {
		getEntityManager().merge(ruta);
		getEntityManager().remove(ruta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ruta> findAll() {
		String query = "FROM rutas";
		List<Ruta> rutas = getEntityManager().createQuery(query).getResultList();
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

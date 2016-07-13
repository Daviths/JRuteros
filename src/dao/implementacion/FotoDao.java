package dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.FotoDaoInterfaz;
import modelos.Foto;
import utils.JpaUtil;

public class FotoDao implements FotoDaoInterfaz {

	protected EntityManager getEntityManager() {
		return JpaUtil.getSession();
	}

	@Override
	public void persist(Foto foto) {
		getEntityManager().persist(foto);		
	}

	@Override
	public void update(Foto foto) {
		getEntityManager().merge(foto);
	}

	@Override
	public Foto findById(Integer foto_id) {
		Foto foto = getEntityManager().find(Foto.class, foto_id);
		return foto;
	}

	@Override
	public void delete(Foto foto) {
		getEntityManager().merge(foto);
		getEntityManager().remove(foto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foto> findAll() {
		String query = "FROM fotos";
		List<Foto> fotos = getEntityManager().createQuery(query).getResultList();
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

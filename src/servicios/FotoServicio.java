package servicios;

import java.util.List;

import dao.implementacion.FotoDao;
import modelos.Foto;
import utils.JpaUtil;

public class FotoServicio {

	private static FotoDao fotoDao;
	
	public FotoServicio() {
		fotoDao = new FotoDao();
	}
	
	public void persist(Foto foto) {
		JpaUtil.beginTransaction();
		fotoDao.persist(foto);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public void update(Foto foto) {
		JpaUtil.beginTransaction();
		fotoDao.update(foto);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public Foto findById(Integer foto_id) {
		JpaUtil.getSession();
		Foto foto = fotoDao.findById(foto_id);
		JpaUtil.closeSession();
		
		return foto;
	}
	
	public void delete(Integer foto_id) {
		JpaUtil.beginTransaction();
		Foto foto = fotoDao.findById(foto_id);
		fotoDao.delete(foto);
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
	public List<Foto> findAll() {
		JpaUtil.getSession();
		List<Foto> fotos = fotoDao.findAll();
		JpaUtil.closeSession();
		
		return fotos;
	}
	
	public void deleteAll() {
		JpaUtil.beginTransaction();
		fotoDao.deleteAll();
		JpaUtil.commitTransaction();
		JpaUtil.closeSession();
	}
	
}


	
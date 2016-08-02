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
		fotoDao.openCurrentSessionwithTransaction();
		fotoDao.persist(foto);
		fotoDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Foto foto) {
		fotoDao.openCurrentSessionwithTransaction();
		fotoDao.update(foto);
		fotoDao.closeCurrentSessionwithTransaction();
	}
	
	public Foto findById(Integer foto_id) {
		fotoDao.openCurrentSession();
		Foto foto = fotoDao.findById(foto_id);
		fotoDao.closeCurrentSession();
		
		return foto;
	}
	
	public void delete(Integer foto_id) {
		fotoDao.openCurrentSessionwithTransaction();
		Foto foto = fotoDao.findById(foto_id);
		fotoDao.delete(foto);
		fotoDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Foto> findAll() {
		fotoDao.openCurrentSession();
		List<Foto> fotos = fotoDao.findAll();
		fotoDao.closeCurrentSession();
		
		return fotos;
	}
	
	public void deleteAll() {
		fotoDao.openCurrentSessionwithTransaction();
		fotoDao.deleteAll();
		fotoDao.closeCurrentSessionwithTransaction();
	}
	
}


	
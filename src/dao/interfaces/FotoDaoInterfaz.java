package dao.interfaces;

import java.util.List;

import modelos.Foto;

public interface FotoDaoInterfaz {
	
	void persist(Foto foto);
	void update(Foto foto);
	Foto findById(Integer foto_id);
	void delete(Foto foto);
	List<Foto> findAll();
	void deleteAll();
	
}
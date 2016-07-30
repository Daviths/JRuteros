package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.implementacion.PuntoDao;
import modelos.Punto;

public class PuntoServicio {
	static PuntoDao puntoDao;
	public void PuntoService() {
		puntoDao = PuntoDao.instance;
	}
	public void createPunto(Punto animal) {
		puntoDao.getPuntos().put(animal.getId(), animal);
	}
	public Punto getPunto(String id) {
		return puntoDao.getPuntos().get(id);
	}
	public Map<String, Punto> getPuntos() {
		return puntoDao.getPuntos();
	}
	public static List<Punto> getPuntoAsList() {
		List<Punto> animalList = new ArrayList<Punto>();
		animalList.addAll(puntoDao.getPuntos().values());
		return animalList;
	}
	public int getPuntosCount() {
		return puntoDao.getPuntos().size();
	}
	 public void deletePunto(String id) {
	 puntoDao.getPuntos().remove(id);
	 }

}

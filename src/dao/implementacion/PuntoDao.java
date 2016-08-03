package dao.implementacion;

import java.util.HashMap;
import java.util.Map;

import modelos.Punto;

public enum PuntoDao {
	instance;
	
	private Map<String, Punto> puntos = new HashMap<String, Punto>();
	
	private PuntoDao() {
		//metiendo puntos por defecto 
		Punto punto = new Punto("1", "123123", "321321");
		puntos.put("1", punto);
		punto = new Punto("2", "456465", "654654");
		puntos.put("2", punto);
	}
	public Map<String, Punto> getPuntos() {
		return puntos;
	}

}

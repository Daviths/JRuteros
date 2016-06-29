package dao;

import java.util.List;

import modelos.Puntaje;
import modelos.Ruta;
import modelos.Usuario;

public interface PuntajeDAO {
	public abstract void addNew(Puntaje puntaje);
	public abstract List<Puntaje> getAll();
	public abstract Puntaje getPuntaje(Usuario usuario, Ruta ruta);
	public abstract Puntaje getPuntajePorId(Integer id);
	public abstract void edit(Integer id, Integer puntos, String fecha);	
	public abstract void delete(Integer id);
}

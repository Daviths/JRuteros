package dao;

import java.util.List;

import modelos.Ruta;

public interface RutaDAO {
	public abstract void addNew(Ruta ruta);
	public abstract List<Ruta> getAll();
	public abstract void edit(Integer id, String nombre, String descripcion, String fecha_de_realizacion,
			String dificultad, Boolean es_publica, Boolean es_circular,
			Double distancia, Double tiempo_estimado);
	public abstract void cambiarEstado(Integer id);
	public abstract void delete(Integer id);
	public abstract Ruta findByName(String nombre);
}

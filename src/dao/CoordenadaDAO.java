package dao;

import java.util.List;

import modelos.Coordenada;

public interface CoordenadaDAO {
	public abstract void addNew(Coordenada coordenada);
	public abstract Coordenada getCoordenada(Integer id);
	public abstract List<Coordenada> getAll();
	public abstract void edit(Integer id, Double x, Double y);
	public abstract void delete(Integer id);	
}

package dao;

import java.util.List;

import modelos.Foto;

public interface FotoDAO {
	public abstract void addNew(Foto foto);
	public abstract List<Foto> getAll();
	public abstract void edit(Integer id, String nombre, String tipo, String contenido);
	public abstract void delete(int id);
	public abstract Foto findByName(String nombre);
	public abstract Foto getFoto(Integer id);	
}
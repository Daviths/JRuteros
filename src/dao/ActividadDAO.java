package dao;

import java.util.List;
import modelos.Actividad;

public interface ActividadDAO {
	public abstract void addNew(Actividad actividad);
	public abstract List<Actividad> getAll();
	public abstract void edit(Integer id, String nombre, String descripcion);
	public abstract void cambiarEstado(Integer id);
	public abstract void delete(int id);
}

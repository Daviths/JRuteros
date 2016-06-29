package dao;

import java.util.List;

import modelos.Usuario;

public interface UsuarioDAO {
	public abstract void addNew(Usuario usuario);
	public abstract List<Usuario> getAll();
	public abstract Usuario getUsuario(Integer id);
	public abstract void edit(Integer id, String dni, String domicilio, String nombre,
			String apellido, String sexo, String email);
	public abstract void cambiarEstado(Integer id);
	public abstract void delete(Integer id);
	public abstract Usuario findByName(String name);
}

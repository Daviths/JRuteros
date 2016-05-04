package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.sun.istack.internal.logging.Logger;

import db.DBUtils;
import modelos.Usuario;

public class UsuarioDAO {	
	public static void addNew(Usuario usuario) {
		try {
			String sql = "INSERT INTO usuarios (usuario, es_admin, esta_habilitado, dni, domicilio, nombre, apellido, fecha_de_nacimiento, sexo, email, password) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, usuario.getUsuario());			
			ps.setBoolean(2, false);
			ps.setBoolean(3, true);
			ps.setString(4, usuario.getDni());
			ps.setString(5, usuario.getDomicilio());
			ps.setString(6, usuario.getNombre());
			ps.setString(7, usuario.getApellido());
			ps.setString(8, usuario.getFecha_de_nacimiento());
			ps.setString(9, usuario.getSexo()); 
			ps.setString(10, usuario.getEmail());
			
			//Password
			String password = "gaspar";
			ps.setString(11, password);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}		
	}
	
	public static List<Usuario> getAll() {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		try {
			String sql = "SELECT * FROM usuarios";
			ResultSet rs = (ResultSet) DBUtils.getPreparedStatement(sql).executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario(rs);
				usuarios.add(usuario);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}
		
		return usuarios;
	}
	
	public static Usuario getUsuario(String usuario) {
		Usuario u = null;
		String sql = "SELECT * FROM usuarios WHERE usuario = '" + usuario + "'";
		
		try {
			ResultSet rs = (ResultSet) DBUtils.getPreparedStatement(sql).executeQuery();
			if(rs.next()) {
				u = new Usuario(rs);
			}
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
		
		return u;
	}
	
	public void edit(String usuario, String dni, String domicilio, String nombre, String apellido, String sexo, String email) {
		try {
			String sql = "UPDATE usuarios SET dni = ?, domicilio = ?, nombre = ?, apellido=?, sexo=?, email=? " + " WHERE usuario = ?";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, dni);
			ps.setString(2, domicilio);
			ps.setString(3, nombre);
			ps.setString(4, apellido);
			ps.setString(5, sexo);
			ps.setString(6, email);
			ps.setString(7, usuario);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void edit(String usuario) {
		try {
			String sql = "UPDATE usuarios SET esta_habilitado = !esta_habilitado" + " WHERE usuario = ?";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, usuario);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
	}
	
	public void delete(String usuario) {
		try {
			String sql = "DELETE FROM usuarios WHERE usuario = ?";			
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, usuario);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void cambiarEstado(String usuario) {
		edit(usuario);		
	}
	
}

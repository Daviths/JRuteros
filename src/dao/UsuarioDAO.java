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
	
	public void edit(String usuario, String dni, String domicilio, String nombre) {
		try {
			String sql = "UPDATE usuarios SET dni = ?, domicilio = ?, nombre = ?" + " WHERE usuario = ?";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, dni);
			ps.setString(2, domicilio);
			ps.setString(3, nombre);
			ps.setString(4, usuario);
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

package dao;

import modelos.Actividad;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.sun.istack.internal.logging.Logger;

import db.DBUtils;

public class ActividadDAO {
	
	public static void addNew(Actividad actividad){
		String sql = "INSERT INTO actividades (nombre,descripcion,esta_habiltada) VALUES(?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, actividad.getNombre());
			ps.setString(2, actividad.getDescripcion());
			ps.setBoolean(3, true);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ActividadDAO.class.getName(), null).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
	}
	
	public static List<Actividad> getAll() {
		List<Actividad> actividades = new LinkedList<Actividad>();
		
		try {
			String sql = "SELECT * FROM actividades";
			ResultSet rs = (ResultSet) DBUtils.getPreparedStatement(sql).executeQuery();
			while(rs.next()) {
				Actividad actividad= new Actividad(rs);
				actividades.add(actividad);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}
		
		return actividades;
	}
	
	public static Actividad getActividad(String actividad) {
		Actividad u = null;
		String sql = "SELECT * FROM actividades WHERE nombre = '" + actividad + "'";
		
		try {
			ResultSet rs = (ResultSet) DBUtils.getPreparedStatement(sql).executeQuery();
			if(rs.next()) {
				u = new Actividad(rs);
			}
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
		
		return u;
	}
	
	public void edit(String nombre, String descripcion) {
		try {
			String sql = "UPDATE actividades SET descripcion = ?" + " WHERE nombre = ?";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, descripcion);
			ps.setString(2, nombre);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void edit(String nombre) {
		try {
			String sql = "UPDATE actividades SET esta_habilitada = !esta_habilitada" + " WHERE nombre = ?";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, nombre);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
	}
	
	public void delete(String nombre) {
		try {
			String sql = "DELETE FROM actividades WHERE nombre = ?";			
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, nombre);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void cambiarEstado(String nombre) {
		edit(nombre);		
	}
}

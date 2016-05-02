package dao;

import modelos.Ruta;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.sun.istack.internal.logging.Logger;

import db.DBUtils;

public class RutaDAO {
	
	public static void addNew(Ruta ruta){
		String sql = "INSERT INTO rutas (nombre,descripcion,fecha_de_realizacion,es_publica,es_circular,distancia,tiempo_estimado,actividad,dificultad,usuario) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, ruta.getNombre());
			ps.setString(2, ruta.getDescripcion());
			ps.setString(3, ruta.getFecha_de_realizacion());
			ps.setBoolean(4, ruta.getEs_publica());
			ps.setBoolean(5, ruta.getEs_circular());
			ps.setFloat(6, ruta.getDistancia());
			ps.setFloat(7, ruta.getTiempo_estimado());
			ps.setString(8, ruta.getActividad());
			ps.setString(9, ruta.getDificultad());
			ps.setString(10, ruta.getUsuario());			
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(RutaDAO.class.getName(), null).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
	}
	
	public static List<Ruta> getAll() {
		List<Ruta> rutas = new LinkedList<Ruta>();
		
		try {
			String sql = "SELECT * FROM rutas";
			ResultSet rs = (ResultSet) DBUtils.getPreparedStatement(sql).executeQuery();
			while(rs.next()) {
				Ruta ruta= new Ruta(rs);
				rutas.add(ruta);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}
		
		return rutas;
	}
	
	public static Ruta getRuta(String ruta) {
		Ruta u = null;
		String sql = "SELECT * FROM rutas WHERE nombre = '" + ruta + "'";
		
		try {
			ResultSet rs = (ResultSet) DBUtils.getPreparedStatement(sql).executeQuery();
			if(rs.next()) {
				u = new Ruta(rs);
			}
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
		
		return u;
	}
	
	public static void edit(String nombre_original, String nombre_nuevo,String descripcion, Boolean es_publica, Boolean es_circular, Float distancia, Float tiempo_estimado, String actividad, String dificultad) {
		try {
			String sql = "UPDATE rutas SET nombre = ?,descripcion = ?,es_publica=?,es_circular=?,distancia=?,tiempo_estimado=?,actividad=?,dificultad=?" + " WHERE nombre = ?";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, nombre_nuevo);
			ps.setString(2, descripcion);
			ps.setBoolean(3, es_publica);
			ps.setBoolean(4, es_circular);
			ps.setFloat(5, distancia);
			ps.setFloat(6, tiempo_estimado);
			ps.setString(7, actividad);
			ps.setString(8, dificultad);
			ps.setString(9, nombre_original);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void edit(String nombre) {
		try {
			String sql = "UPDATE rutas SET es_publica = !es_publica" + " WHERE nombre = ?";
			PreparedStatement ps = (PreparedStatement) DBUtils.getPreparedStatement(sql);
			ps.setString(1, nombre);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void delete(String nombre) {
		try {
			String sql = "DELETE FROM rutas WHERE nombre = ?";			
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

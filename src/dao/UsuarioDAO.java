package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

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
				Usuario usuario = new Usuario(rs.getString(1),
												rs.getString(2),
												rs.getBoolean(3),
												rs.getBoolean(4),
												rs.getString(5),
												rs.getString(6),
												rs.getString(7),
												rs.getString(8),
												rs.getString(9),
												//rs.getString(10), sexo ???
												rs.getString(11));
				usuarios.add(usuario);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(UsuarioDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}
		
		return usuarios;
	}
	
}

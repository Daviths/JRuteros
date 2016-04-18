package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
        PreparedStatement ps =  null;
        
        String db_driver = "com.mysql.jdbc.Driver";
        String db_url = "jdbc:mysql://localhost/jruteros";
        String user = "root";
        String pass = "gaspar";
        
        Class.forName(db_driver);
        Connection con = DriverManager.getConnection(db_url, user, pass);
        ps = con.prepareStatement(sql);
        
        return ps;
    }
}

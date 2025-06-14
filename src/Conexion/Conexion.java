package Conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static Connection getConnetion(){
        String url = "jdbc:postgresql://localhost/ajedrez";
        String user = "postgres";
        String password = "NerlinAbreu2020";
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;

    }
}

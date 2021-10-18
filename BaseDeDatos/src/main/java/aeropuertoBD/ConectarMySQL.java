package aeropuertoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarMySQL {

    /**
     * Conecta Java con MySQL
     */
    public static void main(String[] args) {

        try {
            Connection conexion;

            String basedatos = "aeropuertos";
            String host = "localhost";
            String port = "3306";
            String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
            String user = "javi";
            String pwd = "1qaz2wsx";

            //Class.forName("com.mysql.jdbc.Driver");    // No necesario desde SE 6.0
            //Class.forName("com.mysql.cj.jdbc.Driver"); // para MySQL 8.0, no necesario
            conexion = DriverManager.getConnection(urlConnection, user, pwd);

            // Hace commit automaticamente
            conexion.setAutoCommit(true);

            // Creo una sentencia
            Statement sentencia = conexion.createStatement();
            
            // Ejecuto el SQL
            sentencia.executeQuery("SELECT * FROM aeropuertos");

            // Cierro la sentencia y la conexion
            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

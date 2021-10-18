package aeropuertoBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RecuperarAeropuertosContieneCadena {

    /**
     * Recupera todos los aeropuertos que contengan una determinada cadena y
     * muestralos por consola.
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

            // Creo la sentencia
            Statement sentencia = conexion.createStatement();

            // Creo un Scanner
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
            
            // Pido una cadena
            System.out.println("Escribe el nombre del aeropuerto: ");
            String busqueda = sn.next();

            // Formo el SQL
            String SQL = "";
            SQL += "SELECT a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero ";
            SQL += "FROM aeropuertos a, direcciones d ";
            SQL += "WHERE a.id_direccion = d.id ";
            SQL += "and trim(lower(a.nombre)) LIKE '%" + busqueda.toLowerCase().trim() + "%'";

            // Ejecuto el SQL y lo guardo
            ResultSet rs = sentencia.executeQuery(SQL);

            // Recorro los datos
            while (rs.next()) {

                // Obtengo y muestro los datos
                System.out.println("Nombre:" + rs.getString("nombre"));
                System.out.println("Año de inauguracion:" + rs.getInt("anio_inauguracion"));
                System.out.println("Capacidad:" + rs.getInt("capacidad"));
                System.out.println("Pais:" + rs.getString("pais"));
                System.out.println("Ciudad:" + rs.getString("ciudad"));
                System.out.println("Calle:" + rs.getString("calle"));
                System.out.println("Número:" + rs.getString("numero"));
                System.out.println("");
            }

            // Cierro el resultset, la sentencia y la conexion
            rs.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

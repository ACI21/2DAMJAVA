package aeropuertoBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecuperarAeropuertosPrivadosPublicos {

    /**
     * Recupera todos los aeropuertos publicos y privados y muestralos por
     * consola.
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

            // Formo el SQL para aeropuertos publicos
            String SQL = "";
            SQL += "SELECT a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.financiacion, ap.num_trab_discapacitados ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_publicos ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

            // Ejecuto la consulta y lo guarda en un resultset
            ResultSet rs = sentencia.executeQuery(SQL);

            // Aeropuertos publicoss
            System.out.println("Aeropuertos publicos");
            while (rs.next()) {

                System.out.println("Nombre:" + rs.getString("nombre"));
                System.out.println("Año de inauguracion:" + rs.getInt("anio_inauguracion"));
                System.out.println("Capacidad:" + rs.getInt("capacidad"));
                System.out.println("Pais:" + rs.getString("pais"));
                System.out.println("Ciudad:" + rs.getString("ciudad"));
                System.out.println("Calle:" + rs.getString("calle"));
                System.out.println("Número:" + rs.getString("numero"));
                System.out.println("Financiacion:" + rs.getDouble("financiacion"));
                System.out.println("Número trabajadores discapacitados:" + rs.getInt("num_trab_discapacitados"));
                System.out.println("");
            }

            rs.close();
            sentencia.close();

            sentencia = conexion.createStatement();

            // Formo el SQL para aeropuertos privados
            SQL = "";
            SQL += "SELECT a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.numero_socios ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_privados ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

            rs = sentencia.executeQuery(SQL);

            // Muestros los aeropuertos privados
            System.out.println("Aeropuertos privados");
            while (rs.next()) {

                System.out.println("Nombre:" + rs.getString("nombre"));
                System.out.println("Año de inauguracion:" + rs.getInt("anio_inauguracion"));
                System.out.println("Capacidad:" + rs.getInt("capacidad"));
                System.out.println("Pais:" + rs.getString("pais"));
                System.out.println("Ciudad:" + rs.getString("ciudad"));
                System.out.println("Calle:" + rs.getString("calle"));
                System.out.println("Número:" + rs.getString("numero"));
                System.out.println("Número socios:" + rs.getString("numero_socios"));
                
                System.out.println("");
            }

            // Cierro todo
            rs.close();
            sentencia.close();

            conexion.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

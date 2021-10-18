package aeropuertoBD;

/*
import Aeropuerto;
import AeropuertoPrivado;
import AeropuertoPublico;
import Direccion;
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CrearObjetosAeropuertos {

    /**
     * Recupera todos los aeropuertos publicos y privados, crealos en objetos y
     * muestralos por consola.
     */
    public static void main(String[] args) {

        try {
            Connection conexion;
            
            
            //

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

            //
            // Hace commit automaticamente
            conexion.setAutoCommit(true);

            // ArrayList donde guardare los aeropuertos
            ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();

            // Creo la sentencia
            Statement sentencia = conexion.createStatement();

            // Formo la SQL
            String SQL = "";
            SQL += "SELECT a.id, a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.financiacion, ap.num_trab_discapacitados ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_publicos ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

            // Ejecuto la consulta y la guardo en un resultset
            ResultSet rs = sentencia.executeQuery(SQL);

            // Recorro los datos
            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int anio = rs.getInt("anio_inauguracion");
                int capacidad = rs.getInt("capacidad");
                String pais = rs.getString("pais");
                String ciudad = rs.getString("ciudad");
                String calle = rs.getString("calle");
                int numero = rs.getInt("numero");
                double financiacion = rs.getDouble("financiacion");
                int discapacitados = rs.getInt("num_trab_discapacitados");

                // creo la direccion
                Direccion dir = new Direccion(pais, calle, numero, ciudad);

                // Creo el aeropuertos
                AeropuertoPublico a = new AeropuertoPublico(financiacion, discapacitados, id, nombre, dir, anio, capacidad);

                // Añado el aeropuerto al array
                aeropuertos.add(a);

            }

            rs.close();
            sentencia.close();

            sentencia = conexion.createStatement();

            // Formo el SQL
            SQL = "";
            SQL += "SELECT a.id, a.nombre, a.anio_inauguracion, a.capacidad, ";
            SQL += "d.pais, d.ciudad, d.calle, d.numero, ap.numero_socios ";
            SQL += "FROM aeropuertos a, direcciones d, aeropuertos_privados ap ";
            SQL += "WHERE a.id_direccion = d.id and ap.id_aeropuerto = a.id";

             // Ejecuto la consulta y la guardo en un resultset
            rs = sentencia.executeQuery(SQL);

             // Recorro los datos
            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int anio = rs.getInt("anio_inauguracion");
                int capacidad = rs.getInt("capacidad");
                String pais = rs.getString("pais");
                String ciudad = rs.getString("ciudad");
                String calle = rs.getString("calle");
                int numero = rs.getInt("numero");

                int numeroSocios = rs.getInt("numero_socios");

                // Creo la direccion
                Direccion dir = new Direccion(pais, calle, numero, ciudad);

                // Creo el aeropuerto
                AeropuertoPrivado a = new AeropuertoPrivado(numeroSocios, id, nombre, dir, anio, capacidad);

                // Añado el aeropuerto a la lista
                aeropuertos.add(a);

            }

            // Cierro todo
            rs.close();
            sentencia.close();
            conexion.close();

            // Mostrar la informacion de los aeropuertos
            for (Aeropuerto a : aeropuertos) {
                System.out.println(a.mostrarInformacion());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

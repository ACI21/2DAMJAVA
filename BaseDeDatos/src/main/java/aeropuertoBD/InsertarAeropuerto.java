package aeropuertoBD;

/*
import clases.Aeropuerto;
import clases.Direccion;
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

public class InsertarAeropuerto {

    /**
     * Inserta un aeropuerto
     */
    public static void main(String[] args) {

        try {
            Connection conexion;

            final int TIPO_PUBLICO = 1;
            final int TIPO_PRIVADO = 2;

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

            // Creo el scanner
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            sc.useLocale(Locale.US);

            // Pido todo lo relacionado con el aeropuerto
            
            Aeropuerto aeropuertoAux;
            Direccion dAux;

            double financiacion = 0;

            int numero, anioInauguracion, capacidad, eleccionTipo, numTrabajadoresDisc = 0, numSocios = 0, numAsientos, idAeropuerto;
            String nombre, pais, calle, ciudad;

            System.out.println("Escribe el nombre del aeropuerto");
            nombre = sc.next();

            System.out.println("Escribe el pais del aeropuerto");
            pais = sc.next();

            System.out.println("Escribe el calle del aeropuerto");
            calle = sc.next();

            System.out.println("Escribe el numero del aeropuerto");
            numero = validaNumero(0, Integer.MAX_VALUE);

            System.out.println("Escribe el ciudad del aeropuerto");
            ciudad = sc.next();

            System.out.println("Escribe el año de inauguracion del aeropuerto");
            anioInauguracion = validaNumero(0, Integer.MAX_VALUE);

            System.out.println("Escribe el capacidad del aeropuerto");
            capacidad = validaNumero(0, Integer.MAX_VALUE);

            System.out.println("¿Aeropuerto público o privado? (1=público, 2=privado)");
            eleccionTipo = validaNumero(1, 2);

            dAux = new Direccion(pais, calle, numero, ciudad);

            if (eleccionTipo == TIPO_PUBLICO) {

                System.out.println("Escribe la financiacion del aeropuerto");
                financiacion = sc.nextDouble();

                System.out.println("Escribe el numero de trabajadores discapacitados del aeropuerto");
                numTrabajadoresDisc = validaNumero(0, Integer.MAX_VALUE);

            } else {

                System.out.println("Escribe el numero de socios del aeropuerto");
                numSocios = validaNumero(0, Integer.MAX_VALUE);

            }

            // SQL para crear una direccion
            String SQL = "INSERT INTO direcciones VALUES(NULL, ?, ?, ?, ?)";

            PreparedStatement sentencia = conexion.prepareStatement(SQL);

            sentencia.setString(1, pais);
            sentencia.setString(2, ciudad);
            sentencia.setString(3, calle);
            sentencia.setInt(4, numero);

            // Inserto una direccion
            sentencia.executeUpdate();

            // SQL para recuperar el ultimo id insertado
            SQL = "SELECT last_insert_id() as last_id";

            Statement sentenciaID = conexion.createStatement();
            ResultSet rs = sentenciaID.executeQuery(SQL);

            rs.next();
            int idDir = rs.getInt("last_id");
            rs.close();
            sentenciaID.close();

             // Inserto un aeropuerto
            SQL = "INSERT INTO aeropuertos VALUES(null, ?, ?, ?, ?)";

            sentencia = conexion.prepareStatement(SQL);

            sentencia.setString(1, nombre);
            sentencia.setInt(2, anioInauguracion);
            sentencia.setInt(3, capacidad);
            sentencia.setInt(4, idDir);

            // inserto el aeropuerto
            sentencia.executeUpdate();

             // SQL para recuperar el ultimo id insertado
            SQL = "SELECT last_insert_id() as last_id";

            sentenciaID = conexion.createStatement();
            rs = sentenciaID.executeQuery(SQL);

            rs.next();
            idAeropuerto = rs.getInt("last_id");
            rs.close();
            sentenciaID.close();

            if (eleccionTipo == TIPO_PUBLICO) {

                // SQL para un aeropuerto publico
                SQL = "INSERT INTO aeropuertos_publicos VALUES(?, ?, ?)";

                sentencia = conexion.prepareStatement(SQL);

                sentencia.setInt(1, idAeropuerto);
                sentencia.setDouble(2, financiacion);
                sentencia.setInt(3, numTrabajadoresDisc);

            } else {

                // SQL para un aeropuerto privado
                SQL = "INSERT INTO aeropuertos_privados VALUES(?, ?)";

                sentencia = conexion.prepareStatement(SQL);

                sentencia.setInt(1, idAeropuerto);
                sentencia.setInt(2, numSocios);

            }

            // Inserto el aeropuerto (privado o publico)
            sentencia.executeUpdate();

            // Cierro todo
            sentencia.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static int validaNumero(int minimo, int maximo) {

        Scanner sc = new Scanner(System.in);

        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        int numero;
        do {

            System.out.println("Escribe un numero");
            numero = sc.nextInt();

            if (!(numero >= minimo && numero <= maximo)) {
                System.out.println("Debes escribir un numero entre " + minimo + " y " + maximo);
            }

        } while (!(numero >= minimo && numero <= maximo));

        return numero;

    }

}

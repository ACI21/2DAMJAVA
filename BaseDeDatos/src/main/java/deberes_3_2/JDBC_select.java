package deberes_3_2;

//Hecho por Álvaro Carrillo y Sergio Lorente
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_select {

 public static void muestraErrorSQL(SQLException e) {
    System.err.println("SQL ERROR mensaje: " + e.getMessage());
    System.err.println("SQL Estado: " + e.getSQLState());
    System.err.println("SQL cÃ³digo especÃ­fico: " + e.getErrorCode());
  }
  
  public static void main(String[] args) {

    String basedatos = "prueba";
    String host = "localhost";
    String port = "3306";
    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
    String user = "Alvaro";
    String pwd = "1650";

    try (
            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES")) {

      int i=1;
      while (rs.next()) {
        System.out.println("[" + (i++) + "]");        
        System.out.println("DNI: " + rs.getString("DNI"));
        System.out.println("Apellidos: " + rs.getString("APELLIDOS"));
        System.out.println("CP: " + rs.getInt("CP"));
        System.out.println();
        /*
         * Si se usa getInt() deberia dar como válida la ejecución, ya que al parsearlo no detecta letras
         * El getString() siempre va a funcionar porque lo convierte todo en letras y lo lee
         * 
         * Solución: efectivamente funciona con el getInt(), y un ejemplo claro es que convierte el null en 0;
         */
      }

    } catch (SQLException e) {
      muestraErrorSQL(e);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

}

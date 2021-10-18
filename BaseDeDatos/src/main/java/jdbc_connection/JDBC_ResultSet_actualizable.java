package jdbc_connection;

//6
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_ResultSet_actualizable {

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
            Connection c = DriverManager.getConnection(urlConnection, user, pwd)) {
      try (
              Statement sConsulta = c.createStatement(
                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                      ResultSet.CONCUR_UPDATABLE)) {

        ResultSet rs = sConsulta.executeQuery("SELECT * FROM CLIENTES WHERE CP IS NOT NULL");

        c.setAutoCommit(false);

        rs.last();  // Modifica útimo cliente
        rs.updateString("CP", "02569");
        rs.updateRow();

        rs.previous();  // Borrar penúltimo cliente
        rs.deleteRow();

        rs.moveToInsertRow();  // Inserta nueva fila
        rs.updateString("DNI", "24862499S");
        rs.updateString("APELLIDOS", "Llopis");
        rs.updateString("CP", "33983");
        rs.insertRow();

        c.commit();

      } catch (SQLException e) {
        muestraErrorSQL(e);
        try {
          c.rollback();
          System.err.println("Se hace ROLLBACK");
        } catch (Exception er) {
          System.err.println("ERROR haciendo ROLLBACK");
          er.printStackTrace(System.err);
        }
      }
    } catch (Exception e) {
      System.err.println("ERROR de conexiÃ³n");
      e.printStackTrace(System.err);
    }
  }

}

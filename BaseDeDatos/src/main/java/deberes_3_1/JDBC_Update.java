package deberes_3_1;
//Hecho por �lvaro Carrillo y Sergio Lorente
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Update {

	public static void muestraErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL código específico: " + e.getErrorCode());
	}

	public static void main(String[] args) {

		String basedatos = "prueba";
		String host = "localhost";
		String port = "3306";
		String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
		String user = "Alvaro";
		String pwd = "1650";

		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd); Statement s = c.createStatement()) {

			int nFil = s.executeUpdate
					("INSERT INTO CLIENTES (DNI,APELLIDOS,CP) VALUES "
					+ "('78901234X','NADALES','44126')," 
					+ "('89012345E','ROJAS', null),"
					+ "('56789012B','SAMPER','29730')");

			System.out.println(nFil + " Filas insertadas.");

		} catch (SQLException e) {
			muestraErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

}

package deberes_3_5;

//Hecho por �lvaro Carrillo y Sergio Lorente
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_select {

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

		String dni = JOptionPane.showInputDialog("Escribe el dni a buscar: ");

		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES1 where dni = '" + dni + "'")) {

			int i = 0;

			while (rs.next()) {
				System.out.println("[" + (i++) + "]");
				System.out.println("DNI: " + rs.getString("DNI"));
				System.out.println("Apellidos: " + rs.getString("APELLIDOS"));
				System.out.println("CP: " + rs.getString("CP"));
				System.out.println();
			}

		} catch (SQLException e) {
			muestraErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

}

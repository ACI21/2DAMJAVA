package ejercicioPropuesto3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class nuevoEmpleado {
	public final static String basedatos = "gestor_proyectos";
	public final static String host = "localhost";
	public final static String port = "3306";
	public final static String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public final static String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	public final static String user = "Alvaro";
	public final static String pwd = "1650";

	public static boolean newEmpleado(String dni, String nombre) {
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd); Statement s = c.createStatement()) {

			int nFil = s
					.executeUpdate("INSERT INTO empleado (dni,nom_emp) VALUES " + "('" + dni + "','" + nombre + "')");

			System.out.println(nFil + " Empleado agregado.");

		} catch (SQLException e) {

			muestraErrorSQL(e);
			return false;
		} catch (Exception e) {
			e.printStackTrace(System.err);

		}
		return true;
	}

	public static void muestraErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL código específico: " + e.getErrorCode());
	}
}

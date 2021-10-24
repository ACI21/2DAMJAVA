package ejercicioPropuesto3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class nuevoProyecto {
	public final static String basedatos = "gestor_proyectos";
	public final static String host = "localhost";
	public final static String port = "3306";
	public final static String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public final static String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	public final static String user = "Alvaro";
	public final static String pwd = "1650";

	public static void viewProyecto(String nombre) throws SQLException {
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd);
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery("SELECT * FROM proyecto where nom_proy = '"+nombre+"'")) {

			int i = 1;
			while (rs.next()) {
				System.out.println("[" + (i++) + "]" + "id_proy: " + rs.getString("id_proy"));
				System.out.println();
			}
		}
		return;

	}

	public static boolean newProyecto(String dni, String nombre, Date f_inicio, Date f_fin) {
		try (Connection c = DriverManager.getConnection(urlConnection, user, pwd); Statement s = c.createStatement()) {

			int nFil = s.executeUpdate("INSERT INTO proyecto (nom_proy,f_inicio,f_fin,dni_jefe_proy) VALUES " + "('"
					+ nombre + "', '" + f_inicio + "', '" + f_fin + "','" + dni + "')");

			System.out.println(nFil + " Proyecto creado.");
			System.out.println();
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
		System.err.println("SQL codigo especifico: " + e.getErrorCode());
	}
}

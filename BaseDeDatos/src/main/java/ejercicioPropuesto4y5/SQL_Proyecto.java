package ejercicioPropuesto4y5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL_Proyecto {
	private static final String basedatos;
	private static final String host;
	private static final String port;
	private static final String user;
	private static final String pwd;
	private static final String parAdic;
	private static final String urlConnection;

	static {
		basedatos = "gestor_proyectos";
		host = "localhost";
		port = "3306";
		user = "Alvaro";
		pwd = "1650";
		parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	}

//	Queries
	private static final String SQL_INSERT = "INSERT INTO proyecto (nom_proy,f_inicio,f_fin,dni_jefe_proy) VALUES (?,?,?,?)";
	private static final String SQL_SELECT = "SELECT * FROM PROYECTO WHERE nom_proy = ?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM PROYECTO";

	private static void logErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL codigo especifico: " + e.getErrorCode());
	}

	public static void viewProyecto() throws SQLException {
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

			Proyecto proyecto;

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {
					int id_proy = resultSet.getInt("id_proy");
					String nom_proy = resultSet.getString("nom_proy");
					Date f_inicio = resultSet.getDate("f_inicio");
					Date f_fin = resultSet.getDate("f_fin");
					String dni_jefe_proy = resultSet.getString("dni_jefe_proy");

					proyecto = new Proyecto(id_proy, nom_proy, f_inicio, f_fin, dni_jefe_proy);
					System.out.println(proyecto.toString());
				}
			}
		} catch (SQLException e) {
			logErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void viewProyecto(String nombre) throws SQLException {
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

			preparedStatement.setString(1, nombre);
			Proyecto proyecto;

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					int id_proy = resultSet.getInt("id_proy");
					String nom_proy = nombre;
					Date f_inicio = resultSet.getDate("f_inicio");
					Date f_fin = resultSet.getDate("f_fin");
					String dni_jefe_proy = resultSet.getString("dni_jefe_proy");

					proyecto = new Proyecto(id_proy, nom_proy, f_inicio, f_fin, dni_jefe_proy);
					System.out.println(proyecto.toString());
				}
			}
		} catch (SQLException e) {
			logErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean newProyecto(String dni, String nombre, Date f_inicio, Date f_fin) {
		boolean insert = false;
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {
			preparedStatement.setString(1, nombre);
			preparedStatement.setDate(2, f_inicio);
			preparedStatement.setDate(3, f_fin);
			preparedStatement.setString(4, dni);
			int row = preparedStatement.executeUpdate();

			if (row != 0) {
				insert = true;
			}
			if (insert == true) {
				System.out.println("Proyecto agregado satisfactoriamente.");
			} else {
				System.out.println("Fallo al agregar proyecto.");
			}
		} catch (SQLException e) {
			logErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void muestraErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL codigo especifico: " + e.getErrorCode());
	}
}

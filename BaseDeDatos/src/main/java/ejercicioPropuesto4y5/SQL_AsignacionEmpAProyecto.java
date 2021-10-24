package ejercicioPropuesto4y5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL_AsignacionEmpAProyecto {
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
	private static final String SQL_INSERT = "INSERT INTO asig_proyecto (dni_emp, id_proy, f_inicio, f_fin) VALUES (?,?, ?, ?);";
	private static final String SQL_SELECT_ALL = "SELECT * FROM asig_proyecto";

	private static void logErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL codigo especifico: " + e.getErrorCode());
	}
	
	public static boolean newEmpProy(String dni, int num_proy, Date f_inicio, Date f_fin) {
		boolean insert = false;
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

			preparedStatement.setString(1, dni);
			preparedStatement.setInt(2, num_proy);
			preparedStatement.setDate(3, f_inicio);
			preparedStatement.setDate(4, f_fin);
			int row = preparedStatement.executeUpdate();

			if (row != 0) {
				insert = true;
			}
			if (insert == true) {
				System.out.println("Proyecto asignado satisfactoriamente.");
			} else {
				System.out.println("Fallo al asignar proyecto.");
			}

		} catch (SQLException e) {
			logErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static void viewAsigEmpAProy() {
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

			try (ResultSet resultSet = preparedStatement.executeQuery();) 
			{
				AsignacionEmpAProyecto asignar;
				
				while (resultSet.next()) { 					
	                String dni = resultSet.getString("dni_emp");
	                int id_proy = resultSet.getInt("id_proy");
	                Date f_inicio = resultSet.getDate("f_inicio");
					Date f_fin = resultSet.getDate("f_fin");
					
					asignar = new AsignacionEmpAProyecto(dni, id_proy, f_inicio, f_fin);
	                System.out.println(asignar.toString()); 
	                System.out.println();
	            }
			}
		} catch (SQLException e) {
			logErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void muestraErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL codigo especifico: " + e.getErrorCode());
	}
}

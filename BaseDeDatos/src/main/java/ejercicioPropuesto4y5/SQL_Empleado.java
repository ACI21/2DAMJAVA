package ejercicioPropuesto4y5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL_Empleado {
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
	private static final String SQL_INSERT = "INSERT INTO EMPLEADO (DNI, NOM_EMP) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE EMPLEADO SET NOM_EMP=? WHERE DNI=?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM EMPLEADO";

	private static void logErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL codigo especifico: " + e.getErrorCode());
	}

	public static boolean newEmpleado(String dni, String nombre) {
		boolean insert = false;
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

			preparedStatement.setString(1, dni);
			preparedStatement.setString(2, nombre);
			int row = preparedStatement.executeUpdate();

			if (row != 0) {
				insert = true;
			}
			if (insert == true) {
				System.out.println("Empleado agregado satisfactoriamente.");
			} else {
				System.out.println("Fallo al agregar empleado.");
			}

		} catch (SQLException e) {
			logErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean editEmpleado(String dni, String nombre) {
		boolean edit = false;
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {

			preparedStatement.setString(2, dni);
			preparedStatement.setString(1, nombre);
			int row = preparedStatement.executeUpdate();

			if (row != 0) {
				edit = true;
			}
			if (edit == true) {
				System.out.println("Empleado editado satisfactoriamente.");
			} else {
				System.out.println("Fallo al editar empleado.");
			}

		} catch (SQLException e) {
			logErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static void viewEmpleado() {
		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

			try (ResultSet resultSet = preparedStatement.executeQuery();) 
			{
				Empleado empleado;
				
				while (resultSet.next()) { 					
	                String dni = resultSet.getString("dni");
	                String nom_emple = resultSet.getString("nom_emp");
	                empleado = new Empleado(dni, nom_emple);
	                System.out.println(empleado.toString()); 
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
		System.err.println("SQL código específico: " + e.getErrorCode());
	}
}

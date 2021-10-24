package ejercicioPropuesto4y5;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		int opciones;
		int opciones2;
		// Creamos el menú
		do {
			System.out.println("Introduzca la opción que desea realizar:");
			System.out.println("1. Añadir/Modificar/Ver empleado.");
			System.out.println("2. Añadir/Ver proyectos.");
			System.out.println("3. Ver proyectos asignados / Asignar un proyecto a un empleado.");
			System.out.println("0. Salir");

			opciones = sc.nextInt();

			switch (opciones) {

			case 1: // Operativo
				do {
					System.out.println("1. Añadir empleado.");
					System.out.println("2. Modificar empleado.");
					System.out.println("3. Ver empleados.");
					System.out.println("0. Volver");

					opciones2 = sc.nextInt();

					switch (opciones2) {
					case 1:
						System.out.println("Escribe el dni del empleado: ");
						String dni = sc.next();

						System.out.println("Escribe el nombre del empleado: ");
						String nombre = sc.next();

						SQL_Empleado.newEmpleado(dni, nombre);
						System.out.println();
						break;

					case 2:
						System.out.println("Introduzca DNI para modificar:");
						String dniEmple = sc.next();
						System.out.println("Introduzca el nuevo nombre:");
						String nomModEmple = sc.next();

						SQL_Empleado.editEmpleado(dniEmple, nomModEmple);
						break;

					case 3:
						SQL_Empleado.viewEmpleado();
						break;

					case 0:// submenu
						break;

					}

				} while (opciones2 != 0);

				break;

			case 2: // Operativo
				String nombre2 = "";
				do {
					System.out.println("1. Añadir proyectos.");
					System.out.println("2. Ver último proyecto creado.");
					System.out.println("3. Ver todos los proyectos.");
					System.out.println("0. Volver");
					opciones2 = sc.nextInt();

					switch (opciones2) {
					case 1:// submenu
						System.out.println("Escribe el dni del jefe de proyecto: ");
						String dni2 = sc.next();

						System.out.println("Escribe el nombre del proyecto: ");
						nombre2 = sc.next();

						Date date = Date.valueOf(LocalDate.now());

						Date date2 = Date.valueOf(LocalDate.now());

						SQL_Proyecto.newProyecto(dni2, nombre2, date, date2);
						break;
					case 2:// submenu
						if (nombre2.isEmpty()) {
							System.out.println("No hay proyectos recientes.");
							System.out.println();
						} else {
							SQL_Proyecto.viewProyecto(nombre2);
						}

						break;
						
					case 3:// submenu
						SQL_Proyecto.viewProyecto();
						break;
					case 0:// submenu
						break;
					}

				} while (opciones2 != 0);

				break;

			case 3: // Operativo
				do {
					System.out.println("1. Asignar proyectos.");
					System.out.println("2. Ver todos los proyectos.");
					System.out.println("0. Volver");
					opciones2 = sc.nextInt();
					
					switch (opciones2) {
					case 1:
						System.out.println("Escribe el dni del empleado: ");
						String dni3 = sc.next();

						System.out.println("Escribe el id del proyecto: ");
						int id_proy = sc.nextInt();

						Date f_inicio = Date.valueOf(LocalDate.now());

						Date f_fin = Date.valueOf(LocalDate.now());

						SQL_AsignacionEmpAProyecto.newEmpProy(dni3, id_proy, f_inicio, f_fin);
						break;
					case 2:
						SQL_AsignacionEmpAProyecto.viewAsigEmpAProy();
						break;
					case 0:
						break;
					}
				} while (opciones2 != 0);
				
				break;

			case 0:
				System.out.println("Cerrando servicios...");
				System.out.println("Vuelva pronto :D");
				break;
			}

		} while (opciones != 0);
		sc.close();
		// FIN DE PROGRAMA
	}
}

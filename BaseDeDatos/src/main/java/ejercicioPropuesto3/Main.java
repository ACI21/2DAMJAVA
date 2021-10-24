package ejercicioPropuesto3;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		//private JCalendar calendar = calendar = new JCalendar();;
		Scanner sc = new Scanner(System.in);
		int opciones;
		// Creamos el menú
		do {
			System.out.println("Introduzca la opción que desea realizar:");
			System.out.println("1. Añadir empleado.");
			System.out.println("2. Añadir o ver proyectos.");
			System.out.println("3. Asignar un proyecto a un empleado.");
			System.out.println("0. Salir");

			opciones = sc.nextInt();

			switch (opciones) {

			case 1: // Operativo

				System.out.println("Escribe el dni del empleado: ");
				String dni = sc.next();

				System.out.println("Escribe el nombre del empleado: ");
				String nombre = sc.next();

				nuevoEmpleado.newEmpleado(dni, nombre);
				System.out.println();
				break;

			case 2: //Operativo
				int opciones2;
				String nombre2 = "";
				do {
					System.out.println("1. Añadir proyectos.");
					System.out.println("2. Ver último proyecto creado.");
					System.out.println("0. Volver");
					opciones2 = sc.nextInt();
					
					
					switch (opciones2) {
					case 1://submenu
						System.out.println("Escribe el dni del jefe de proyecto: ");
						String dni2 = sc.next();

						System.out.println("Escribe el nombre del proyecto: ");						 
						nombre2= sc.next();
						
						Date date = Date.valueOf(LocalDate.now());
				        		
						Date date2 = Date.valueOf(LocalDate.now());
						
						nuevoProyecto.newProyecto(dni2, nombre2, date, date2);
						break;
					case 2://submenu
						if (nombre2.isEmpty()) {
							System.out.println("No hay proyectos recientes.");
							System.out.println();
						} else {
							nuevoProyecto.viewProyecto(nombre2);
						}
						
						break;
					case 0://submenu
						break;
					}

				} while (opciones2 != 0);

				break;

			case 3: //Operativo
				System.out.println("Escribe el dni del empleado: ");
				String dni3 = sc.next();

				System.out.println("Escribe el id del proyecto: ");						 
				int id_proy = sc.nextInt();
				
				Date f_inicio = Date.valueOf(LocalDate.now());
		        		
				Date f_fin = Date.valueOf(LocalDate.now());
				
				asignaEmpAPoyecto.newEmpProy(dni3, id_proy, f_inicio, f_fin);
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

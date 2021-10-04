/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Serializar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6277232929952106469L;

	static ArrayList<Futbolista> futbolistas = new ArrayList<>();

	static ArrayList<Equipo> equipos = new ArrayList<>();

	static ArrayList<Entrenador> entrenadores = new ArrayList<>();

	public static void main(String[] args) {
		ArrayList<Futbolista> futbolistasLeidos;
		ArrayList<Equipo> equiposLeidos;
		ArrayList<Entrenador> entrenadoresLeidos;
		System.out.println("Escoja opción: Futbolista / Equipo / Entrenador");
		//Scanner sc = new Scanner(System.in);		
		//String opcion = sc.nextLine();
		//sc.close();
		String cadena = JOptionPane.showInputDialog("Escribe una opcion entre las siguientes(Futbolista,Equipo,Entrenador) ");
		generarFutbolistas();
		generarEquipos();
		generarEntrenador();

		configprops.configprops(cadena);

		String config = configprops.leerConfig();

		switch (config) {
		case "Futbolista":
			outputSerializar(futbolistas);
			break;
		case "Equipo":
			outputSerializar(equipos);
			break;
		case "Entrenador":
			outputSerializar(entrenadores);
			break;
		}

		System.out.println("Datos guardados correctamente");

		switch (config) {
		case "Futbolista":
			futbolistasLeidos = (ArrayList<Futbolista>) inputSerializar();
			for (Futbolista futbolista : futbolistasLeidos) {
				System.out.println(futbolista.toString());
			}
			break;
		case "Equipo":
			equiposLeidos = (ArrayList<Equipo>) inputSerializar();
			for (Equipo equipo : equiposLeidos) {
				System.out.println(equipo.toString());
			}
			break;
		case "Entrenador":
			entrenadoresLeidos = (ArrayList<Entrenador>) inputSerializar();
			for (Entrenador entrenador : entrenadoresLeidos) {
				System.out.println(entrenador.toString());
			}
			break;
		}
	}

	public static Object inputSerializar() {

		FileInputStream fichero = null;
		ObjectInputStream serializador = null;
		Object objeto = null;

		try {
			fichero = new FileInputStream("futbol.ddr");
			serializador = new ObjectInputStream(fichero);

			objeto = serializador.readObject();

		} catch (FileNotFoundException fnfe) {
			System.out.println("No se encuentra el fichero especificado");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Tipo de objeto no conocido");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (serializador != null)
				try {
					serializador.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
		}
		return objeto;
	}

	public static void outputSerializar(Object objeto) {

		FileOutputStream fichero = null;
		ObjectOutputStream serializador = null;
		try {
			fichero = new FileOutputStream("futbol.ddr");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			serializador = new ObjectOutputStream(fichero);
			serializador.writeObject(objeto);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (serializador != null) {
				try {
					serializador.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	public static ArrayList<Futbolista> generarFutbolistas() {

		String[] posicion = { "Portero", "Defensa", "Centro", "Delantero" };

		for (int i = 0; i < 12; i++) {

			int aleatorio = Random.numeroAleatorioEntreRango(0, 3);
			int experiencia = Random.numeroAleatorioEntreRango(1, 100);
			int dorsal = Random.numeroAleatorioEntreRango(1, 100);

			Futbolista f = new Futbolista(dorsal, dorsal, null, "Futbolista " + (i + 1), dorsal, posicion[aleatorio], experiencia, dorsal, dorsal, dorsal, dorsal, dorsal, dorsal, dorsal, dorsal, null, dorsal, null, dorsal);
			futbolistas.add(f);
		}
		return futbolistas;
	}

	public static ArrayList<Equipo> generarEquipos() {

		for (int i = 0; i < 2; i++) {
			Equipo equipo = new Equipo("Equipo " + (i + 1), generarFutbolistas(), null);
			equipos.add(equipo);
		}

		return equipos;
	}

	public static ArrayList<Entrenador> generarEntrenador() {

		for (int i = 0; i < 2; i++) {
			Entrenador entrenador = new Entrenador("Entrenador " + (i + 1));
			entrenadores.add(entrenador);
		}
		return entrenadores;
	}
}

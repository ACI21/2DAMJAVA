/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaPrincipal implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -405510052422106165L;

	/**
	 * The Main1 method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) { // punto de entrada al programa
		Scanner sc = new Scanner(System.in);
	    int opcion = 0;
	    Competicion competicion = new Competicion();
	    
	    do{
	    	System.out.println("Elija una de las opciones:");
	        System.out.println("1. Generar equipos, jugadores y entrenadores.");
	        System.out.println("2. Jugar Liga.");
	        System.out.println("3. Mostrar tabla clasificatoria con resultados de la liga jugada.");
	        System.out.println("0. Salir\n");
        
        try {
	        
	        opcion = sc.nextInt();
         
	        switch(opcion){
	            case 1:	                
	                competicion.crearDatosEquipos(4);
	                //competicion.mostrarJugadores();
	                //competicion.mostrarEntrenadores();
	                //competicion.mostrarEquipos();	 
	                System.out.println("Equipos, Jugadores y Entrenadores preparados, ¡A jugar!.\n");
	                break;
	            case 2:
	            	competicion.ordenarPartidosCompeticion(4);
	                System.out.println("Que empiece el juego, buena suerte.\n");
	                break;
	             case 3:	            	
	                System.out.println("Y estos son los resultados del juego:\n");
	                competicion.mostrarClasificacion();
	                break;
	             case 0:
	            	 System.out.println("¡Buen partido! Gracias por jugar :D");
	                break;
	             default:
	                System.out.println("Solo números entre 1 y 4");
		    }
	        
        }catch (InputMismatchException e) {
	            System.out.println("Debes insertar un número");
	            sc.next();
	    }
	    
	    }while(opcion != 0);
	    sc.close();
	}	
}
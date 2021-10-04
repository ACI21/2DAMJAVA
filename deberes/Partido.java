/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Opcional: Hacer seguimiento de los jugadores sancionados y/o lesionados. Dicha informacion se pasara a los equipos/competicion tras cada partido.
 * 
 */

public class Partido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4077781394706023158L;
	
	
	Equipo local;
	Equipo visitante;
	int [] resultado;
	String localidad;
	Futbolista mvp;
	ArrayList<Futbolista> goleadores;
	//Futbolista [] sancionados;
	//Futbolista [] lesionados;
	//Tarjeta [] listaSanciones; // ¿como hacerlo?
	
	LocalDate fecha;
	
	/**
	 * @param local
	 * @param visitante
	 * @param resultado
	 * @param localidad
	 * @param mvp
	 * @param goleadores
	 * @param fecha
	 */
	public Partido(Equipo local, Equipo visitante, LocalDate fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.fecha = fecha;
	}



	/*
	 * Hara los calculos estadisticos pertinentes para calcular el resultado. En base a el valor()
	 */
	public void calcularGanador() {			
		/*
		 * Modificamos +-10% aleatoriamente el valor de cada equipo que juega el partido. El ganador del partido será el que tenga mayor valor una vez modificado el 10% aleatorio.
		 * El empate se produce cuando la diferencia de puntos es menor a diez.
		 * 
		 */	
		
		float vLocal = this.local.calcValor()*valorAleatorio();
        float vVisitante = this.visitante.calcValor()*valorAleatorio();

        if(vLocal-vVisitante < 10 ) {
            this.local.anyadirPuntos("Empate");
            this.visitante.anyadirPuntos("Empate");

        }else if(vLocal > vVisitante && vLocal > 10) {
            this.local.anyadirPuntos("Ganado");
            this.visitante.anyadirPuntos("Perdido");
        }else if(vLocal < vVisitante && vVisitante > 10) {
            this.local.anyadirPuntos("Perdido");
            this.visitante.anyadirPuntos("Ganado");
        }
		
		
	}

	private float valorAleatorio() {
		// TODO Auto-generated method stub
		 int aleatorio = (int) (Math.random());
	        switch(aleatorio) {
	        case 0:
	            return 0.90f;
	        case 1:
	            return 1.10f;
	        }
	        return 1;
	}
	



	public void calcularMVP() {
		/*En caso de empate a cero se le asigna a suerte a un portero
		 * si hay un máximo goleador a él 
		 * si hay más de uno se sortea a partes iguales.
		 */
		
	}
/*	
	public Equipo getGanador() {//En caso de empate resultado null.
			
	}
	
	public Equipo getPerdedor() {//En caso de empate resultado null.
		
	}
	
	private Futbolista[] getGoleadores() {//Obtenemos del calculo quienes son los goleadores.
		
	}
	
	
*/	
	public void calcularGoleadores() {//Calcula quienes son los goleadores.
		/*Para la asignacion del gol el porcentaje según posición es:
		 * Delantero 70%, Centro 20%, Defensa 9% y portero 1%.
		 * Y después dividiremos entre los jugadores que hayan en esa categoría.
		 */
		
	}
	
	/*
	 * Ganador: 3puntos
	 * Empate: 1 punto cada equipo.
	 * Perdedor: 0 puntos.
	 * 
	 *  
	 */
	public void asignarPuntos () {
		// ¿Dónde se apuntan los puntos?
	    //Dentro de cada equipo aquí
		
		
	}
	
//	public int getGolesLocal(){}
//	public int getGolesVisitante(){}
//	
//	public int getGoles(Equipo equipo) {}
	
	
	
	
	
	
}
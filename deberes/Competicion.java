/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Competicion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5593333187670337349L;
	
	ArrayList<Entrenador> entrenador = new ArrayList<Entrenador>();
	ArrayList<Futbolista> jugadores = new ArrayList<Futbolista>();
	ArrayList<Equipo> equipos = new ArrayList<Equipo>();;
	static ArrayList<Partido> partidos = new ArrayList<Partido>();
	ArrayList<Equipo> clasificacion = new ArrayList<Equipo>();
	Entrenador alineacion;
	Titulo titulo;
	
	/**
	 * Vacio para convocar en el main
	 */
	public Competicion() {
		super();
	}

	/**
	 * @param entrenador
	 * @param jugadores
	 * @param equipos
	 * @param partidos
	 * @param clasificacion
	 * @param titulo
	 
	public Competicion(ArrayList<Entrenador> entrenador, ArrayList<Futbolista> jugadores, ArrayList<Equipo> equipos,
			ArrayList<Partido> partidos, ArrayList<Equipo> clasificacion, Titulo titulo) {
		super();
		this.entrenador = entrenador;
		this.jugadores = jugadores;
		this.equipos = equipos;
		this.partidos = partidos;
		this.clasificacion = clasificacion;
		this.titulo = titulo;
	}*/

	public void ordenarPartidosCompeticion(int numEquipo) {
		//Pasos sugeridos, no obligatorios.
		//0. Hacemos la alineacion
			//alineacion.ponerAlineacion(jugadores);
		//1. Crear un ArrayList partidos en el que guardará los partidos a jugar (tamaño de "partidos" depende de tamaño de "equipos").
		//2. Computar las combinaciones de partidos posibles.
		//3. "Apuntar" las combinaciones en el ArrayList partidos.
			LocalDate fecha = LocalDate.now();
			
			for(int i = 0; i < numEquipo; i++) {
				for(int j = 0; j < i; j++) {
					if(i!=j) {
						partidos.add(new Partido(equipos.get(j), equipos.get(i), fecha) );
					}
					
				}
			}		
			
		//4. Invocar el método jugarLiga();
			jugarLiga();
	}
	
	public static void jugarLiga() {
		//1. Procesar el ArrayList partidos jugando todos los partidos que contiene.
		//2. Recuerda actualizar puntos, etc a cada partido que es jugado.
		for (Partido partido : partidos) {
            partido.calcularGanador();
        }		
	}
	
	
	public void crearDatosEquipos (int numEquipos) {
		ArrayList<Entrenador> entrenadores = crearEntrenadores(numEquipos);
		ArrayList<Futbolista> jugadores = crearJugadores(numEquipos);
		this.equipos = crearEquipos(numEquipos,entrenadores,jugadores);
	}
	
	private ArrayList<Entrenador> crearEntrenadores(int numEquipos) {
		// TODO Auto-generated method stub
		for(int i = 0; i < numEquipos; i++) {
				
			LocalDate fecha = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 40))));
			float altura = (float) (Math.random()*100) ;
			float peso = (float) (Math.random()*100);
			float sueldo = (float) (Math.random()*100000);
			int liderazgo  = (int) (Math.random()*100);
			int estrategia = (int) (Math.random()*100);
			int comunicacion = (int) (Math.random()*100);
	
			entrenador.add(new Entrenador("Entrenador "+i,fecha,altura,peso,"Equipo "+i,sueldo,0, liderazgo,estrategia,comunicacion));
		}		
		return entrenador;
	}


	private ArrayList<Futbolista> crearJugadores(int numEquipos) {
		// TODO Auto-generated method stub		
		for(int j = 0; j < numEquipos; j++) {
		
			for (int i = 0; i <22; i++) { 
				float altura = (float) (Math.random()*100) ;
				float peso = (float) (Math.random()*100);
				float sueldo = (float) (Math.random()*100000);
				int velocidad = (int) (Math.random()*100);
				int resistencia = (int) (Math.random()*100);
				int fuerza = (int) (Math.random()*100);
				int potencia = (int) (Math.random()*100);
				int control = (int) (Math.random()*100);
				int pase  = (int) (Math.random()*100);
				int chute = (int) (Math.random()*100);
				int goles = (int) (Math.random()*100);
				int exp   = 0;
				
				int valor = (velocidad + resistencia + fuerza + potencia + control + pase + chute)/7;
				String categoria[] = new String[4];			
				
				LocalDate fecha = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 40))));
				
				if (i < 2) {/*portero*/
					if (valor <= 25) {
						categoria[0] = "Baja";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Portero",exp,categoria[0],valor));

					}else if(valor > 25 && valor <= 50) {
						categoria[1] = "Media";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Portero",exp,categoria[1],valor));

					}else if(valor > 50 && valor <= 75) {
						categoria[2] = "Alta";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Portero",exp,categoria[2],valor));

					}else if(valor > 75 && valor <= 100) {
						categoria[3] = "Estrella";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Portero",exp,categoria[3],valor));

					}
				} else if (i >= 2 && i < 10) {/*defensa*/
					if (valor <= 25) {
						categoria[0] = "Baja";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Defensas",exp,categoria[0],valor));

					}else if(valor > 25 && valor <= 50) {
						categoria[1] = "Media";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Defensas",exp,categoria[1],valor));

					}else if(valor > 50 && valor <= 75) {
						categoria[2] = "Alta";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Defensas",exp,categoria[2],valor));

					}else if(valor > 75 && valor <= 100) {
						categoria[3] = "Estrella";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Defensas",exp,categoria[3],valor));

					}
				}else if (i >= 10 && i < 18) {/*centrocampista*/
					if (valor <= 25) {
						categoria[0] = "Baja";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Centrocampistas",exp,categoria[0],valor));

					}else if(valor > 25 && valor <= 50) {
						categoria[1] = "Media";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Centrocampistas",exp,categoria[1],valor));

					}else if(valor > 50 && valor <= 75) {
						categoria[2] = "Alta";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Centrocampistas",exp,categoria[2],valor));

					}else if(valor > 75 && valor <= 100) {
						categoria[3] = "Estrella";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Centrocampistas",exp,categoria[3],valor));

					}
				}else if (i >= 18 && i < 22) {/*delantero*/
					if (valor <= 25) {
						categoria[0] = "Baja";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Delantero",exp,categoria[0],valor));

					}else if(valor > 25 && valor <= 50) {
						categoria[1] = "Media";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Delantero",exp,categoria[1],valor));

					}else if(valor > 50 && valor <= 75) {
						categoria[2] = "Alta";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Delantero",exp,categoria[2],valor));

					}else if(valor > 75 && valor <= 100) {
						categoria[3] = "Estrella";
						jugadores.add(new Futbolista(altura, peso, fecha , "Jugador"+i, i, "Equipo"+j, sueldo, velocidad,resistencia,fuerza,potencia,control,pase,chute,goles,"Delantero",exp,categoria[3],valor));

					}
				}
			}			
		}
		return jugadores;
	}
	
	
	private ArrayList<Equipo> crearEquipos(int numEquipos, ArrayList<Entrenador> entrenadores, ArrayList<Futbolista> jugadores) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numEquipos; i++) {
			equipos.add(new Equipo("Equipo"+i, jugadores, entrenadores.get(i)) );
		}
		return equipos;
	}

	public void crearClasificacion() {
		//El que más puntos tenga. A empate de puntos se pasa a ver quien tiene más goles. En caso de empate de todo orden alfabético del nombre de equipo.
		for (Equipo equipo : clasificacion) {
			this.clasificacion.add(equipo);
		}
		Collections.sort(clasificacion);
	}
	
//	public Equipo[] getClasificacion() {}
	
	
	public void mostrarClasificacion() {
		for (Equipo equipo : clasificacion) {
			System.out.print(equipo.getNombre() );
		}
	} //muestra por pantalla la tabla de clasificación

	public void guardarClasificacion() {} //guarda en archivo detexto la tabla de clasificación 
	
	public void asignarTitulo(Equipo e) {}
	
	
	/*
	 * Mostrar por pantalla una tabla con las características de cada jugador 
	 * que participa en la competición. Utilizaremos este método antes y después de 
	 * jugarse la competición.
	 */
	public void mostrarJugadores() {		
		System.out.println(jugadores.toString()+"\n");
	} 
	
	/*
	 * Mostrar por pantalla una tabla con las características de cada entrenador 
	 * que participa en la competición.  Utilizaremos este método antes y después de 
	 * jugarse la competición.
	 */
	public void mostrarEntrenadores() {
		System.out.println(entrenador.toString()+"\n");
	}
	
	
	/*
	 * Mostrar por pantalla una tabla con las características de cada Equipo 
	 * que participa en la competición.  Utilizaremos este método antes y después de 
	 * jugarse la competición.
	 */
	public void mostrarEquipos() {
		System.out.println(equipos.toString()+"\n");
	}
	
	
	
	
	
	
	
}

/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Class Equipo.
 * Opcional: considerar la funcionalidad de hacer fichajes. Tener en cuenta que fichar a un futbolista implica darlo de baja en su respectivo equipo.
 * 
 * @author Javier Faus Llopis
 */
public class Equipo implements Comparable<Object>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -18522333735142937L;
	
	private String nombre;
	private ArrayList<Futbolista> aEquipo;
	private Entrenador entrenador;
	private String localidad;
	private LocalDate fechFundacion;
	private ArrayList<Futbolista> alineacion;//los once jugadores que seran titulares en un determinado partido
	private ArrayList<Titulo> titulos;
	private float patrimonio;
	private String nombrePresidente;
	private String [] equipacion; // tres equipaciones. Ej: 1."Blanco" , 2. "Azul", 3. "BlanquiAzul"  

	private int puntos; // representa los puntos del equipo en una competicion
	private int patidosGanados=0;
	private int partidosPerdidos=0;
	private int partidosEmpatados=0;

	// implementar todos los métodos
	
	

	/**
	 * @param nombre
	 * @param aEquipo
	 * @param entrenador
	 */
	public Equipo(String nombre, ArrayList<Futbolista> aEquipo, Entrenador entrenador) {
		super();
		this.nombre = nombre;
		this.aEquipo = aEquipo;
		this.entrenador = entrenador;
	}
	
	/**
	 * @param nombre
	 * @param aEquipo
	 * @param entrenador	 
	 * @param alineacion	 
	 * @param equipacion
	 * @param puntos
	 * @param patidosGanados
	 * @param partidosPerdidos
	 * @param partidosEmpatados
	 */
	public Equipo(String nombre, ArrayList<Futbolista> aEquipo, Entrenador entrenador, ArrayList<Futbolista> alineacion, 
			String[] equipacion, int puntos, int patidosGanados, int partidosPerdidos,int partidosEmpatados) {
		super();
		this.nombre = nombre;
		this.aEquipo = aEquipo;
		this.entrenador = entrenador;		
		this.alineacion = alineacion;		
		this.equipacion = equipacion;
		this.puntos = puntos;
		this.patidosGanados = patidosGanados;
		this.partidosPerdidos = partidosPerdidos;
		this.partidosEmpatados = partidosEmpatados;
	}
	
	public void anyadirClasificacion() {
		
	}

	public  int calcValor() {//Capacidad de ganar un partido, es la media de sus jugadores alineados y su entrenador.
		
		return 1; 
	} 
	
	
	
	public  void anyadirPuntos(String params) {
		if (params == "Ganado") {
			puntos += 3;
			patidosGanados += 1;
		}else if (params == "Empate") {
			puntos += 1;
			partidosEmpatados += 1;
		}else if (params == "Perdido") {
			puntos += 0;
			partidosPerdidos += 1;
		}
	}
	public  void anyadirTitulo(String params, int anyo) {
		titulos.get(0).setNombre(params);
		titulos.get(0).setAnyo(anyo);
	}
	public  void actualizarPatrimonio (float dinero) {
		patrimonio = dinero;
	}
	public  void anyadirFutbolista (Futbolista fichaje) {
		//parte 2
	}
	public  void eliminarFutbolista (Futbolista despedido) {
		//parte 2
	}
	public  void cambiarEntrenador (Entrenador nuevo) {
		//parte 2
	}
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", aEquipo=" + aEquipo + ", entrenador=" + entrenador + "]";
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the aEquipo
	 */
	public ArrayList<Futbolista> getaEquipo() {
		return aEquipo;
	}
	/**
	 * @param aEquipo the aEquipo to set
	 */
	public void setaEquipo(ArrayList<Futbolista> aEquipo) {
		this.aEquipo = aEquipo;
	}
	/**
	 * @return the entrenador
	 */
	public Entrenador getEntrenador() {
		return entrenador;
	}
	/**
	 * @param entrenador the entrenador to set
	 */
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return the fechFundacion
	 */
	public LocalDate getFechFundacion() {
		return fechFundacion;
	}
	/**
	 * @param fechFundacion the fechFundacion to set
	 */
	public void setFechFundacion(LocalDate fechFundacion) {
		this.fechFundacion = fechFundacion;
	}
	/**
	 * @return the alineacion
	 */
	public ArrayList<Futbolista> getAlineacion() {
		return alineacion;
	}
	/**
	 * @param alineacion the alineacion to set
	 */
	public void setAlineacion(ArrayList<Futbolista> alineacion) {
		this.alineacion = alineacion;
	}
	/**
	 * @return the titulos
	 */
	public ArrayList<Titulo> getTitulos() {
		return titulos;
	}
	/**
	 * @param titulos the titulos to set
	 */
	public void setTitulos(ArrayList<Titulo> titulos) {
		this.titulos = titulos;
	}
	/**
	 * @return the patrimonio
	 */
	public float getPatrimonio() {
		return patrimonio;
	}
	/**
	 * @param patrimonio the patrimonio to set
	 */
	public void setPatrimonio(float patrimonio) {
		this.patrimonio = patrimonio;
	}
	/**
	 * @return the nombrePresidente
	 */
	public String getNombrePresidente() {
		return nombrePresidente;
	}
	/**
	 * @param nombrePresidente the nombrePresidente to set
	 */
	public void setNombrePresidente(String nombrePresidente) {
		this.nombrePresidente = nombrePresidente;
	}
	/**
	 * @return the equipacion
	 */
	public String[] getEquipacion() {
		return equipacion;
	}
	/**
	 * @param equipacion the equipacion to set
	 */
	public void setEquipacion(String[] equipacion) {
		this.equipacion = equipacion;
	}
	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}
	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	/**
	 * @return the patidosGanados
	 */
	public int getPatidosGanados() {
		return patidosGanados;
	}
	/**
	 * @param patidosGanados the patidosGanados to set
	 */
	public void setPatidosGanados(int patidosGanados) {
		this.patidosGanados = patidosGanados;
	}
	/**
	 * @return the partidosPerdidos
	 */
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	/**
	 * @param partidosPerdidos the partidosPerdidos to set
	 */
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	/**
	 * @return the partidosEmpatados
	 */
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	/**
	 * @param partidosEmpatados the partidosEmpatados to set
	 */
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

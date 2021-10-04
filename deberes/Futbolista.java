/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * The class Futbolista 
 * @author 		Javier Faus LLopis (javier.faus@gmail.com)
 * @version     Current version of the program.
 * @since       When this part of the program was first added.
 */
//@deprecated  For showing the code is outdated or shouldn't be used.
//* @param       For describing the different parameters for a method.
//* @return      For describing what the method returns.
//* @see         Links to another part of documentation.


public class Futbolista extends Persona implements Comparable<Object>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6291761360491715325L;

	/** The dorsal. */
	private int dorsal;
	
	private int velocidad;
	private int resistencia;
	private int fuerza;
	private int potencia;
	private int control;
	private int pase;
	private int chute;
	private int goles;
	private String posicion;
	private String categoría;//baja, media, alta, estrella.
	private int valor;
	
	/**
	 * @param nombre			String
	 * @param fechaNacimiento	LocalDate 
	 * @param altura			float
	 * @param peso				float
 	 * @param experiencia 		int Vamos acumulando experiencia para subir de categoría (cada 100 puntos)
	 * @param nomEquipo 		String
	 * @param sueldo			float
	 * 
	 * @param dorsal			int
	 * @param velocidad			int De 1 a 100
	 * @param resistencia		int De 1 a 100
	 * @param fuerza			int De 1 a 100
	 * @param potencia			int De 1 a 100
	 * @param control			int De 1 a 100
	 * @param pase				int De 1 a 100
	 * @param chute				int De 1 a 100
	 * @param goles				int Acumula los goles de este jugador
	 * @param posicion			String Portero, defensa, centrocampista, delantero	
	 * @param categoría			String baja, media, alta, estrella.
	 */
	
	
	public Futbolista(float altura, float peso, LocalDate fechaNacimiento, String nombre, int dorsal,
			String nomEquipo,float sueldo, int velocidad, int resistencia, int fuerza, int potencia, int control,
			int pase, int chute, int goles, String posicion, int experiencia, String categoría, int valor ) {

		super(nombre,fechaNacimiento,altura,peso,experiencia,nomEquipo,sueldo);

		this.velocidad = velocidad;
		this.resistencia = resistencia;
		this.fuerza = fuerza;
		this.potencia = potencia;
		this.control = control;
		this.pase = pase;
		this.chute = chute;
		this.goles = goles;
		this.posicion = posicion;
		this.categoría = categoría;
		this.dorsal = dorsal;
		this.valor = valor;
	}
	
	public Futbolista() {
		super();
		// TODO Auto-generated constructor stub
		this.velocidad = 0;
		this.resistencia = 0;
		this.fuerza = 0;
		this.potencia = 0;
		this.control = 0;
		this.pase = 0;
		this.chute = 0;
		this.goles = 0;
		this.posicion = "";
		this.categoría = "";
	}
	
	
	public Futbolista(Futbolista f) {
		super((Persona)f);
		this.velocidad = f.getVelocidad();
		this.resistencia = f.getResitencia();
		this.fuerza = f.getFuerza();
		this.potencia = f.getPotencia();
		this.control = f.getControl();
		this.pase = f.getPase();
		this.chute = f.getChute();
		this.goles = f.getGoles();
		this.posicion = f.getPosicion();
		this.categoría = f.getCategoría();
	}
	
	
	
	// sobrecarga del constructor con solo atributo nombre
	public Futbolista(String nombre) {
			this.setNombre(nombre);
		}


		public void copiar(Futbolista f) {
			
			super.copiar((Persona)f);
			
			this.velocidad = f.getVelocidad();
			this.resistencia = f.getResitencia();
			this.fuerza = f.getFuerza();
			this.potencia = f.getPotencia();
			this.control = f.getControl();
			this.pase = f.getPase();
			this.chute = f.getChute();
			this.goles = f.getGoles();
			this.posicion = f.getPosicion();
			this.categoría = f.getCategoría();
		}
		
		
		public float calcValor(){
			float valor=0;
			
			valor = (velocidad + resistencia + potencia + fuerza + control + pase + chute) / 7.0f;
			
			return valor;
			
		} //devuelve el valor que aporta el entrenador al equipo
		
		
		
		@Override
		public String toString() {
			return super.toString() +", dorsal=" + dorsal + ", velocidad=" + velocidad + ", resistencia=" + resistencia
					+ ", fuerza=" + fuerza + ", potencia=" + potencia + ", control=" + control + ", pase=" + pase
					+ ", chute=" + chute + ", goles=" + goles + ", posicion=" + posicion + ", categoría=" + categoría
					+ "]\n";
		}

		
		
		
		
		@Override
		public int compareTo(Object futbolistaComparado) {

			int resultado=0;

			if( futbolistaComparado instanceof Futbolista ) {


				float valorFutbolistaComparado=((Futbolista)futbolistaComparado).calcValor();


				if( this.calcValor() >  valorFutbolistaComparado ) {
					resultado = 1; //valor positivo, yo soy mayor.
				}
				else if(this.calcValor() <  valorFutbolistaComparado) {
					resultado = -1; // valor negativo, el objetoComparado es mayor
				}
				else {
					resultado=0; // valor cero indica igualdad
				}
				
			} 
			else {
				//si el objeto comparado no es de este tipo EstudianteComparable devolveremos 0 igualmente, podríamos hacer otras acciones.
				System.err.println("Error: comparando objeto Futbolista con otro tipo de objeto:");
				System.err.print(futbolistaComparado.getClass());
				
			}

			// Si queremos invertir el orden devuelto para que sea descendente
			resultado*= -1;
		
			return resultado;
		
		}
		
		
		public int getDorsal() {
			return dorsal;
		}

		public void setDorsal(int dorsal) {
			this.dorsal = dorsal;
		}

		public int getVelocidad() {
			return velocidad;
		}

		public void setVelocidad(int velocidad) {
			this.velocidad = velocidad;
		}

		public int getResitencia() {
			return resistencia;
		}

		public void setResitencia(int resistencia) {
			this.resistencia = resistencia;
		}

		public int getFuerza() {
			return fuerza;
		}

		public void setFuerza(int fuerza) {
			this.fuerza = fuerza;
		}

		public int getPotencia() {
			return potencia;
		}

		public void setPotencia(int potencia) {
			this.potencia = potencia;
		}

		public int getControl() {
			return control;
		}

		public void setControl(int control) {
			this.control = control;
		}

		public int getPase() {
			return pase;
		}

		public void setPase(int pase) {
			this.pase = pase;
		}

		public int getChute() {
			return chute;
		}

		public void setChute(int chute) {
			this.chute = chute;
		}

		public int getGoles() {
			return goles;
		}

		public void setGoles(int goles) {
			this.goles = goles;
		}

		public String getPosicion() {
			return posicion;
		}

		public void setPosicion(String posicion) {
			this.posicion = posicion;
		}

		public String getCategoría() {
			return categoría;
		}

		public void setCategoría(String categoría) {
			this.categoría = categoría;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((categoría == null) ? 0 : categoría.hashCode());
			result = prime * result + chute;
			result = prime * result + control;
			result = prime * result + dorsal;
			result = prime * result + fuerza;
			result = prime * result + goles;
			result = prime * result + pase;
			result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
			result = prime * result + potencia;
			result = prime * result + resistencia;
			result = prime * result + velocidad;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Futbolista other = (Futbolista) obj;
			if (categoría == null) {
				if (other.categoría != null)
					return false;
			} else if (!categoría.equals(other.categoría))
				return false;
			if (chute != other.chute)
				return false;
			if (control != other.control)
				return false;
			if (dorsal != other.dorsal)
				return false;
			if (fuerza != other.fuerza)
				return false;
			if (goles != other.goles)
				return false;
			if (pase != other.pase)
				return false;
			if (posicion == null) {
				if (other.posicion != null)
					return false;
			} else if (!posicion.equals(other.posicion))
				return false;
			if (potencia != other.potencia)
				return false;
			if (resistencia != other.resistencia)
				return false;
			if (velocidad != other.velocidad)
				return false;
			return true;
		}
	
	
	
	
	
}

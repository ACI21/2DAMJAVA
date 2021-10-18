package aeropuertoBD;


import java.io.Serializable;
import java.util.Objects;

/**
 * Clase Avion, representa un avion
 * 
 *  */
public class Avion implements Activable, Serializable {

    private static final long serialVersionUID = 1L;
    // Atributos
    private int id;
    private String modelo;
    private int nAsientos;
    private double velocidadMaxima;
    private boolean activado;

    /**
     * Constructor vacio
     */
    public Avion() {
        this("", 0, 0);
    }

    /**
     * Constructor completo
     * @param modelo model del avion
     * @param nAsientos numero de asientos del avion
     * @param velocidadMaxima  velocidad maxima del avion
     */
    public Avion(String modelo, int nAsientos, double velocidadMaxima) {
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado = false;
    }
    
    /**
     * Constructor completo
     * @param id id del avion
     * @param modelo model del avion
     * @param nAsientos numero de asientos del avion
     * @param velocidadMaxima  velocidad maxima del avion
     */
    public Avion(int id, String modelo, int nAsientos, double velocidadMaxima) {
        this.id = id;
        this.modelo = modelo;
        this.nAsientos = nAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado = false;
    }

    /**
     * Devuelve el id del avion
     * @return id del avion
     */
    public int getId() {
        return id;
    }
    

    /**
     * Devuelve el modelo del avion
     * @return model del avion
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Modifica el modelo del avion
     * @param modelo nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve el numero de asientos
     * @return numero de asientos
     */
    public int getnAsientos() {
        return nAsientos;
    }

    /**
     * Modifica el numero de asientos
     * @param nAsientos nuevo numero de asientos
     */
    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }

    /**
     * Devuelve la velocidad maxima
     * @return velocidad maxima
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Modifica la velocidad maxima
     * @param velocidadMaxima nueva velocidad maxima
     */
    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Indica si el avion esta activado
     * @return a true si esta activado, false si no lo esta
     */
    @Override
    public boolean isActivado() {
        return activado;
    }

    /**
     * Modifca si esta activado o no
     * @param value nueva
     */
    @Override
    public void setActivado(boolean value) {
        this.activado = value;
    }

  
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avion other = (Avion) obj;
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }
    
    

    /**
     * Devuelve la informacion del objeto
     * @return info
     */
    @Override
    public String toString() {
        return "Avion{" + "modelo=" + modelo + ", nAsientos=" + nAsientos + ", velocidadMaxima=" + velocidadMaxima + '}';
    }

}

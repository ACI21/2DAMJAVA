package aeropuertoBD;


import java.io.Serializable;

/**
 * Clase AeropuertoPrivado, heredada de Aeropuerto
 *
 * 
 */
public class AeropuertoPrivado extends Aeropuerto implements Serializable {

    private int numSocios;

    /**
     * Constructor vacio
     */
    public AeropuertoPrivado() {
        super();
    }

    /**
     * Constructor con direccion
     *
     * @param numSocios
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(nombre, direccion, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Constructor con direccion
     *
     * @param numSocios
     * @param id
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, int id, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(id, nombre, direccion, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Constructor completo
     *
     * @param numSocios
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Constructor completo
     *
     * @param numSocios
     * @param id
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPrivado(int numSocios, int id, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(id, nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.numSocios = numSocios;
    }

    /**
     * Devuelve el numero de socios
     *
     * @return numero de socios
     */
    public int getNumSocios() {
        return numSocios;
    }

    /**
     * Modifica el numero de socios
     *
     * @param numSocios nuevo numero de socios
     */
    public void setNumSocios(int numSocios) {
        this.numSocios = numSocios;
    }

    /**
     * Indica las ganancias totales. Muestra lo ganado por cada socio
     *
     * @param cantidad
     * @return
     */
    @Override
    public String gananciasTotales(double cantidad) {

        double ganancia = cantidad / this.numSocios;

        return "La cantidad ganada por cada socio es de " + ganancia;

    }

    /**
     * Devuelve la informacion mas detallada del objeto
     *
     * @return info
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " Es privado y tiene " + numSocios + " socios";
    }

}

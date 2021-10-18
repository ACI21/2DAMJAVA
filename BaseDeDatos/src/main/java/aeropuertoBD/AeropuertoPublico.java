package aeropuertoBD;


import java.io.Serializable;

/**
 * Clase Aeropuerto publico, heredad de Aeropuerto
 *
 * 
 */
public class AeropuertoPublico extends Aeropuerto implements Serializable {

    private double financiacion;
    private int numTrabajadoresDiscapacitados;

    /**
     * Constructor vacio
     */
    public AeropuertoPublico() {
        super();
    }

    /**
     * Constructor con direccion
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(nombre, direccion, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Constructor con direccion
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param id
     * @param nombre
     * @param direccion
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, int id, String nombre, Direccion direccion, int anioInauguracion, int capacidad) {
        super(id, nombre, direccion, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Constructor completo
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Constructor completo
     *
     * @param financiacion
     * @param numTrabajadoresDiscapacitados
     * @param id
     * @param nombre
     * @param pais
     * @param calle
     * @param numero
     * @param ciudad
     * @param anioInauguracion
     * @param capacidad
     */
    public AeropuertoPublico(double financiacion, int numTrabajadoresDiscapacitados, int id, String nombre, String pais, String calle, int numero, String ciudad, int anioInauguracion, int capacidad) {
        super(id, nombre, pais, calle, numero, ciudad, anioInauguracion, capacidad);
        this.financiacion = financiacion;
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Devuelve la financiacion del aeropuerto
     *
     * @return financiacion del aeropuerto
     */
    public double getFinanciacion() {
        return financiacion;
    }

    /**
     * Modifica la financiacion del aeropuerto
     *
     * @param financiacion nueva financiacion
     */
    public void setFinanciacion(double financiacion) {
        this.financiacion = financiacion;
    }

    /**
     * Devuelve el numero de trabajadores discapacitados
     *
     * @return numero de trabajadores discapacitados
     */
    public int getNumTrabajadoresDiscapacitados() {
        return numTrabajadoresDiscapacitados;
    }

    /**
     * Modifica el numero de trabajadores discapacitados
     *
     * @param numTrabajadoresDiscapacitados nuevo numero de trabajadores
     * discapacitados
     */
    public void setNumTrabajadoresDiscapacitados(int numTrabajadoresDiscapacitados) {
        this.numTrabajadoresDiscapacitados = numTrabajadoresDiscapacitados;
    }

    /**
     * Muestra las ganancias totoales del aeropuerto Cantidad ganada +
     * financiacion + (numero de trabajadores discapacitados * 100)
     *
     * @param cantidad
     * @return
     */
    @Override
    public String gananciasTotales(double cantidad) {

        double ganacias = cantidad + financiacion + (numTrabajadoresDiscapacitados * 100);

        return "La ganancia ha sido de " + ganacias;

    }

    /**
     * Devuelve la informacion mas detallada del objeto
     *
     * @return info
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "El aeropuerto es publico y su financiacion por parte del estado es de " + financiacion + " y hay " + numTrabajadoresDiscapacitados + " trabajadores discapacitados";
    }

}

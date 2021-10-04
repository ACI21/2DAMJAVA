/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.Serializable;

public class Titulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5290819710320229241L;
	
	private int anyo;
	private String nombre;

	public Titulo(int anyo, String nombre) {
		this.anyo = anyo;
		this.nombre = nombre;
	}
	
	public int getAnyo() {
		return anyo;
	}
	
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
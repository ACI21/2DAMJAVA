package ejercicioPropuesto4y5;

import java.sql.Date;

public class AsignacionEmpAProyecto {

	String dni;
	int id_proy;
	Date f_inicio, f_fin;

	/**
	 * 
	 */
	public AsignacionEmpAProyecto() {
		super();
		this.dni = "";
		this.id_proy = 0;
		this.f_inicio = null;
		this.f_fin = null;
	}

	/**
	 * @param dni
	 * @paramid_proy
	 * @param f_inicio
	 * @param f_fin
	 */
	public AsignacionEmpAProyecto(String dni, int id_proy, Date f_inicio, Date f_fin) {
		super();
		this.dni = dni;
		this.id_proy = id_proy;
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
	}

	@Override
	public String toString() {
		return "AsignacionEmpAProyecto: [dni=" + dni + ",id_proy=" +id_proy + ", f_inicio=" + f_inicio + ", f_fin="
				+ f_fin + "]";
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return theid_proy
	 */
	public int getId_proy() {
		return id_proy;
	}

	/**
	 * @paramid_proy theid_proy to set
	 */
	public void setId_proy(int id_proy) {
		this.id_proy =id_proy;
	}

	/**
	 * @return the f_inicio
	 */
	public Date getF_inicio() {
		return f_inicio;
	}

	/**
	 * @param f_inicio the f_inicio to set
	 */
	public void setF_inicio(Date f_inicio) {
		this.f_inicio = f_inicio;
	}

	/**
	 * @return the f_fin
	 */
	public Date getF_fin() {
		return f_fin;
	}

	/**
	 * @param f_fin the f_fin to set
	 */
	public void setF_fin(Date f_fin) {
		this.f_fin = f_fin;
	}
}
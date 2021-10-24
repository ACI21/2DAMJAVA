package ejercicioPropuesto4y5;

import java.sql.Date;

public class Proyecto {

	private int id_proy;
	private String nom_proy;
	private Date f_inicio;
	private Date f_fin;
	private String dni_jefe_proy;

	/**
	 * 
	 */
	public Proyecto() {
		super();
		this.id_proy = 0;
		this.nom_proy = "";
		this.f_inicio = null;
		this.f_fin = null;
		this.dni_jefe_proy = "";

	}

	/**
	 * @param id_proy
	 * @param nom_proy
	 * @param f_inicio
	 * @param f_fin
	 * @param dni_jefe_proy
	 */
	public Proyecto(int id_proy, String nom_proy, Date f_inicio, Date f_fin, String dni_jefe_proy) {
		super();
		this.id_proy = id_proy;
		this.nom_proy = nom_proy;
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
		this.dni_jefe_proy = dni_jefe_proy;
	}

	@Override
	public String toString() {
		return "Proyecto:s [id_proy=" + id_proy + ", nom_proy=" + nom_proy + ", f_inicio=" + f_inicio + ", f_fin=" + f_fin
				+ ", dni_jefe_proy=" + dni_jefe_proy + "]";
	}

	/**
	 * @return the id_proy
	 */
	public int getId_proy() {
		return id_proy;
	}

	/**
	 * @param id_proy the id_proy to set
	 */
	public void setId_proy(int id_proy) {
		this.id_proy = id_proy;
	}

	/**
	 * @return the nom_proy
	 */
	public String getNom_proy() {
		return nom_proy;
	}

	/**
	 * @param nom_proy the nom_proy to set
	 */
	public void setNom_proy(String nom_proy) {
		this.nom_proy = nom_proy;
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

	/**
	 * @return the dni_jefe_proy
	 */
	public String getDni_jefe_proy() {
		return dni_jefe_proy;
	}

	/**
	 * @param dni_jefe_proy the dni_jefe_proy to set
	 */
	public void setDni_jefe_proy(String dni_jefe_proy) {
		this.dni_jefe_proy = dni_jefe_proy;
	}

}

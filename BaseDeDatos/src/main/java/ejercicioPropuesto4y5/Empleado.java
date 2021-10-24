package ejercicioPropuesto4y5;

public class Empleado {

	private String dni;
	private String nom_emp;

	public Empleado() {
		this.dni = "";
		this.nom_emp = "";
	}

	/**
	 * @param dni
	 * @param nom_emp
	 */
	public Empleado(String dni, String nom_emp) {
		super();
		this.dni = dni;
		this.nom_emp = nom_emp;
	}

	@Override
	public String toString() {
		return "Empleado: [dni=" + dni + ", nom_emp=" + nom_emp + "]";
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
	 * @return the nom_emp
	 */
	public String getNom_emp() {
		return nom_emp;
	}

	/**
	 * @param nom_emp the nom_emp to set
	 */
	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}

}

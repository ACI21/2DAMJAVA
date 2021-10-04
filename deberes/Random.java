/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

public class Random {

	public static int numeroAleatorioEntreRango(int inicio, int fin) {
		int numero;
		numero = (int) Math.floor(Math.random()*(fin-inicio)+inicio);
		return numero;
	}
}
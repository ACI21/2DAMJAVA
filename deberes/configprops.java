/*
 * Alvaro Carrillo y Roman Shulyak
 */
package deberes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class configprops implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4613114020736383239L;

	public configprops(String config) {

	}

	static void configprops(String plantilla) {

		Properties configuracion = new Properties();

		configuracion.setProperty("Serializar", plantilla);
		try {

			configuracion.store(new FileOutputStream("config.props"), "Fichero de configuración");

		} catch (FileNotFoundException FNFE) {
			FNFE.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	static String leerConfig() {
		Properties configuracion = new Properties();
		String serializar = "";

		try {
			configuracion.load(new FileInputStream("config.props"));

			serializar = configuracion.getProperty("Serializar");

		} catch (FileNotFoundException FNFE) {
			FNFE.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return serializar;
	}
}

package pe.com.claro.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author Jhonny Cisneros
 *
 */
public class RandomUtil {

	private static int multiplicador = 10;

	public static String generarCodigoSMS(int valor) {
		int digit = 1, valueCont = 0, codigo = 0;
		for (int i = 0; i < valor; i++) {
			digit = digit * multiplicador;
		}
		codigo = (int) (Math.random() * digit) + 1;
		do {
			valueCont = contarDigitosCodigoSMS(codigo);
			if (valueCont != valor) {
				codigo = codigo * multiplicador;
			}
		} while (valueCont != valor);

		return String.valueOf(codigo);
	}

	private static int contarDigitosCodigoSMS(int codigo) {
		int cont = 0;
		while (codigo != 0) {
			codigo /= multiplicador;
			++cont;
		}
		return cont;
	}

	public static String generarToken(int valor) {
		return RandomStringUtils.randomAlphanumeric(valor).toUpperCase();
	}
}

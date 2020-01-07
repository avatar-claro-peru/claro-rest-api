package pe.com.claro.util;

/**
 * @author Jhonny Cisneros
 *
 */
public class JsonUtil {

	public static String formatJSON(String jsonInicial) {

		String limpiar1 = jsonInicial.replace("{", "{\"");
		String limpiar2 = limpiar1.replace("=", "\":\"");
		String limpiar3 = limpiar2.replace(",", "\",\"");
		String limpiar4 = limpiar3.replace("}", "\"}");
		String limpiar5 = limpiar4.replace("]\"}", "]}");
		String limpiar6 = limpiar5.replace("\"[{", "[{");
		String limpiar7 = limpiar6.replace("}\",\" {", "},{");
		String limpiar8 = limpiar7.replace("\":\"{", "\":{");
		String limpiar9 = limpiar8.replace("]}\"}", "]}}");
		String jsonFinal = limpiar9.replace(" ", "");
		return jsonFinal;
		
		
		
	}

}

package pe.com.claro.service;

import pe.com.claro.model.Parametro;

/**
 * @author Jhonny Cisneros
 *
 */
public interface ParametroService extends GenericService<Parametro, Integer> {

	Parametro encontrarXNombreParam(String nombreParam);

}

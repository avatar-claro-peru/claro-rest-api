package pe.com.claro.service;

import pe.com.claro.model.Cliente;

/**
 * @author Jhonny Cisneros
 *
 */
public interface ClienteService extends GenericService<Cliente, Integer> {

	Cliente encontrarXNumDoc(String numeroDocumento);

}

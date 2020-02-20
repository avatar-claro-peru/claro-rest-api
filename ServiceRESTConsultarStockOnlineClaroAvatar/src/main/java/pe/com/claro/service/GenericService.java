package pe.com.claro.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jhonny Cisneros
 *
 * @param <Entidad>
 * @param <TipoLlave>
 */
public interface GenericService<Entidad, TipoLlave> extends Serializable {

	Entidad crear(Entidad t);

	Entidad actualizar(Entidad t);

	void eliminar(Entidad t);

	void eliminarXId(TipoLlave id);

	Entidad encontrarXId(TipoLlave id);

	List<Entidad> encontrarTodos();
}

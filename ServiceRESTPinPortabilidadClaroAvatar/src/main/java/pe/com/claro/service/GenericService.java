package pe.com.claro.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jhonny Cisneros
 *
 * @param <T>
 * @param <K>
 */
public interface GenericService<T, K> extends Serializable {

	T crear(T t);

	T actualizar(T t);

	void eliminar(T t);

	void eliminarXId(K id);

	T encontrarXId(K id);

	List<T> encontrarTodos();
}

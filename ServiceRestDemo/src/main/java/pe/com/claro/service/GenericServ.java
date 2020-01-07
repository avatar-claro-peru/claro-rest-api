package pe.com.claro.service;

import java.io.Serializable;
import java.util.List;

public interface GenericServ<Entidad, TipoLlave> extends Serializable {

	Entidad crear(Entidad t) throws Exception;

	Entidad actualizar(Entidad t) throws Exception;

	void eliminar(Entidad t) throws Exception;

	void eliminarXId(TipoLlave id) throws Exception;

	Entidad encontrarXId(TipoLlave id) throws Exception;

	List<Entidad> encontrarTodos() throws Exception;
}

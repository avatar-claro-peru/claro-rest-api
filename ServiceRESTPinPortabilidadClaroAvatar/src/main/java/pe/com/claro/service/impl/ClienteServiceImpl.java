package pe.com.claro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.dao.ClienteDao;
import pe.com.claro.model.Cliente;
import pe.com.claro.service.ClienteService;
import pe.com.claro.util.Constante;

/**
 * @author Jhonny Cisneros
 *
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	private static final String ENTIDAD = "Cliente";

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente crear(Cliente t) throws Exception {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_CREAR + ENTIDAD);
		return clienteDao.save(t);
	}

	@Override
	public Cliente actualizar(Cliente t) throws Exception {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ACTUALIZAR + ENTIDAD);
		return clienteDao.save(t);
	}

	@Override
	public void eliminar(Cliente t) throws Exception {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ELIMINAR + ENTIDAD);
		clienteDao.delete(t);
	}

	@Override
	public void eliminarXId(Integer id) throws Exception {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ELIMINAR_X_ID + ENTIDAD);
		clienteDao.delete(id);
	}

	@Override
	public Cliente encontrarXId(Integer id) throws Exception {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_ID + ENTIDAD);
		return clienteDao.findOne(id);
	}

	@Override
	public List<Cliente> encontrarTodos() throws Exception {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_TODOS + ENTIDAD);
		return clienteDao.findAll();
	}

	@Override
	public Cliente encontrarXParam(String numeroDocumento) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_PARAMETRO + ENTIDAD);
		return clienteDao.findByNumDoc(numeroDocumento);
	}

}

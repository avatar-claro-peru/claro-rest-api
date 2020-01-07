package pe.com.claro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.dao.ClienteDao;
import pe.com.claro.model.Cliente;
import pe.com.claro.service.ClienteService;

/**
 * @author Jhonny Cisneros
 *
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente crear(Cliente t) throws Exception {
		log.info("Inicia lógica para el registro de Cliente...");
		return clienteDao.save(t);
	}

	@Override
	public Cliente actualizar(Cliente t) throws Exception {
		log.info("Inicia lógica para la actualizacion de Cliente...");
		return clienteDao.save(t);
	}

	@Override
	public void eliminar(Cliente t) throws Exception {
		log.info("Inicia lógica para eliminar Cliente...");
		clienteDao.delete(t);
	}

	@Override
	public void eliminarXId(Integer id) throws Exception {
		log.info("Inicia lógica para eliminar por ID Cliente...");
		clienteDao.delete(id);
	}

	@Override
	public Cliente encontrarXId(Integer id) throws Exception {
		log.info("Inicia lógica para encontrar por ID Cliente...");
		return clienteDao.findOne(id);
	}

	@Override
	public List<Cliente> encontrarTodos() throws Exception {
		log.info("Inicia la lógica para encontrar Clientes...");
		return clienteDao.findAll();
	}

	@Override
	public Cliente encontrarXNumDoc(String numeroDocumento) {
		log.info("Inicia la lógica para encontrar Cliente por Numero de Documento...");
		return clienteDao.findByNumDoc(numeroDocumento);
	}

}

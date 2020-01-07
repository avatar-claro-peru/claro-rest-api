package pe.com.claro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.dao.ParametroDao;
import pe.com.claro.model.Parametro;
import pe.com.claro.service.ParametroService;

/**
 * @author Jhonny Cisneros
 *
 */
@Service
public class ParametroServiceImpl implements ParametroService {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(ParametroServiceImpl.class);

	@Autowired
	private ParametroDao parametroDao;

	@Override
	public Parametro crear(Parametro t) throws Exception {
		log.info("Inicia lógica para el registro de Parametro...");
		return parametroDao.save(t);
	}

	@Override
	public Parametro actualizar(Parametro t) throws Exception {
		log.info("Inicia lógica para la actualizacion de Parametro...");
		return parametroDao.save(t);
	}

	@Override
	public void eliminar(Parametro t) throws Exception {
		log.info("Inicia lógica para eliminar Parametro...");
		parametroDao.delete(t);
	}

	@Override
	public void eliminarXId(Integer id) throws Exception {
		log.info("Inicia lógica para eliminar por ID Parametro...");
		parametroDao.delete(id);
	}

	@Override
	public Parametro encontrarXId(Integer id) throws Exception {
		log.info("Inicia lógica para encontrar por ID Parametro...");
		return parametroDao.findOne(id);
	}

	@Override
	public List<Parametro> encontrarTodos() throws Exception {
		log.info("Inicia la lógica para encontrar Parametros...");
		return parametroDao.findAll();
	}

	@Override
	public Parametro encontrarXNombreParam(String nombreParam) {
		log.info("Inicia la lógica para encontrar Parametro por Nombre...");
		return parametroDao.findByNombreParam(nombreParam);
	}

}

package pe.com.claro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.dao.ParametroDao;
import pe.com.claro.model.Parametro;
import pe.com.claro.service.ParametroService;
import pe.com.claro.util.Constante;

/**
 * @author Jhonny Cisneros
 *
 */
@Service
public class ParametroServiceImpl implements ParametroService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ParametroServiceImpl.class);
	private static final String ENTIDAD = "Parametro";

	@Autowired
	private ParametroDao parametroDao;

	@Override
	public Parametro crear(Parametro t) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_CREAR + ENTIDAD);
		return parametroDao.save(t);
	}

	@Override
	public Parametro actualizar(Parametro t) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ACTUALIZAR + ENTIDAD);
		return parametroDao.save(t);
	}

	@Override
	public void eliminar(Parametro t) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ELIMINAR + ENTIDAD);
		parametroDao.delete(t);
	}

	@Override
	public void eliminarXId(Integer id) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ELIMINAR_X_ID + ENTIDAD);
		parametroDao.delete(id);
	}

	@Override
	public Parametro encontrarXId(Integer id) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_ID + ENTIDAD);
		return parametroDao.findOne(id);
	}

	@Override
	public List<Parametro> encontrarTodos() {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_TODOS + ENTIDAD);
		return parametroDao.findAll();
	}

	@Override
	public Parametro encontrarXNombreParam(String nombreParam) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_PARAMETRO
				+ ENTIDAD);
		return parametroDao.findByNombreParam(nombreParam);
	}

}

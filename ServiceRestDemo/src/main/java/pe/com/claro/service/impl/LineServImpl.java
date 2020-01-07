package pe.com.claro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.dao.LineDao;
import pe.com.claro.model.Linea;
import pe.com.claro.service.LineServ;

@Service
public class LineServImpl implements LineServ {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(LineServImpl.class);

	@Autowired
	private LineDao lineaDao;

	@Override
	public Linea crear(Linea t) throws Exception {
		log.info("Inicia la lógica para el registro Linea...");
		return lineaDao.save(t);
	}

	@Override
	public Linea actualizar(Linea t) throws Exception {
		log.info("Inicia la lógica para la actualizacion Linea...");
		return lineaDao.save(t);
	}

	@Override
	public void eliminar(Linea t) throws Exception {
		log.info("Inicia la lógica para eliminar Linea...");
		lineaDao.delete(t);
	}

	@Override
	public void eliminarXId(Integer id) throws Exception {
		log.info("Inicia la lógica para eliminar por ID Linea...");
		lineaDao.delete(id);
	}

	@Override
	public Linea encontrarXId(Integer id) throws Exception {
		log.info("Inicia la lógica para encontrar por ID Linea...");
		return lineaDao.findOne(id);
	}

	@Override
	public List<Linea> encontrarTodos() throws Exception {
		log.info("Inicia la lógica para encontrar Lineas...");
		return lineaDao.findAll();
	}

}

package pe.com.claro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.dao.TrackingStockDao;
import pe.com.claro.model.TrackingStock;
import pe.com.claro.service.TrackingStockService;
import pe.com.claro.util.Constante;

@Service
public class TrackingStockServiceImpl implements TrackingStockService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TrackingStockServiceImpl.class);
	private static final String ENTIDAD = "trackingstock";

	@Autowired
	private TrackingStockDao trackingStockDao;

	@Override
	public TrackingStock crear(TrackingStock t) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_CREAR + ENTIDAD);
		return trackingStockDao.save(t);
	}

	@Override
	public TrackingStock actualizar(TrackingStock t) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ACTUALIZAR + ENTIDAD);
		return trackingStockDao.save(t);
	}

	@Override
	public void eliminar(TrackingStock t) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ELIMINAR + ENTIDAD);
		trackingStockDao.delete(t);

	}

	@Override
	public void eliminarXId(Integer id) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ELIMINAR_X_ID + ENTIDAD);
		trackingStockDao.delete(id);
	}

	@Override
	public TrackingStock encontrarXId(Integer id) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_ID + ENTIDAD);
		return trackingStockDao.findOne(id);
	}

	@Override
	public List<TrackingStock> encontrarTodos() {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_TODOS + ENTIDAD);
		return trackingStockDao.findAll();
	}

	@Override
	public TrackingStock buscarXCodmaterialchip(String codmaterialchip) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_COD_MATERIAL_CHIP
				+ ENTIDAD);
		return trackingStockDao.findByCodmaterialchip(codmaterialchip);
	}

	@Override
	public TrackingStock buscarXCodmaterial(String codmaterial) {
		log.info(Constante.GENERICO.LOG_INICIA_PROCESO_PARA + Constante.GENERICO.LOG_CRUD_ENCONTRAR_X_COD_MATERIAL
				+ ENTIDAD);
		return trackingStockDao.findByCodmaterial(codmaterial);
	}

}
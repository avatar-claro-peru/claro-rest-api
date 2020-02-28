package pe.com.claro.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.claro.domain.RespuestaDomain;
import pe.com.claro.model.TrackingStock;
import pe.com.claro.service.TrackingStockService;
import pe.com.claro.util.Constante;

@RestController
@RequestMapping("/api/trackingstock")
public class TrackingStockController {

	private static final Logger log = LoggerFactory.getLogger(TrackingStockController.class);

	@Autowired
	private TrackingStockService trackingStockService;

	@Autowired
	private Constante constante;

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaDomain> registrar(@RequestBody TrackingStock trackingStock) {
		log.info("Inicia registro TrackingStock.");
		RespuestaDomain respuesta = new RespuestaDomain();
		HttpStatus trackingStockHttp = null;

		if (trackingStock == null || StringUtils.isBlank(trackingStock.getCodigo())) {
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_NO_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_NO_EXITO);
			trackingStockHttp = HttpStatus.CREATED;
			return new ResponseEntity<>(respuesta, trackingStockHttp);
		}
		try {
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_EXITO);
			respuesta.setObjeto(trackingStockService.crear(trackingStock));
			trackingStockHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.MSJ_INTERNAL_SERVER_ERROR(), e.getMessage());
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_NO_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_NO_EXITO);
			trackingStockHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(respuesta, trackingStockHttp);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaDomain> actualizar(@RequestBody TrackingStock trackingStock) {
		log.info("Inicia actualización TrackingStock.");
		RespuestaDomain respuesta = new RespuestaDomain();
		HttpStatus trackingStockHttp = null;

		if (trackingStock == null || StringUtils.isBlank(trackingStock.getCodigo())) {
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_NO_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_NO_EXITO);
			trackingStockHttp = HttpStatus.CREATED;
			return new ResponseEntity<>(respuesta, trackingStockHttp);
		}
		try {
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_EXITO);
			respuesta.setObjeto(trackingStockService.actualizar(trackingStock));
			trackingStockHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.MSJ_INTERNAL_SERVER_ERROR(), e.getMessage());
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_NO_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_NO_EXITO);
			trackingStockHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(respuesta, trackingStockHttp);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaDomain> eliminar(@PathVariable("id") Integer id) {
		log.info("Inicia método eliminación TrackingStockHttp.");
		RespuestaDomain respuesta = new RespuestaDomain();
		HttpStatus trackingStockHttp = null;
		try {
			trackingStockService.eliminarXId(id);
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_EXITO);
			trackingStockHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.MSJ_INTERNAL_SERVER_ERROR(), e.getMessage());
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_NO_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_NO_EXITO);
			trackingStockHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(respuesta, trackingStockHttp);
	}

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TrackingStock>> listar() {
		log.info("Inicia método listar TrackingStock.");
		List<TrackingStock> lstTrackingStock = new ArrayList<>();
		HttpStatus trackingStockHttp = null;
		try {
			lstTrackingStock = trackingStockService.encontrarTodos();
			trackingStockHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.MSJ_INTERNAL_SERVER_ERROR(), e.getMessage());
			trackingStockHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(lstTrackingStock, trackingStockHttp);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrackingStock> listar(@PathVariable("id") Integer id) {
		log.info("Inicia método listar TrackingStock.");
		TrackingStock trackingStock = new TrackingStock();
		HttpStatus trackingStockHttp = null;
		try {
			trackingStock = trackingStockService.encontrarXId(id);
			trackingStockHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.MSJ_INTERNAL_SERVER_ERROR(), e.getMessage());
			trackingStockHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(trackingStock, trackingStockHttp);
	}

	@GetMapping(value = "/buscar/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaDomain> listar(@PathVariable("codigo") String codigo) {
		log.info("Inicia método buscar por codigo TrackingStock.");
		RespuestaDomain respuesta = new RespuestaDomain();
		List<TrackingStock> lstTrackingStock = new ArrayList<>();
		HttpStatus trackingStockHttp = null;

		if (StringUtils.isBlank(codigo)) {
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_NO_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_NO_EXITO);
			trackingStockHttp = HttpStatus.CREATED;
			return new ResponseEntity<>(respuesta, trackingStockHttp);
		}

		try {
			lstTrackingStock = trackingStockService.buscarXCodigo(codigo);
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_EXITO);
			respuesta.setObjeto(lstTrackingStock);
			trackingStockHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.MSJ_INTERNAL_SERVER_ERROR(), e.getMessage());
			respuesta.setCodigo(Constante.GENERICO.COD_RESPUESTA_NO_EXITO);
			respuesta.setMensaje(Constante.GENERICO.MSJ_RESPUESTA_NO_EXITO);
			trackingStockHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(respuesta, trackingStockHttp);
	}

}

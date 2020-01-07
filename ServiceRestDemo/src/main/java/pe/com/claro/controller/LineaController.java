package pe.com.claro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.claro.domain.RespuestaDomain;
import pe.com.claro.model.Linea;
import pe.com.claro.service.LineServ;
import pe.com.claro.util.Constante;

@RestController
@RequestMapping("/api/linea")
public class LineaController {

	private static final Logger log = LoggerFactory.getLogger(LineaController.class);

	@Autowired
	private LineServ lineaService;

	@Autowired
	private Constante constante;

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaDomain> eliminar(@PathVariable("id") Integer id) {
		log.info("Inicia método eliminación Linea.");
		RespuestaDomain respuesta = new RespuestaDomain();
		HttpStatus estadoHttp = null;
		try {
			lineaService.eliminarXId(id);
			respuesta.setCodigo(Constante.CODIGO.IDF0_GENERAR_CODIGO_EXITO);
			respuesta.setMensaje(constante.IDF0_GENERAR_CODIGO_EXITO());
			estadoHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.IDT1_GENERAR_CODIGO_ERROR(), e.getMessage());
			respuesta.setCodigo(Constante.CODIGO.IDT1_GENERAR_CODIGO_ERROR);
			respuesta.setMensaje(constante.IDT1_GENERAR_CODIGO_ERROR());
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(respuesta, estadoHttp);
	}

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Linea>> listar() {
		log.info("Inicia método listar Lineas.");
		List<Linea> lstLineas = new ArrayList<>();
		HttpStatus estadoHttp = null;
		try {
			lstLineas = lineaService.encontrarTodos();
			estadoHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.IDT1_GENERAR_CODIGO_ERROR(), e.getMessage());
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(lstLineas, estadoHttp);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Linea> listar(@PathVariable("id") Integer id) {
		log.info("Inicia método listar Lineas.");
		Linea linea = new Linea();
		HttpStatus estadoHttp = null;
		try {
			linea = lineaService.encontrarXId(id);
			estadoHttp = HttpStatus.OK;
		} catch (Exception e) {
			log.error(constante.IDT1_GENERAR_CODIGO_ERROR(), e.getMessage());
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(linea, estadoHttp);
	}

}

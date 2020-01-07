package pe.com.claro.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.claro.bean.BodyRequestConsultarStockOnline;
import pe.com.claro.bean.BodyResponseConsultarStockOnline;
import pe.com.claro.bean.DataConsultarStockOnline;
import pe.com.claro.bean.HeaderRequestConsultarStockOnline;
import pe.com.claro.bean.HeaderResponse;
import pe.com.claro.bean.HeaderResponseConsultarStockOnline;
import pe.com.claro.bean.MessageResponse;
import pe.com.claro.bean.Request;
import pe.com.claro.bean.Response;
import pe.com.claro.domain.ResponseStatus;
import pe.com.claro.service.ParametroService;
import pe.com.claro.util.Constante;
import pe.com.claro.util.JsonUtil;

/**
 * @author Jhonny Cisneros
 *
 */
@RestController
@RequestMapping("/v1.0/postventa/customer_Domain/custInfo/bssFinalizaVenta")
public class ApiRest {

	private static final Logger log = LoggerFactory.getLogger(ApiRest.class);

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private Constante constante;

	@PostMapping(value = "/consultarStockOnline", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> consultarStockOnline(@RequestBody Request request) {
		String METHOD_NAME = "Capa RestController - {consultarStockOnline} ";
		log.info(METHOD_NAME + "Inicia API REST.");
		Response response = new Response();
		HttpStatus estadoHttp = HttpStatus.CREATED;

		MessageResponse messageResponse = new MessageResponse();
		HeaderResponse headerResponse = new HeaderResponse();
		HeaderResponseConsultarStockOnline headerResponseConsultarStockOnline = new HeaderResponseConsultarStockOnline();
		BodyResponseConsultarStockOnline bodyResponseConsultarStockOnline = new BodyResponseConsultarStockOnline();
		ResponseStatus responseStatus = new ResponseStatus();
		DataConsultarStockOnline data = new DataConsultarStockOnline();

		HeaderRequestConsultarStockOnline headerRequest = new HeaderRequestConsultarStockOnline();
		BodyRequestConsultarStockOnline bodyRequest = new BodyRequestConsultarStockOnline();
		log.info(METHOD_NAME + "Se valida la data ingresada en el REQUEST.");
		if (request == null || request.getMessageRequest() == null || request.getMessageRequest().getHeader() == null
				|| request.getMessageRequest().getHeader().getHeaderRequest() == null
				|| request.getMessageRequest().getBody() == null) {
			estadoHttp = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<>(response, estadoHttp);
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			headerRequest = mapper.readValue(
					JsonUtil.formatJSON(request.getMessageRequest().getHeader().getHeaderRequest().toString()),
					HeaderRequestConsultarStockOnline.class);
			mapper = new ObjectMapper();
			bodyRequest = mapper.readValue(JsonUtil.formatJSON(request.getMessageRequest().getBody().toString()),
					BodyRequestConsultarStockOnline.class);

		} catch (IOException e) {
			log.error(constante.IDT1_CONSULTAR_STOCK_ONLINE_ERROR() + e.getMessage());
			responseStatus.setCodeResponse(Constante.CODIGO.IDT1_CONSULTAR_STOCK_ONLINE_ERROR);
			responseStatus.setDescriptionResponse(constante.IDT1_CONSULTAR_STOCK_ONLINE_ERROR());
			bodyResponseConsultarStockOnline.setResponseStatus(responseStatus);
			bodyResponseConsultarStockOnline.setResponseDataConsultaStockOnline(data);
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponseConsultarStockOnline);
			response.setMessageResponse(messageResponse);
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		log.info(METHOD_NAME + "Se valida la data ingresada en el HEADER del request.");
		if (headerRequest == null) {
			headerResponse.setHeaderResponse(headerResponseConsultarStockOnline);
			responseStatus.setCodeResponse(Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO);
			responseStatus.setDescriptionResponse(constante.IDF1_CONSULTAR_STOCK_ONLINE_NO_HEADER_CORRECTO());
			bodyResponseConsultarStockOnline.setResponseStatus(responseStatus);
			bodyResponseConsultarStockOnline.setResponseDataConsultaStockOnline(data);
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponseConsultarStockOnline);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}
		log.info(METHOD_NAME + "Se valida la data ingresada en el BODY del request.");
		if (bodyRequest == null || StringUtils.isBlank(bodyRequest.getCodMaterial())
				|| StringUtils.isBlank(bodyRequest.getCodMaterialChip()) || StringUtils.isBlank(bodyRequest.getCodPDV())
				|| StringUtils.isBlank(bodyRequest.getCodCentro())
				|| StringUtils.isBlank(bodyRequest.getCodAlmacen())) {
			headerResponse.setHeaderResponse(headerResponseConsultarStockOnline);
			responseStatus.setCodeResponse(Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO);
			responseStatus.setDescriptionResponse(constante.IDF2_CONSULTAR_STOCK_ONLINE_NO_REQUEST_CORRECTO());
			bodyResponseConsultarStockOnline.setResponseStatus(responseStatus);
			bodyResponseConsultarStockOnline.setResponseDataConsultaStockOnline(data);
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponseConsultarStockOnline);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}

		try {
			int stockMaterial = Integer.valueOf(parametroService
					.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_CANTIDAD_INVENTARIO_MATERIAL)
					.getValorParam());
			int stockChip = Integer.valueOf(parametroService
					.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_CANTIDAD_INVENTARIO_CHIP).getValorParam());

			if (stockMaterial <= 0 && stockChip <= 0) {
				responseStatus.setCodeResponse(Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO);
				responseStatus.setDescriptionResponse(constante.IDF3_CONSULTAR_STOCK_ONLINE_NO_EXITO());
				data.setNroLog(Constante.CODIGO.IDF3_CONSULTAR_STOCK_ONLINE_NRO_LOG_SIN_EXITO);
				data.setDesLog(constante.IDF5_CONSULTAR_STOCK_ONLINE_SIN_STOCK());
				data.setSerieDisEquipo(String.valueOf(stockMaterial));
				data.setSerieDisChip(String.valueOf(stockChip));
				estadoHttp = HttpStatus.CREATED;
				log.info(METHOD_NAME + responseStatus.getDescriptionResponse());
			
			} else if(stockMaterial <= 0) {
				responseStatus.setCodeResponse(Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO);
				responseStatus.setDescriptionResponse(constante.IDF6_CONSULTAR_STOCK_ONLINE_SIN_STOCK_MATERIAL());
				data.setNroLog(Constante.CODIGO.IDF3_CONSULTAR_STOCK_ONLINE_NRO_LOG_SIN_EXITO);
				data.setDesLog(constante.IDF6_CONSULTAR_STOCK_ONLINE_SIN_STOCK_MATERIAL());
				data.setSerieDisEquipo(String.valueOf(stockMaterial));
				data.setSerieDisChip(String.valueOf(stockChip));
				estadoHttp = HttpStatus.CREATED;
				log.info(METHOD_NAME + responseStatus.getDescriptionResponse());
			} else if(stockChip <= 0) {
				responseStatus.setCodeResponse(Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO);
				responseStatus.setDescriptionResponse(constante.IDF7_CONSULTAR_STOCK_ONLINE_SIN_STOCK_CHIP());
				data.setNroLog(Constante.CODIGO.IDF3_CONSULTAR_STOCK_ONLINE_NRO_LOG_SIN_EXITO);
				data.setDesLog(constante.IDF7_CONSULTAR_STOCK_ONLINE_SIN_STOCK_CHIP());
				data.setSerieDisEquipo(String.valueOf(stockMaterial));
				data.setSerieDisChip(String.valueOf(stockChip));
				estadoHttp = HttpStatus.CREATED;
				log.info(METHOD_NAME + responseStatus.getDescriptionResponse());
			} else {
				responseStatus.setCodeResponse(Constante.CODIGO.IDF2_CONSULTAR_STOCK_ONLINE_NRO_LOG_EXITO);
				responseStatus.setDescriptionResponse(constante.IDF4_CONSULTAR_STOCK_ONLINE_CON_STOCK());
				data.setNroLog(Constante.CODIGO.IDF2_CONSULTAR_STOCK_ONLINE_NRO_LOG_EXITO);
				data.setDesLog(constante.IDF4_CONSULTAR_STOCK_ONLINE_CON_STOCK());
				data.setSerieDisEquipo(String.valueOf(stockMaterial));
				data.setSerieDisChip(String.valueOf(stockChip));
				estadoHttp = HttpStatus.OK;
				log.info(METHOD_NAME + responseStatus.getDescriptionResponse());
			}
				
			log.info(METHOD_NAME + "Termina API REST.");
		} catch (Exception e) {
			log.error(constante.IDT1_CONSULTAR_STOCK_ONLINE_ERROR() + e.getMessage());
			responseStatus.setCodeResponse(Constante.CODIGO.IDT1_CONSULTAR_STOCK_ONLINE_ERROR);
			responseStatus.setDescriptionResponse(constante.IDT1_CONSULTAR_STOCK_ONLINE_ERROR());
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		headerResponse.setHeaderResponse(headerResponseConsultarStockOnline);
		bodyResponseConsultarStockOnline.setResponseStatus(responseStatus);
		bodyResponseConsultarStockOnline.setResponseDataConsultaStockOnline(data);
		messageResponse.setHeader(headerResponse);
		messageResponse.setBody(bodyResponseConsultarStockOnline);
		response.setMessageResponse(messageResponse);
		return new ResponseEntity<>(response, estadoHttp);
	}

}

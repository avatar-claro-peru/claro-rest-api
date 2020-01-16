package pe.com.claro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import pe.com.claro.domain.ErrorDetails;
import pe.com.claro.domain.ListaOpcionalesDomain;
import pe.com.claro.domain.ResponseOpcional;
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

		HeaderRequestConsultarStockOnline headerRequest = new HeaderRequestConsultarStockOnline();
		BodyRequestConsultarStockOnline bodyRequest = new BodyRequestConsultarStockOnline();

		int stockMaterial = 0;
		int stockChip = 0;

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

			bodyResponseConsultarStockOnline = getBodyResponse(Constante.CODIGO.IDT1_CONSULTAR_STOCK_ONLINE_ERROR,
					constante.IDT1_CONSULTAR_STOCK_ONLINE_ERROR(), Constante.PARAMETRO.GENERICO_VACIO,
					Constante.PARAMETRO.GENERICO_VACIO, stockMaterial, stockChip, METHOD_NAME);

			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponseConsultarStockOnline);
			response.setMessageResponse(messageResponse);
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		log.info(METHOD_NAME + "Se valida la data ingresada en el HEADER del request.");
		if (headerRequest == null) {
			headerResponse.setHeaderResponse(headerResponseConsultarStockOnline);

			bodyResponseConsultarStockOnline = getBodyResponse(Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO,
					constante.IDF1_CONSULTAR_STOCK_ONLINE_NO_HEADER_CORRECTO(), Constante.PARAMETRO.GENERICO_VACIO,
					Constante.PARAMETRO.GENERICO_VACIO, stockMaterial, stockChip, METHOD_NAME);

			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponseConsultarStockOnline);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}
		log.info(METHOD_NAME + "Se valida la data ingresada en el BODY del request.");
		if (bodyRequest == null || StringUtils.isBlank(bodyRequest.getCodMaterial())
				|| StringUtils.isBlank(bodyRequest.getCodPDV()) || StringUtils.isBlank(bodyRequest.getCodCentro())
				|| StringUtils.isBlank(bodyRequest.getCodAlmacen())) {
			headerResponse.setHeaderResponse(headerResponseConsultarStockOnline);

			bodyResponseConsultarStockOnline = getBodyResponse(Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO,
					constante.IDF2_CONSULTAR_STOCK_ONLINE_NO_REQUEST_CORRECTO(), Constante.PARAMETRO.GENERICO_VACIO,
					Constante.PARAMETRO.GENERICO_VACIO, stockMaterial, stockChip, METHOD_NAME);

			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponseConsultarStockOnline);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}

		try {

			if (StringUtils.isNotBlank(bodyRequest.getCodMaterial())) {
				stockMaterial = Integer.valueOf(parametroService
						.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_CANTIDAD_INVENTARIO_MATERIAL)
						.getValorParam());
			}

			if (StringUtils.isNotBlank(bodyRequest.getCodMaterialChip())) {
				stockChip = Integer.valueOf(parametroService
						.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_CANTIDAD_INVENTARIO_CHIP)
						.getValorParam());
			}

			if (stockMaterial <= 0 && stockChip <= 0) {
				bodyResponseConsultarStockOnline = getBodyResponse(
						Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO,
						constante.IDF3_CONSULTAR_STOCK_ONLINE_NO_EXITO(),
						Constante.CODIGO.IDF3_CONSULTAR_STOCK_ONLINE_NRO_LOG_SIN_EXITO,
						constante.IDF5_CONSULTAR_STOCK_ONLINE_SIN_STOCK(), stockMaterial, stockChip, METHOD_NAME);
			} else if (stockMaterial <= 0) {
				bodyResponseConsultarStockOnline = getBodyResponse(
						Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO,
						constante.IDF6_CONSULTAR_STOCK_ONLINE_SIN_STOCK_MATERIAL(),
						Constante.CODIGO.IDF3_CONSULTAR_STOCK_ONLINE_NRO_LOG_SIN_EXITO,
						constante.IDF6_CONSULTAR_STOCK_ONLINE_SIN_STOCK_MATERIAL(), stockMaterial, stockChip,
						METHOD_NAME);
			} else if (stockChip <= 0) {
				bodyResponseConsultarStockOnline = getBodyResponse(
						Constante.CODIGO.IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO,
						constante.IDF7_CONSULTAR_STOCK_ONLINE_SIN_STOCK_CHIP(),
						Constante.CODIGO.IDF3_CONSULTAR_STOCK_ONLINE_NRO_LOG_SIN_EXITO,
						constante.IDF7_CONSULTAR_STOCK_ONLINE_SIN_STOCK_CHIP(), stockMaterial, stockChip, METHOD_NAME);
			} else {
				bodyResponseConsultarStockOnline = getBodyResponse(
						Constante.CODIGO.IDF2_CONSULTAR_STOCK_ONLINE_NRO_LOG_EXITO,
						constante.IDF4_CONSULTAR_STOCK_ONLINE_CON_STOCK(),
						Constante.CODIGO.IDF2_CONSULTAR_STOCK_ONLINE_NRO_LOG_EXITO,
						constante.IDF4_CONSULTAR_STOCK_ONLINE_CON_STOCK(), stockMaterial, stockChip, METHOD_NAME);
				estadoHttp = HttpStatus.OK;
			}
			log.info(METHOD_NAME + "Termina API REST.");
		} catch (Exception e) {
			log.error(constante.IDT1_CONSULTAR_STOCK_ONLINE_ERROR() + e.getMessage());
			bodyResponseConsultarStockOnline = getBodyResponse(Constante.CODIGO.IDT1_CONSULTAR_STOCK_ONLINE_ERROR,
					constante.IDT1_CONSULTAR_STOCK_ONLINE_ERROR(), Constante.PARAMETRO.GENERICO_VACIO,
					Constante.PARAMETRO.GENERICO_VACIO, stockMaterial, stockChip, METHOD_NAME);
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		headerResponse.setHeaderResponse(headerResponseConsultarStockOnline);
		messageResponse.setHeader(headerResponse);
		messageResponse.setBody(bodyResponseConsultarStockOnline);
		response.setMessageResponse(messageResponse);
		return new ResponseEntity<>(response, estadoHttp);
	}

	private BodyResponseConsultarStockOnline getBodyResponse(String codeResponse, String descriptionResponse,
			String nroLog, String desLog, int stockMaterial, int stockChip, String methodName) {

		BodyResponseConsultarStockOnline bodyResponseConsultarStockOnline = new BodyResponseConsultarStockOnline();
		ResponseStatus responseStatus = new ResponseStatus();
		List<ErrorDetails> lstErrorDetails = new ArrayList<ErrorDetails>();
		DataConsultarStockOnline data = new DataConsultarStockOnline();
		List<ListaOpcionalesDomain> lstOpcionalesDomain = new ArrayList<ListaOpcionalesDomain>();

		responseStatus.setCodeResponse(codeResponse);
		responseStatus.setDescriptionResponse(descriptionResponse);

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(Constante.PARAMETRO.GENERICO_VACIO);
		errorDetails.setErrorDescription(Constante.PARAMETRO.GENERICO_VACIO);
		lstErrorDetails.add(errorDetails);
		responseStatus.setErrorDetails(lstErrorDetails);

		ListaOpcionalesDomain listaOpcionalesDomain = new ListaOpcionalesDomain();
		listaOpcionalesDomain.setClave(Constante.PARAMETRO.GENERICO_VACIO);
		listaOpcionalesDomain.setValor(Constante.PARAMETRO.GENERICO_VACIO);
		lstOpcionalesDomain.add(listaOpcionalesDomain);

		ResponseOpcional responseOpcional = new ResponseOpcional();
		responseOpcional.setResponseOpcional(lstOpcionalesDomain);
		data.setListaAdicionalResponse(responseOpcional);

		data.setNroLog(nroLog);
		data.setDesLog(desLog);
		data.setSerieDisEquipo(String.valueOf(stockMaterial));
		data.setSerieDisChip(String.valueOf(stockChip));

		bodyResponseConsultarStockOnline.setResponseStatus(responseStatus);
		bodyResponseConsultarStockOnline.setResponseDataConsultaStockOnline(data);

		log.info(methodName + responseStatus.getDescriptionResponse());
		return bodyResponseConsultarStockOnline;
	}

}

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

import pe.com.claro.bean.BodyRequestGenerarCodigo;
import pe.com.claro.bean.BodyRequestValidarCodigo;
import pe.com.claro.bean.BodyResponseGenerarCodigo;
import pe.com.claro.bean.BodyResponseValidarCodigo;
import pe.com.claro.bean.DataGenerarCodigo;
import pe.com.claro.bean.HeaderRequestGenerarCodigo;
import pe.com.claro.bean.HeaderRequestValidarCodigo;
import pe.com.claro.bean.HeaderResponse;
import pe.com.claro.bean.HeaderResponseGenerarCodigo;
import pe.com.claro.bean.HeaderResponseValidarCodigo;
import pe.com.claro.bean.MessageResponse;
import pe.com.claro.bean.Request;
import pe.com.claro.bean.Response;
import pe.com.claro.domain.ListaOpcionalesDomain;
import pe.com.claro.domain.RespuestaDomain;
import pe.com.claro.model.Cliente;
import pe.com.claro.model.Solicitud;
import pe.com.claro.service.ClienteService;
import pe.com.claro.service.ParametroService;
import pe.com.claro.service.SolicitudService;
import pe.com.claro.util.Constante;
import pe.com.claro.util.JsonUtil;

/**
 * @author Jhonny Cisneros
 *
 */
@RestController
@RequestMapping("/v1.0/ventas/customer_Domain/billFormat/claroventaautenticasmsbio")
public class ApiRest {

	private static final Logger log = LoggerFactory.getLogger(ApiRest.class);

	@Autowired
	private SolicitudService solicitudService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private Constante constante;

	@PostMapping(value = "/generarCodigo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> generarCodigo(@RequestBody Request request) {
		String METHOD_NAME = "Capa RestController  - {generarCodigo} ";
		log.info(METHOD_NAME , "Inicia API REST.");
		Response response = new Response();
		HttpStatus estadoHttp = HttpStatus.CREATED;
		RespuestaDomain codigoSMSGenerado = new RespuestaDomain();
		RespuestaDomain rptaValidarIntentos = new RespuestaDomain();
		Solicitud solicitudCreada = new Solicitud();

		boolean esFlagEnvioSMS = false;
		boolean seValidoNroIntentos = false;
		boolean seValidoExisteCliente = false;
		boolean seGeneroCodigoSMS = false;
		boolean SeEnvioSMS = false;

		MessageResponse messageResponse = new MessageResponse();
		HeaderResponse headerResponse = new HeaderResponse();
		HeaderResponseGenerarCodigo headerResponseGenerarCodigo = new HeaderResponseGenerarCodigo();
		BodyResponseGenerarCodigo bodyResponse = new BodyResponseGenerarCodigo();

		HeaderRequestGenerarCodigo headerRequest = new HeaderRequestGenerarCodigo();
		BodyRequestGenerarCodigo bodyRequest = new BodyRequestGenerarCodigo();
		log.info(METHOD_NAME , "Se valida la data ingresada en el REQUEST.");
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
					HeaderRequestGenerarCodigo.class);
			mapper = new ObjectMapper();
			bodyRequest = mapper.readValue(JsonUtil.formatJSON(request.getMessageRequest().getBody().toString()),
					BodyRequestGenerarCodigo.class);

		} catch (IOException e) {
			log.error(constante.IDT1_GENERAR_CODIGO_ERROR() , e.getMessage());
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDT1_GENERAR_CODIGO_ERROR);
			bodyResponse.setMensajeRespuesta(constante.IDT1_GENERAR_CODIGO_ERROR());
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponse);
			response.setMessageResponse(messageResponse);
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		log.info(METHOD_NAME , "Se valida la data ingresada en el HEADER del request.");
		if (headerRequest == null) {
			headerResponse.setHeaderResponse(headerResponseGenerarCodigo);
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF2_GENERAR_CODIGO_NO_HEADER_CORRECTO);
			bodyResponse.setMensajeRespuesta(constante.IDF2_GENERAR_CODIGO_NO_HEADER_CORRECTO());
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponse);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}
		log.info(METHOD_NAME , "Se valida la data ingresada en el BODY del request.");
		if (bodyRequest == null || StringUtils.isBlank(bodyRequest.getFlagEnvioSMS())
				|| StringUtils.isBlank(bodyRequest.getFlagSMSIndico()) || StringUtils.isBlank(bodyRequest.getLinea())
				|| StringUtils.isBlank(bodyRequest.getNumeroDocumento())) {
			headerResponse.setHeaderResponse(headerResponseGenerarCodigo);
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF3_GENERAR_CODIGO_NO_REQUEST_CORRECTO);
			bodyResponse.setMensajeRespuesta(constante.IDF3_GENERAR_CODIGO_NO_REQUEST_CORRECTO());
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponse);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}

		try {
			/** Se valida que el flagEnvioSMS = 1 */
			if (Constante.PARAMETRO.FLAG_ENVIO_SMS.equalsIgnoreCase(bodyRequest.getFlagEnvioSMS())) {
				esFlagEnvioSMS = true;
				log.info(METHOD_NAME , "Se valido con exitoso que el flagEnvioSMS = 1.");

				/** Se valida el numero de intentos */
				rptaValidarIntentos = solicitudService.validarIntentos(bodyRequest);
				if (Constante.PARAMETRO.GENERAR_CODIGO_VALIDAR_INTENTOS_EXITO
						.equalsIgnoreCase(rptaValidarIntentos.getCodigo())) {
					seValidoNroIntentos = true;
					log.info(METHOD_NAME , "Se valido con exitoso el numero de intentos.");

					/** Se valida si existe el cliente */
					Cliente cliente = clienteService.encontrarXNumDoc(bodyRequest.getNumeroDocumento());
					if (cliente != null) {
						seValidoExisteCliente = true;
						log.info(METHOD_NAME , "Se valido con exitoso que el cliente: " , cliente.getNombre()
								, " con nro de documento: " , cliente.getNumDoc() , " exista.");

						/** Se genera el codigo SMS */
						codigoSMSGenerado = solicitudService.generarCodigo(bodyRequest, cliente);
						if (Constante.CODIGO.IDF0_GENERAR_CODIGO_EXITO
								.equalsIgnoreCase(codigoSMSGenerado.getCodigo())) {
							seGeneroCodigoSMS = true;
							solicitudCreada = (Solicitud) codigoSMSGenerado.getObjeto();
							log.info(METHOD_NAME , "Se genero el siguiente token: "+solicitudCreada.getToken());
							log.info(METHOD_NAME , "Se genero el siguiente codigo SMS: "+solicitudCreada.getCodigoSMS());

							/** Se valida que el flagEnvioSMSIndico = 1 */
							RespuestaDomain rptaEnvioCodigoSMS = new RespuestaDomain();
							if (Constante.PARAMETRO.FLAG_ENVIO_SMS_INDICO
									.equalsIgnoreCase(bodyRequest.getFlagSMSIndico())) {
								/** Se envia el codigo SMS */
								rptaEnvioCodigoSMS = solicitudService.enviarSMSIndico(bodyRequest);
							} else {
								rptaEnvioCodigoSMS = solicitudService.enviarSMS(bodyRequest);
							}

							if (Constante.PARAMETRO.GENERAR_CODIGO_ENVIAR_CODIGO_SMS_EXITO
									.equalsIgnoreCase(rptaEnvioCodigoSMS.getCodigo())) {
								SeEnvioSMS = true;
							}
						}
					}

				}
			}

			if (esFlagEnvioSMS && seValidoNroIntentos && seValidoExisteCliente && seGeneroCodigoSMS && SeEnvioSMS) {
				bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF0_GENERAR_CODIGO_EXITO);
				bodyResponse.setMensajeRespuesta(constante.IDF0_GENERAR_CODIGO_EXITO());
				DataGenerarCodigo data = new DataGenerarCodigo();
				data.setEnvioSMS(solicitudCreada.getToken());
				data.setNumeroIntentos(Integer.valueOf(parametroService
						.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_KEY_CANTIDAD_MAXIMA_INTENTOS)
						.getValorParam()));
				data.setNumeroReintentos(Integer.parseInt(rptaValidarIntentos.getValor()));
				data.setTiempoVentanaModal(Integer.valueOf(parametroService
						.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_KEY_TIEMPO_VENTANA_MODAL)
						.getValorParam()));
				List<ListaOpcionalesDomain> lstOpcionales = new ArrayList<ListaOpcionalesDomain>();
				ListaOpcionalesDomain lst = new ListaOpcionalesDomain();
				lst.setClave(Constante.PARAMETRO.CANTIDAD_DIGITOS);
				lst.setValor(parametroService
						.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_KEY_CANTIDAD_DIGITOS).getValorParam());
				lstOpcionales.add(lst);
				data.setListaOpcionales(lstOpcionales);
				bodyResponse.setData(data);
				estadoHttp = HttpStatus.OK;
				log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
			} else {
				if (!esFlagEnvioSMS) {
					bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF4_GENERAR_CODIGO_NO_FLAG_ENVIO_SMS);
					bodyResponse.setMensajeRespuesta(constante.IDF4_GENERAR_CODIGO_NO_FLAG_ENVIO_SMS());
					log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
				} else if (!seValidoNroIntentos) {
					bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF1_GENERAR_CODIGO_NO_VALIDO_NRO_INTENTOS);
					bodyResponse.setMensajeRespuesta(constante.IDF1_GENERAR_CODIGO_NO_VALIDO_NRO_INTENTOS());
					log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
				} else if (!seValidoExisteCliente) {
					bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF6_GENERAR_CODIGO_NO_EXISTE_CLIENTE);
					bodyResponse.setMensajeRespuesta(constante.IDF6_GENERAR_CODIGO_NO_EXISTE_CLIENTE());
					log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
				} else if (!seGeneroCodigoSMS) {
					bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF7_GENERAR_CODIGO_NO_GENERO_CODIGO_SMS);
					bodyResponse.setMensajeRespuesta(constante.IDF7_GENERAR_CODIGO_NO_GENERO_CODIGO_SMS());
					log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
				} else if (!SeEnvioSMS) {
					bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF5_GENERAR_CODIGO_NO_ENVIO_SMS);
					bodyResponse.setMensajeRespuesta(constante.IDF5_GENERAR_CODIGO_NO_ENVIO_SMS());
					log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
				}
				estadoHttp = HttpStatus.CREATED;
			}
			log.info(METHOD_NAME , "Termina API REST.");

		} catch (Exception e) {
			log.error(constante.IDT1_GENERAR_CODIGO_ERROR() , e.getMessage());
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDT1_GENERAR_CODIGO_ERROR);
			bodyResponse.setMensajeRespuesta(constante.IDT1_GENERAR_CODIGO_ERROR());
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		headerResponse.setHeaderResponse(headerResponseGenerarCodigo);
		messageResponse.setHeader(headerResponse);
		messageResponse.setBody(bodyResponse);
		response.setMessageResponse(messageResponse);
		return new ResponseEntity<>(response, estadoHttp);
	}

	@PostMapping(value = "/validarCodigo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> validarCodigo(@RequestBody Request request) {
		String METHOD_NAME = "Capa RestController - {validarCodigo} ";
		log.info(METHOD_NAME , "Inicia API REST.");
		Response response = new Response();
		HttpStatus estadoHttp = HttpStatus.CREATED;
		RespuestaDomain codigoValidado = new RespuestaDomain();

		MessageResponse messageResponse = new MessageResponse();
		HeaderResponse headerResponse = new HeaderResponse();
		HeaderResponseValidarCodigo headerResponseGenerarCodigo = new HeaderResponseValidarCodigo();
		BodyResponseValidarCodigo bodyResponse = new BodyResponseValidarCodigo();

		HeaderRequestValidarCodigo headerRequest = new HeaderRequestValidarCodigo();
		BodyRequestValidarCodigo bodyRequest = new BodyRequestValidarCodigo();
		log.info(METHOD_NAME , "Se valida la data ingresada en el REQUEST.");
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
					HeaderRequestValidarCodigo.class);
			mapper = new ObjectMapper();
			bodyRequest = mapper.readValue(JsonUtil.formatJSON(request.getMessageRequest().getBody().toString()),
					BodyRequestValidarCodigo.class);

		} catch (IOException e) {
			log.error(constante.IDT1_GENERAR_CODIGO_ERROR() , e.getMessage());
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDT1_VALIDAR_CODIGO_ERROR);
			bodyResponse.setMensajeRespuesta(constante.IDT1_VALIDAR_CODIGO_ERROR());
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponse);
			response.setMessageResponse(messageResponse);
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		log.info(METHOD_NAME , "Se valida la data ingresada en el HEADER del request.");
		if (headerRequest == null) {
			headerResponse.setHeaderResponse(headerResponseGenerarCodigo);
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF2_VALIDAR_CODIGO_NO_HEADER_CORRECTO);
			bodyResponse.setMensajeRespuesta(constante.IDF2_VALIDAR_CODIGO_NO_HEADER_CORRECTO());
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponse);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}
		log.info(METHOD_NAME , "Se valida la data ingresada en el BODY del request.");
		if (bodyRequest == null || StringUtils.isBlank(bodyRequest.getCodigo())
				|| StringUtils.isBlank(bodyRequest.getEnvioSMS())) {
			headerResponse.setHeaderResponse(headerResponseGenerarCodigo);
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF3_VALIDAR_CODIGO_NO_REQUEST_CORRECTO);
			bodyResponse.setMensajeRespuesta(constante.IDF3_VALIDAR_CODIGO_NO_REQUEST_CORRECTO());
			messageResponse.setHeader(headerResponse);
			messageResponse.setBody(bodyResponse);
			response.setMessageResponse(messageResponse);
			return new ResponseEntity<>(response, estadoHttp);
		}

		try {
			codigoValidado = solicitudService.validarCodigo(bodyRequest);
			if (Constante.CODIGO.IDF0_VALIDAR_CODIGO_EXITO.equalsIgnoreCase(codigoValidado.getCodigo())) {
				bodyResponse.setCodigoRespuesta(codigoValidado.getCodigo());
				bodyResponse.setMensajeRespuesta(constante.IDF0_VALIDAR_CODIGO_EXITO());
				estadoHttp = HttpStatus.OK;
				log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
			} else if (Constante.CODIGO.IDF1_VALIDAR_CODIGO_CANTIDAD_INTENTOS_SUPERADO
					.equalsIgnoreCase(codigoValidado.getCodigo())) {
				bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDF1_VALIDAR_CODIGO_CANTIDAD_INTENTOS_SUPERADO);
				bodyResponse.setMensajeRespuesta(constante.IDF1_VALIDAR_CODIGO_CANTIDAD_INTENTOS_SUPERADO());
				estadoHttp = HttpStatus.CREATED;
				log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
			} else if (Constante.CODIGO.IDF4_VALIDAR_CODIGO_NO_EXITO.equalsIgnoreCase(codigoValidado.getCodigo())) {
				bodyResponse.setCodigoRespuesta(codigoValidado.getCodigo());
				bodyResponse.setMensajeRespuesta(constante.IDF4_VALIDAR_CODIGO_NO_EXITO());
				estadoHttp = HttpStatus.CREATED;
				log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
			} else if (Constante.CODIGO.IDT1_VALIDAR_CODIGO_ERROR.equalsIgnoreCase(codigoValidado.getCodigo())) {
				bodyResponse.setCodigoRespuesta(codigoValidado.getCodigo());
				bodyResponse.setMensajeRespuesta(constante.IDT1_VALIDAR_CODIGO_ERROR());
				estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
				log.info(METHOD_NAME , bodyResponse.getMensajeRespuesta());
			}
			log.info(METHOD_NAME , "Termina API REST.");
		} catch (Exception e) {
			log.error(constante.IDT1_VALIDAR_CODIGO_ERROR() , e.getMessage());
			bodyResponse.setCodigoRespuesta(Constante.CODIGO.IDT1_VALIDAR_CODIGO_ERROR);
			bodyResponse.setMensajeRespuesta(constante.IDT1_VALIDAR_CODIGO_ERROR());
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		headerResponse.setHeaderResponse(headerResponseGenerarCodigo);
		messageResponse.setHeader(headerResponse);
		messageResponse.setBody(bodyResponse);
		response.setMessageResponse(messageResponse);
		return new ResponseEntity<>(response, estadoHttp);
	}

}

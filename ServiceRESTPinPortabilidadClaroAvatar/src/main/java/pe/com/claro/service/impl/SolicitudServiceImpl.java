package pe.com.claro.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.claro.bean.BodyRequestGenerarCodigo;
import pe.com.claro.bean.BodyRequestValidarCodigo;
import pe.com.claro.dao.SolicitudDao;
import pe.com.claro.domain.RespuestaDomain;
import pe.com.claro.model.Cliente;
import pe.com.claro.model.Solicitud;
import pe.com.claro.service.ParametroService;
import pe.com.claro.service.SolicitudService;
import pe.com.claro.util.Constante;
import pe.com.claro.util.DateUtil;
import pe.com.claro.util.RandomUtil;

/**
 * @author Jhonny Cisneros
 *
 */
@Service
public class SolicitudServiceImpl implements SolicitudService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(SolicitudServiceImpl.class);

	@Autowired
	private SolicitudDao solicitudDao;

	@Autowired
	private ParametroService parametroService;

	@Override
	public Solicitud crear(Solicitud t) throws Exception {
		String METHOD_NAME = "Capa Service  - {crear} ";
		log.info(METHOD_NAME + "Inicia lógica para crear una Solicitud.");
		return solicitudDao.save(t);
	}

	@Override
	public Solicitud actualizar(Solicitud t) throws Exception {
		String METHOD_NAME = "Capa Service  - {actualizar} ";
		log.info(METHOD_NAME + "Inicia lógica para actualizar una Solicitud.");
		return solicitudDao.save(t);
	}

	@Override
	public void eliminar(Solicitud t) throws Exception {
		String METHOD_NAME = "Capa Service  - {eliminar} ";
		log.info(METHOD_NAME + "Inicia lógica para eliminar una Solicitud.");
		solicitudDao.delete(t);
	}

	@Override
	public void eliminarXId(Integer id) throws Exception {
		String METHOD_NAME = "Capa Service  - {eliminarXId} ";
		log.info(METHOD_NAME + "Inicia lógica para eliminar por ID una Solicitud.");
		solicitudDao.delete(id);
	}

	@Override
	public Solicitud encontrarXId(Integer id) throws Exception {
		String METHOD_NAME = "Capa Service  - {encontrarXId} ";
		log.info(METHOD_NAME + "Inicia lógica para encontrar por ID una Solicitud.");
		return solicitudDao.findOne(id);
	}

	@Override
	public List<Solicitud> encontrarTodos() throws Exception {
		String METHOD_NAME = "Capa Service  - {encontrarTodos} ";
		log.info(METHOD_NAME + "Inicia lógica para encontrar todas las Solicitudes.");
		return solicitudDao.findAll();
	}

	@Override
	public RespuestaDomain validarIntentos(BodyRequestGenerarCodigo request) {
		String METHOD_NAME = "Capa Service  - {validarIntentos} ";
		log.info(METHOD_NAME + "Inicia lógica para validar intentos.");
		RespuestaDomain rpDomain = new RespuestaDomain();
		int telefono = Integer.valueOf(request.getLinea());
		Timestamp fechaGeneracion = new Timestamp(DateUtil.getFullCurrentDate().getTime());
		log.info(METHOD_NAME + "fecha actual de validacion de intentos: " + fechaGeneracion);
		Integer totalSolicitudes = solicitudDao.totalSolicitudesXLineaYFechaGeneracion(telefono, fechaGeneracion);
		log.info(METHOD_NAME + "total de solicitudes ingresadas: " + totalSolicitudes);
		Integer cantidadMaximaIntentos = Integer.valueOf(parametroService
				.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_KEY_CANTIDAD_MAXIMA_INTENTOS).getValorParam());
		log.info(METHOD_NAME + "cantidad maxima de intentos: " + cantidadMaximaIntentos);
		if (totalSolicitudes == null || totalSolicitudes < cantidadMaximaIntentos) {
			rpDomain.setCodigo(Constante.PARAMETRO.GENERAR_CODIGO_VALIDAR_INTENTOS_EXITO);
		}
		rpDomain.setValor(String.valueOf(totalSolicitudes));
		return rpDomain;
	}

	@Override
	public RespuestaDomain generarCodigo(BodyRequestGenerarCodigo request, Cliente cliente) {
		String METHOD_NAME = "Capa Service  - {generarCodigo} ";
		log.info(METHOD_NAME + "Inicia lógica para generar un codigo SMS y registrar la solicitud.");
		RespuestaDomain rpDomain = new RespuestaDomain();
		int cantidadCaracteresCodigoSMS = Integer.valueOf(parametroService
				.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_KEY_CANTIDAD_DIGITOS).getValorParam());
		log.info(METHOD_NAME + "cantidad de digitos del codigo SMS a generar: " + cantidadCaracteresCodigoSMS);
		String codigoSMS = RandomUtil.generarCodigoSMS(cantidadCaracteresCodigoSMS);
		int cantidadCaracteresToken = Integer.valueOf(parametroService
				.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_KEY_CANTIDAD_CARACTERES_TOKEN).getValorParam());
		String token = RandomUtil.generarToken(cantidadCaracteresToken);

		try {
			Solicitud solicitud = new Solicitud();
			int telefono = Integer.valueOf(request.getLinea());
			solicitud.setCliente(cliente);
			solicitud.setTelefono(telefono);
			solicitud.setToken(token);
			solicitud.setCodigoSMS(codigoSMS);
			Integer totalSolicitudes = solicitudDao.totalSolicitudesXLinea(telefono);
			if (totalSolicitudes != null && totalSolicitudes > 0) {
				log.info(METHOD_NAME + "se inactivan las solicitudes anteriores.");
				solicitudDao.inactivarSolicitudesAnteriores(telefono);
			}
			solicitud.setEstado(Constante.PARAMETRO.GENERAR_CODIGO_ESTADO_ACTIVO);
			Timestamp fechaGeneracion = new Timestamp(DateUtil.getFullCurrentDate().getTime());
			solicitud.setFechaGeneracion(fechaGeneracion);
			Solicitud solicitudCreada = this.crear(solicitud);
			rpDomain.setCodigo(Constante.CODIGO.IDF0_GENERAR_CODIGO_EXITO);
			rpDomain.setObjeto(solicitudCreada);
			log.info(METHOD_NAME + "se registra la solicitud generada.");
		} catch (Exception e) {
			log.error("Error en la capa Service metodo {generarCodigo}: " + e.getMessage());
			rpDomain.setCodigo(Constante.CODIGO.IDT1_GENERAR_CODIGO_ERROR);
		}

		return rpDomain;
	}

	@Override
	public RespuestaDomain validarCodigo(BodyRequestValidarCodigo request) {
		String METHOD_NAME = "Capa Service  - {validarCodigo} ";
		log.info(METHOD_NAME + "Inicia la lógica para validar codigo SMS generado.");
		RespuestaDomain rpDomain = new RespuestaDomain();
		Solicitud solicitud = solicitudDao.findByToken(request.getEnvioSMS());
		try {
			/** Se valida si el token ingresado es valido */
			if (solicitud != null) {
				log.info(METHOD_NAME + " Se valido que el token ingresado es correcto.");
				Timestamp fechaValidacion = new Timestamp(DateUtil.getFullCurrentDate().getTime());
				log.info(METHOD_NAME + " fecha actual de validacion: " + fechaValidacion);
				solicitud.setFechaValidacion(fechaValidacion);
				Integer cantidadIntentosFallidos = solicitud.getIntentosFallidos();
				log.info(METHOD_NAME + " cantidad de intentos fallidos inicial: " + cantidadIntentosFallidos);
				Integer cantidadMaximaIntentosFallidos = Integer.valueOf(parametroService
						.encontrarXNombreParam(Constante.PARAMETRO.SERVICE_REST_KEY_CANTIDAD_MAXIMA_INTENTOS_FALLIDOS)
						.getValorParam());
				log.info(METHOD_NAME + " cantidad maxima de intentos fallidos permitido: "
						+ cantidadMaximaIntentosFallidos);
				/** Se valida si tiene reintentos permitidos */
				if (cantidadIntentosFallidos < cantidadMaximaIntentosFallidos) {
					log.info(METHOD_NAME + " Se valido que si tiene reintentos permitidos.");
					/** Se valida si el codigo SMS ingresado es valido */
					if (request.getCodigo().equalsIgnoreCase(solicitud.getCodigoSMS())) {
						log.info(METHOD_NAME + " Se valido que el codigo SMS ingresado es correcto.");
						rpDomain.setCodigo(Constante.CODIGO.IDF0_VALIDAR_CODIGO_EXITO);
					} else {
						solicitud.setIntentosFallidos(cantidadIntentosFallidos + 1);
						rpDomain.setCodigo(Constante.CODIGO.IDF4_VALIDAR_CODIGO_NO_EXITO);
						log.info(METHOD_NAME + " cantidad actual de intentos fallidos: " + cantidadIntentosFallidos);
					}
				} else {
					rpDomain.setCodigo(Constante.CODIGO.IDF1_VALIDAR_CODIGO_CANTIDAD_INTENTOS_SUPERADO);
				}
				this.actualizar(solicitud);
			} else {
				rpDomain.setCodigo(Constante.CODIGO.IDF4_VALIDAR_CODIGO_NO_EXITO);
			}

		} catch (Exception e) {
			log.error("Error en la capa Service metodo {validarCodigo}: " + e.getMessage());
			rpDomain.setCodigo(Constante.CODIGO.IDT1_VALIDAR_CODIGO_ERROR);
		}
		return rpDomain;
	}

	@Override
	public RespuestaDomain enviarSMSIndico(BodyRequestGenerarCodigo request) {
		String METHOD_NAME = "Capa Service  - {enviarSMSIndico} ";
		log.info(METHOD_NAME + "Inicia la lógica para enviar SMS Indico.");
		RespuestaDomain rpDomain = new RespuestaDomain();
		rpDomain.setCodigo(Constante.PARAMETRO.GENERAR_CODIGO_ENVIAR_CODIGO_SMS_EXITO);
		// se debe invocar al servicio de envio SMS
		return rpDomain;
	}

	@Override
	public RespuestaDomain enviarSMS(BodyRequestGenerarCodigo request) {
		String METHOD_NAME = "Capa Service  - {enviarSMS} ";
		log.info(METHOD_NAME + "Inicia la lógica para enviar SMS.");
		RespuestaDomain rpDomain = new RespuestaDomain();
		rpDomain.setCodigo(Constante.PARAMETRO.GENERAR_CODIGO_ENVIAR_CODIGO_SMS_EXITO);
		// se debe invocar al servicio de envio SMS
		return rpDomain;
	}

}

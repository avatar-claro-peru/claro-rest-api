package pe.com.claro.service;

import pe.com.claro.bean.BodyRequestGenerarCodigo;
import pe.com.claro.bean.BodyRequestValidarCodigo;
import pe.com.claro.domain.RespuestaDomain;
import pe.com.claro.model.Cliente;
import pe.com.claro.model.Solicitud;

/**
 * @author Jhonny Cisneros
 *
 */
public interface SolicitudService extends GenericService<Solicitud, Integer> {

	/** Metodos para API-REST: generarCodigo */
	RespuestaDomain validarIntentos(BodyRequestGenerarCodigo request);

	RespuestaDomain generarCodigo(BodyRequestGenerarCodigo request, Cliente cliente);

	RespuestaDomain enviarSMSIndico(BodyRequestGenerarCodigo request);

	RespuestaDomain enviarSMS(BodyRequestGenerarCodigo request);

	/** Metodos para API-REST: validarCodigo */
	RespuestaDomain validarCodigo(BodyRequestValidarCodigo request);

}

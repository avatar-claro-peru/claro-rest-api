package pe.com.claro.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jhonny Cisneros
 *
 */
@Component
public class Constante {

	@Autowired
	MessageUtil messages;

	/** MENSAJE RESPUESTA FUNCIONAL METODO: GENERAR_CODIGO */
	public String IDF0_GENERAR_CODIGO_EXITO() {
		return messages.get("idf0.generar.codigo.exito");
	}

	public String IDF1_GENERAR_CODIGO_NO_VALIDO_NRO_INTENTOS() {
		return messages.get("idf1.generar.codigo.no.valido.nro.intentos");
	}

	public String IDF2_GENERAR_CODIGO_NO_HEADER_CORRECTO() {
		return messages.get("idf2.generar.codigo.no.header.correcto");
	}

	public String IDF3_GENERAR_CODIGO_NO_REQUEST_CORRECTO() {
		return messages.get("idf3.generar.codigo.no.request.correcto");
	}

	public String IDF4_GENERAR_CODIGO_NO_FLAG_ENVIO_SMS() {
		return messages.get("idf4.generar.codigo.no.flag.envio.sms");
	}

	public String IDF5_GENERAR_CODIGO_NO_ENVIO_SMS() {
		return messages.get("idf5.generar.codigo.no.envio.sms");
	}

	public String IDF6_GENERAR_CODIGO_NO_EXISTE_CLIENTE() {
		return messages.get("idf6.generar.codigo.no.existe.cliente");
	}

	public String IDF7_GENERAR_CODIGO_NO_GENERO_CODIGO_SMS() {
		return messages.get("idf7.generar.codigo.no.genero.codigo.sms");
	}
	

	/** MENSAJE RESPUESTA FUNCIONAL METODO: VALIDAR_CODIGO */
	public String IDF0_VALIDAR_CODIGO_EXITO() {
		return messages.get("idf0.validar.codigo.exito");
	}

	public String IDF1_VALIDAR_CODIGO_CANTIDAD_INTENTOS_SUPERADO() {
		return messages.get("idf1.validar.codigo.cantidad.intentos.superado");
	}

	public String IDF2_VALIDAR_CODIGO_NO_HEADER_CORRECTO() {
		return messages.get("idf2.validar.codigo.no.header.correcto");
	}

	public String IDF3_VALIDAR_CODIGO_NO_REQUEST_CORRECTO() {
		return messages.get("idf3.validar.codigo.no.request.correcto");
	}

	public String IDF4_VALIDAR_CODIGO_NO_EXITO() {
		return messages.get("idf4.validar.codigo.no.exito");
	}
	
	
	/** MENSAJE RESPUESTA FUNCIONAL METODO: CONSULTAR_STOCK_ONLINE */
	public String IDF0_CONSULTAR_STOCK_ONLINE_EXITO() {
		return messages.get("idf0.consultar.stock.online.exito");
	}

	public String IDF1_CONSULTAR_STOCK_ONLINE_NO_HEADER_CORRECTO() {
		return messages.get("idf1.consultar.stock.online.no.header.correcto");
	}

	public String IDF2_CONSULTAR_STOCK_ONLINE_NO_REQUEST_CORRECTO() {
		return messages.get("idf2.consultar.stock.online.no.request.correcto");
	}

	public String IDF3_CONSULTAR_STOCK_ONLINE_NO_EXITO() {
		return messages.get("idf3.consultar.stock.online.no.exito");
	}
	
	public String IDF4_CONSULTAR_STOCK_ONLINE_CON_STOCK() {
		return messages.get("idf4.consultar.stock.online.con.stock");
	}
	
	public String IDF5_CONSULTAR_STOCK_ONLINE_SIN_STOCK() {
		return messages.get("idf5.consultar.stock.online.sin.stock");
	}
	
	public String IDF6_CONSULTAR_STOCK_ONLINE_SIN_STOCK_MATERIAL() {
		return messages.get("idf6.consultar.stock.online.sin.stock.material");
	}
	
	public String IDF7_CONSULTAR_STOCK_ONLINE_SIN_STOCK_CHIP() {
		return messages.get("idf7.consultar.stock.online.sin.stock.chip");
	}
			
	
	/** MENSAJES IDT */
	public String IDT1_GENERAR_CODIGO_ERROR() {
		return messages.get("idt1.generar.codigo.error");
	}

	public String IDT1_VALIDAR_CODIGO_ERROR() {
		return messages.get("idt1.validar.codigo.error");
	}
	
	public String IDT1_CONSULTAR_STOCK_ONLINE_ERROR() {
		return messages.get("idt1.consultar.stock.online.error");
	}

	public abstract class CODIGO {
		
		/** CODIGO RESPUESTA FUNCIONAL METODO: GENERAR_CODIGO */
		public static final String IDF0_GENERAR_CODIGO_EXITO = "0";
		public static final String IDF1_GENERAR_CODIGO_NO_VALIDO_NRO_INTENTOS = "1";
		public static final String IDF2_GENERAR_CODIGO_NO_HEADER_CORRECTO = "2";
		public static final String IDF3_GENERAR_CODIGO_NO_REQUEST_CORRECTO = "3";
		public static final String IDF4_GENERAR_CODIGO_NO_FLAG_ENVIO_SMS = "4";
		public static final String IDF5_GENERAR_CODIGO_NO_ENVIO_SMS = "5";
		public static final String IDF6_GENERAR_CODIGO_NO_EXISTE_CLIENTE = "6";
		public static final String IDF7_GENERAR_CODIGO_NO_GENERO_CODIGO_SMS = "7";
		
		/** CODIGO RESPUESTA FUNCIONAL METODO: VALIDAR_CODIGO */
		public static final String IDF0_VALIDAR_CODIGO_EXITO = "0";
		public static final String IDF1_VALIDAR_CODIGO_CANTIDAD_INTENTOS_SUPERADO = "1";
		public static final String IDF2_VALIDAR_CODIGO_NO_HEADER_CORRECTO = "2";
		public static final String IDF3_VALIDAR_CODIGO_NO_REQUEST_CORRECTO = "3";
		public static final String IDF4_VALIDAR_CODIGO_NO_EXITO = "4";
				
		/** CODIGO RESPUESTA FUNCIONAL METODO: CONSULTAR_STOCK_ONLINE */
		public static final String IDF0_CONSULTAR_STOCK_ONLINE_EXITO = "0";
		public static final String IDF1_CONSULTAR_STOCK_ONLINE_NO_EXITO = "2";
		public static final String IDF2_CONSULTAR_STOCK_ONLINE_NRO_LOG_EXITO = "0";
		public static final String IDF3_CONSULTAR_STOCK_ONLINE_NRO_LOG_SIN_EXITO = "1";
		
		/** CODIGO RESPUESTA TECNICO */
		public static final String IDT1_GENERAR_CODIGO_ERROR = "-1";
		public static final String IDT1_VALIDAR_CODIGO_ERROR = "-1";
		public static final String IDT1_CONSULTAR_STOCK_ONLINE_ERROR = "-1";

	}

	public abstract class PARAMETRO {
		
		public static final String CANTIDAD_DIGITOS = "CANTIDAD_DIGITOS";
		public static final String SERVICE_REST_KEY_CANTIDAD_DIGITOS = "service.rest.key.cantidad.digitos";
		public static final String SERVICE_REST_KEY_CANTIDAD_CARACTERES_TOKEN = "service.rest.key.cantidad.caracteres.token";
		public static final String SERVICE_REST_KEY_CANTIDAD_MAXIMA_INTENTOS = "service.rest.key.cantidad.maxima.intentos";
		public static final String SERVICE_REST_KEY_CANTIDAD_MAXIMA_INTENTOS_FALLIDOS = "service.rest.key.cantidad.maxima.intentos.fallidos";
		public static final String SERVICE_REST_KEY_TIEMPO_VENTANA_MODAL = "service.rest.key.tiempo.ventana.modal";

		public static final String GENERAR_CODIGO_VALIDAR_INTENTOS_EXITO = "0";
		public static final String GENERAR_CODIGO_ENVIAR_CODIGO_SMS_EXITO = "0";
		public static final int GENERAR_CODIGO_ESTADO_ACTIVO = 1;

		public static final String FLAG_ENVIO_SMS = "1";
		public static final String FLAG_ENVIO_SMS_INDICO = "1";
		
		public static final String SERVICE_REST_CANTIDAD_INVENTARIO_MATERIAL = "service.rest.cantidad.inventario.material";
		public static final String SERVICE_REST_CANTIDAD_INVENTARIO_CHIP = "service.rest.cantidad.inventario.chip";

	}
	

}

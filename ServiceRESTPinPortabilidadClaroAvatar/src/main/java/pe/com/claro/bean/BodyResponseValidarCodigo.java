package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class BodyResponseValidarCodigo {

	@JsonProperty("codigoRespuesta")
	private String codigoRespuesta;

	@JsonProperty("mensajeRespuesta")
	private String mensajeRespuesta;

	/**
	 * @return the codigoRespuesta
	 */
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	/**
	 * @param codigoRespuesta the codigoRespuesta to set
	 */
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	/**
	 * @return the mensajeRespuesta
	 */
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	/**
	 * @param mensajeRespuesta the mensajeRespuesta to set
	 */
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	@Override
	public String toString() {
		return "BodyResponseValidarCodigo [codigoRespuesta=" + codigoRespuesta + ", mensajeRespuesta="
				+ mensajeRespuesta + "]";
	}

}

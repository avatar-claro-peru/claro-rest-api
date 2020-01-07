package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class BodyResponseGenerarCodigo {

	@JsonProperty("codigoRespuesta")
	private String codigoRespuesta;

	@JsonProperty("mensajeRespuesta")
	private String mensajeRespuesta;

	@JsonProperty("data")
	private DataGenerarCodigo data;

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

	/**
	 * @return the data
	 */
	public DataGenerarCodigo getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(DataGenerarCodigo data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BodyResponseGenerarCodigo [codigoRespuesta=" + codigoRespuesta + ", mensajeRespuesta="
				+ mensajeRespuesta + ", data=" + data + "]";
	}

}

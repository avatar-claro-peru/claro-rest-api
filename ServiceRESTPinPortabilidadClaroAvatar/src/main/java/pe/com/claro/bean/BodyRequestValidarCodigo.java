package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class BodyRequestValidarCodigo {

	@JsonProperty("envioSms")
	private String envioSMS;

	@JsonProperty("codigo")
	private String codigo;

	/**
	 * @return the envioSMS
	 */
	public String getEnvioSMS() {
		return envioSMS;
	}

	/**
	 * @param envioSMS the envioSMS to set
	 */
	public void setEnvioSMS(String envioSMS) {
		this.envioSMS = envioSMS;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "BodyRequestValidarCodigo [envioSMS=" + envioSMS + ", codigo=" + codigo + "]";
	}

}

package pe.com.claro.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.ListaOpcionalesDomain;

/**
 * @author Jhonny Cisneros
 *
 */
public class BodyRequestGenerarCodigo {

	@JsonProperty("linea")
	private String linea;

	@JsonProperty("numeroDocumento")
	private String numeroDocumento;

	@JsonProperty("flagEnvioSMS")
	private String flagEnvioSMS;

	@JsonProperty("flagSMSIndico")
	private String flagSMSIndico;

	@JsonProperty("listaOpcionales")
	private List<ListaOpcionalesDomain> listaOpcionales;

	/**
	 * @return the linea
	 */
	public String getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(String linea) {
		this.linea = linea;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the flagEnvioSMS
	 */
	public String getFlagEnvioSMS() {
		return flagEnvioSMS;
	}

	/**
	 * @param flagEnvioSMS the flagEnvioSMS to set
	 */
	public void setFlagEnvioSMS(String flagEnvioSMS) {
		this.flagEnvioSMS = flagEnvioSMS;
	}

	/**
	 * @return the flagSMSIndico
	 */
	public String getFlagSMSIndico() {
		return flagSMSIndico;
	}

	/**
	 * @param flagSMSIndico the flagSMSIndico to set
	 */
	public void setFlagSMSIndico(String flagSMSIndico) {
		this.flagSMSIndico = flagSMSIndico;
	}

	/**
	 * @return the listaOpcionales
	 */
	public List<ListaOpcionalesDomain> getListaOpcionales() {
		return listaOpcionales;
	}

	/**
	 * @param listaOpcionales the listaOpcionales to set
	 */
	public void setListaOpcionales(List<ListaOpcionalesDomain> listaOpcionales) {
		this.listaOpcionales = listaOpcionales;
	}

	@Override
	public String toString() {
		return "BodyRequestGenerarCodigo [linea=" + linea + ", numeroDocumento=" + numeroDocumento + ", flagEnvioSMS="
				+ flagEnvioSMS + ", flagSMSIndico=" + flagSMSIndico + ", listaOpcionales=" + listaOpcionales + "]";
	}

}

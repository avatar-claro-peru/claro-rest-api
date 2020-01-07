package pe.com.claro.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.ListaOpcionalesDomain;

/**
 * @author Jhonny Cisneros
 *
 */
public class DataGenerarCodigo {

	@JsonProperty("envioSms")
	private String envioSMS;

	@JsonProperty("numeroIntentos")
	private int numeroIntentos;

	@JsonProperty("numeroReintentos")
	private int numeroReintentos;

	@JsonProperty("tiempoVentanaModal")
	private int tiempoVentanaModal;

	@JsonProperty("listaOpcionales")
	private List<ListaOpcionalesDomain> listaOpcionales;

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
	 * @return the numeroIntentos
	 */
	public int getNumeroIntentos() {
		return numeroIntentos;
	}

	/**
	 * @param numeroIntentos the numeroIntentos to set
	 */
	public void setNumeroIntentos(int numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}

	/**
	 * @return the numeroReintentos
	 */
	public int getNumeroReintentos() {
		return numeroReintentos;
	}

	/**
	 * @param numeroReintentos the numeroReintentos to set
	 */
	public void setNumeroReintentos(int numeroReintentos) {
		this.numeroReintentos = numeroReintentos;
	}

	/**
	 * @return the tiempoVentanaModal
	 */
	public int getTiempoVentanaModal() {
		return tiempoVentanaModal;
	}

	/**
	 * @param tiempoVentanaModal the tiempoVentanaModal to set
	 */
	public void setTiempoVentanaModal(int tiempoVentanaModal) {
		this.tiempoVentanaModal = tiempoVentanaModal;
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
		return "DataGenerarCodigo [envioSMS=" + envioSMS + ", numeroIntentos=" + numeroIntentos + ", numeroReintentos="
				+ numeroReintentos + ", tiempoVentanaModal=" + tiempoVentanaModal + ", listaOpcionales="
				+ listaOpcionales + "]";
	}

}

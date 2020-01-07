package pe.com.claro.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.ListaOpcionalesDomain;

/**
 * @author Jhonny Cisneros
 *
 */
public class DataConsultarStockOnline {

	@JsonProperty("nroLog")
	private String nroLog;

	@JsonProperty("desLog")
	private String desLog;

	@JsonProperty("serieDisEquipo")
	private String serieDisEquipo;

	@JsonProperty("serieDisChip")
	private String serieDisChip;

	@JsonProperty("listaAdicionalResponse")
	private List<ListaOpcionalesDomain> objetoResponseOpcional;

	/**
	 * @return the nroLog
	 */
	public String getNroLog() {
		return nroLog;
	}

	/**
	 * @param nroLog the nroLog to set
	 */
	public void setNroLog(String nroLog) {
		this.nroLog = nroLog;
	}

	/**
	 * @return the desLog
	 */
	public String getDesLog() {
		return desLog;
	}

	/**
	 * @param desLog the desLog to set
	 */
	public void setDesLog(String desLog) {
		this.desLog = desLog;
	}

	/**
	 * @return the serieDisEquipo
	 */
	public String getSerieDisEquipo() {
		return serieDisEquipo;
	}

	/**
	 * @param serieDisEquipo the serieDisEquipo to set
	 */
	public void setSerieDisEquipo(String serieDisEquipo) {
		this.serieDisEquipo = serieDisEquipo;
	}

	/**
	 * @return the serieDisChip
	 */
	public String getSerieDisChip() {
		return serieDisChip;
	}

	/**
	 * @param serieDisChip the serieDisChip to set
	 */
	public void setSerieDisChip(String serieDisChip) {
		this.serieDisChip = serieDisChip;
	}

	/**
	 * @return the objetoResponseOpcional
	 */
	public List<ListaOpcionalesDomain> getObjetoResponseOpcional() {
		return objetoResponseOpcional;
	}

	/**
	 * @param objetoResponseOpcional the objetoResponseOpcional to set
	 */
	public void setObjetoResponseOpcional(List<ListaOpcionalesDomain> objetoResponseOpcional) {
		this.objetoResponseOpcional = objetoResponseOpcional;
	}

}

package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.RequestOpcional;

/**
 * @author Jhonny Cisneros
 *
 */
public class BodyRequestConsultarStockOnline {

	@JsonProperty("codMaterial")
	private String codMaterial;

	@JsonProperty("codMaterialChip")
	private String codMaterialChip;

	@JsonProperty("codPDV")
	private String codPDV;

	@JsonProperty("codCentro")
	private String codCentro;

	@JsonProperty("CodAlmacen")
	private String codAlmacen;

	@JsonProperty("listaRequestOpcional")
	private RequestOpcional listaRequestOpcional;

	/**
	 * @return the codMaterial
	 */
	public String getCodMaterial() {
		return codMaterial;
	}

	/**
	 * @param codMaterial the codMaterial to set
	 */
	public void setCodMaterial(String codMaterial) {
		this.codMaterial = codMaterial;
	}

	/**
	 * @return the codMaterialChip
	 */
	public String getCodMaterialChip() {
		return codMaterialChip;
	}

	/**
	 * @param codMaterialChip the codMaterialChip to set
	 */
	public void setCodMaterialChip(String codMaterialChip) {
		this.codMaterialChip = codMaterialChip;
	}

	/**
	 * @return the codPDV
	 */
	public String getCodPDV() {
		return codPDV;
	}

	/**
	 * @param codPDV the codPDV to set
	 */
	public void setCodPDV(String codPDV) {
		this.codPDV = codPDV;
	}

	/**
	 * @return the codCentro
	 */
	public String getCodCentro() {
		return codCentro;
	}

	/**
	 * @param codCentro the codCentro to set
	 */
	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
	}

	/**
	 * @return the codAlmacen
	 */
	public String getCodAlmacen() {
		return codAlmacen;
	}

	/**
	 * @param codAlmacen the codAlmacen to set
	 */
	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	/**
	 * @return the listaRequestOpcional
	 */
	public RequestOpcional getListaRequestOpcional() {
		return listaRequestOpcional;
	}

	/**
	 * @param listaRequestOpcional the listaRequestOpcional to set
	 */
	public void setListaRequestOpcional(RequestOpcional listaRequestOpcional) {
		this.listaRequestOpcional = listaRequestOpcional;
	}

}

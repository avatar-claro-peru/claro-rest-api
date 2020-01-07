package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.ResponseStatus;

/**
 * @author Jhonny Cisneros
 *
 */
public class BodyResponseConsultarStockOnline {

	@JsonProperty("responseStatus")
	private ResponseStatus responseStatus;

	@JsonProperty("responseDataConsultaStockOnline")
	private DataConsultarStockOnline responseDataConsultaStockOnline;

	/**
	 * @return the responseStatus
	 */
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * @return the responseDataConsultaStockOnline
	 */
	public DataConsultarStockOnline getResponseDataConsultaStockOnline() {
		return responseDataConsultaStockOnline;
	}

	/**
	 * @param responseDataConsultaStockOnline the responseDataConsultaStockOnline to
	 *                                        set
	 */
	public void setResponseDataConsultaStockOnline(DataConsultarStockOnline responseDataConsultaStockOnline) {
		this.responseDataConsultaStockOnline = responseDataConsultaStockOnline;
	}

}

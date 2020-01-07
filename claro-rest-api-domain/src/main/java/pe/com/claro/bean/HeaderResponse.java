package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Jhonny Cisneros
 *
 */
public class HeaderResponse {

	@JsonPropertyOrder("HeaderResponse")
	private Object headerResponse;

	/**
	 * @return the headerResponse
	 */
	public Object getHeaderResponse() {
		return headerResponse;
	}

	/**
	 * @param headerResponse the headerResponse to set
	 */
	public void setHeaderResponse(Object headerResponse) {
		this.headerResponse = headerResponse;
	}

	@Override
	public String toString() {
		return "HeaderResponse [headerResponse=" + headerResponse + "]";
	}

}

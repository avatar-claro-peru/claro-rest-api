package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class HeaderRequest {

	@JsonProperty("HeaderRequest")
	private Object headerRequest;

	/**
	 * @return the headerRequest
	 */
	public Object getHeaderRequest() {
		return headerRequest;
	}

	/**
	 * @param headerRequest the headerRequest to set
	 */
	public void setHeaderRequest(Object headerRequest) {
		this.headerRequest = headerRequest;
	}

	@Override
	public String toString() {
		return "HeaderRequest [headerRequest=" + headerRequest + "]";
	}

}

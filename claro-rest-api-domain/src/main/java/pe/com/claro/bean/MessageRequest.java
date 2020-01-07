package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class MessageRequest {

	@JsonProperty("Header")
	private HeaderRequest header;

	@JsonProperty("Body")
	private Object body;

	/**
	 * @return the header
	 */
	public HeaderRequest getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(HeaderRequest header) {
		this.header = header;
	}

	/**
	 * @return the body
	 */
	public Object getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(Object body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MessageRequest [header=" + header + ", body=" + body + "]";
	}

}

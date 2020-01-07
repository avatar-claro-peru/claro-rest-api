package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class Response {

	@JsonProperty("MessageResponse")
	private MessageResponse messageResponse;

	/**
	 * @return the messageResponse
	 */
	public MessageResponse getMessageResponse() {
		return messageResponse;
	}

	/**
	 * @param messageResponse the messageResponse to set
	 */
	public void setMessageResponse(MessageResponse messageResponse) {
		this.messageResponse = messageResponse;
	}

	@Override
	public String toString() {
		return "Response [messageResponse=" + messageResponse + "]";
	}

}

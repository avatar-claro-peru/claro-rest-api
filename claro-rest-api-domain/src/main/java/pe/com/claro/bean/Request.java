package pe.com.claro.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class Request {

	@JsonProperty("MessageRequest")
	private MessageRequest messageRequest;

	/**
	 * @return the messageRequest
	 */
	public MessageRequest getMessageRequest() {
		return messageRequest;
	}

	/**
	 * @param messageRequest the messageRequest to set
	 */
	public void setMessageRequest(MessageRequest messageRequest) {
		this.messageRequest = messageRequest;
	}

	@Override
	public String toString() {
		return "Request [messageRequest=" + messageRequest + "]";
	}

}

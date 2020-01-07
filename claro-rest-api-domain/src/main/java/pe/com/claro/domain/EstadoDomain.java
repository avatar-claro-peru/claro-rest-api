package pe.com.claro.domain;

/**
 * @author Jhonny Cisneros
 *
 */
public class EstadoDomain {

	private String type;
	private String code;
	private String message;
	private String msgid;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the msgid
	 */
	public String getMsgid() {
		return msgid;
	}

	/**
	 * @param msgid the msgid to set
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

}

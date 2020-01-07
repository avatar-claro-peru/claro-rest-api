package pe.com.claro.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jhonny Cisneros
 *
 */
public class HeaderRequestGenerarCodigo {

	@JsonProperty("consumer")
	private String consumer;

	@JsonProperty("country")
	private String country;

	@JsonProperty("dispositivo")
	private String dispositivo;

	@JsonProperty("language")
	private String language;

	@JsonProperty("modulo")
	private String modulo;

	@JsonProperty("msgType")
	private String msgType;

	@JsonProperty("operation")
	private String operation;

	@JsonProperty("pid")
	private String pid;

	@JsonProperty("system")
	private String system;

	@JsonProperty("timestamp")
	private Date timestamp;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("wsIp")
	private String wsIp;

	/**
	 * @return the consumer
	 */
	public String getConsumer() {
		return consumer;
	}

	/**
	 * @param consumer the consumer to set
	 */
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the dispositivo
	 */
	public String getDispositivo() {
		return dispositivo;
	}

	/**
	 * @param dispositivo the dispositivo to set
	 */
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the modulo
	 */
	public String getModulo() {
		return modulo;
	}

	/**
	 * @param modulo the modulo to set
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @return the system
	 */
	public String getSystem() {
		return system;
	}

	/**
	 * @param system the system to set
	 */
	public void setSystem(String system) {
		this.system = system;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the wsIp
	 */
	public String getWsIp() {
		return wsIp;
	}

	/**
	 * @param wsIp the wsIp to set
	 */
	public void setWsIp(String wsIp) {
		this.wsIp = wsIp;
	}

	@Override
	public String toString() {
		return "HeaderRequestGenerarCodigo [consumer=" + consumer + ", country=" + country + ", dispositivo="
				+ dispositivo + ", language=" + language + ", modulo=" + modulo + ", msgType=" + msgType
				+ ", operation=" + operation + ", pid=" + pid + ", system=" + system + ", timestamp=" + timestamp
				+ ", userId=" + userId + ", wsIp=" + wsIp + "]";
	}

}

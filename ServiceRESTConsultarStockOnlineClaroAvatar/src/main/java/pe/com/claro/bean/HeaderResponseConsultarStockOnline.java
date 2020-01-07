package pe.com.claro.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.EstadoDomain;

/**
 * @author Jhonny Cisneros
 *
 */
public class HeaderResponseConsultarStockOnline {

	@JsonProperty("consumer")
	private String consumer;

	@JsonProperty("pid")
	private String pid;

	@JsonProperty("timestamp")
	private Date timestamp;

	@JsonProperty("VarArg")
	private String varArg;

	@JsonProperty("status")
	private EstadoDomain status;

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
	 * @return the varArg
	 */
	public String getVarArg() {
		return varArg;
	}

	/**
	 * @param varArg the varArg to set
	 */
	public void setVarArg(String varArg) {
		this.varArg = varArg;
	}

	/**
	 * @return the status
	 */
	public EstadoDomain getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(EstadoDomain status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HeaderResponseValidarCodigo [consumer=" + consumer + ", pid=" + pid + ", timestamp=" + timestamp
				+ ", varArg=" + varArg + ", status=" + status + "]";
	}

}

package pe.com.claro.domain;

import java.util.List;

/**
 * @author Jhonny Cisneros
 *
 */
public class ResponseStatus {

	private String status;
	private String codeResponse;
	private String descriptionResponse;
	private String errorLocation;
	private String date;
	private String origin;
	private List<ErrorDetails> errorDetails;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the codeResponse
	 */
	public String getCodeResponse() {
		return codeResponse;
	}

	/**
	 * @param codeResponse the codeResponse to set
	 */
	public void setCodeResponse(String codeResponse) {
		this.codeResponse = codeResponse;
	}

	/**
	 * @return the descriptionResponse
	 */
	public String getDescriptionResponse() {
		return descriptionResponse;
	}

	/**
	 * @param descriptionResponse the descriptionResponse to set
	 */
	public void setDescriptionResponse(String descriptionResponse) {
		this.descriptionResponse = descriptionResponse;
	}

	/**
	 * @return the errorLocation
	 */
	public String getErrorLocation() {
		return errorLocation;
	}

	/**
	 * @param errorLocation the errorLocation to set
	 */
	public void setErrorLocation(String errorLocation) {
		this.errorLocation = errorLocation;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the errorDetails
	 */
	public List<ErrorDetails> getErrorDetails() {
		return errorDetails;
	}

	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(List<ErrorDetails> errorDetails) {
		this.errorDetails = errorDetails;
	}

}

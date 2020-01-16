package pe.com.claro.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.ListaOpcionalesDomain;

/**
 * @author Jhonny Cisneros
 *
 */
public class RequestOpcional {

	@JsonProperty("requestOpcional")
	private List<ListaOpcionalesDomain> requestOpcional;

	/**
	 * @return the requestOpcional
	 */
	public List<ListaOpcionalesDomain> getRequestOpcional() {
		return requestOpcional;
	}

	/**
	 * @param requestOpcional the requestOpcional to set
	 */
	public void setRequestOpcional(List<ListaOpcionalesDomain> requestOpcional) {
		this.requestOpcional = requestOpcional;
	}

}

package pe.com.claro.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import pe.com.claro.domain.ListaOpcionalesDomain;

/**
 * @author Jhonny Cisneros
 *
 */
public class ResponseOpcional {

	@JsonProperty("objetoResponseOpcional")
	private List<ListaOpcionalesDomain> responseOpcional;

	/**
	 * @return the responseOpcional
	 */
	public List<ListaOpcionalesDomain> getResponseOpcional() {
		return responseOpcional;
	}

	/**
	 * @param responseOpcional the responseOpcional to set
	 */
	public void setResponseOpcional(List<ListaOpcionalesDomain> responseOpcional) {
		this.responseOpcional = responseOpcional;
	}

}

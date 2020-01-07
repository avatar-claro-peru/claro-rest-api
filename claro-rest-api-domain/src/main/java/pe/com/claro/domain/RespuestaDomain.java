package pe.com.claro.domain;

/**
 * @author Jhonny Cisneros
 *
 */
public class RespuestaDomain {

	private String codigo;
	private String mensaje;
	private String valor;
	private Object objeto;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the objeto
	 */
	public Object getObjeto() {
		return objeto;
	}

	/**
	 * @param objeto the objeto to set
	 */
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

}

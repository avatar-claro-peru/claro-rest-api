package pe.com.claro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jhonny Cisneros
 *
 */
@Entity
@Table(name = "parametro")
public class Parametro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombreparam")
	private String nombreParam;

	@Column(name = "valorparam")
	private String valorParam;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "estadoparam")
	private int estadoParam;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombreParam
	 */
	public String getNombreParam() {
		return nombreParam;
	}

	/**
	 * @param nombreParam the nombreParam to set
	 */
	public void setNombreParam(String nombreParam) {
		this.nombreParam = nombreParam;
	}

	/**
	 * @return the valorParam
	 */
	public String getValorParam() {
		return valorParam;
	}

	/**
	 * @param valorParam the valorParam to set
	 */
	public void setValorParam(String valorParam) {
		this.valorParam = valorParam;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estadoParam
	 */
	public int getEstadoParam() {
		return estadoParam;
	}

	/**
	 * @param estadoParam the estadoParam to set
	 */
	public void setEstadoParam(int estadoParam) {
		this.estadoParam = estadoParam;
	}

}

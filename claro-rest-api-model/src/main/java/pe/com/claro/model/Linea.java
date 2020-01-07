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
@Table(name = "linea")
public class Linea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "numero_linea", length = 300)
	private String numero_linea;

	@Column(name = "tipo_venta")
	private String tipo_venta;

	@Column(name = "modalidad")
	private String modalidad;

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
	 * @return the numero_linea
	 */
	public String getNumero_linea() {
		return numero_linea;
	}

	/**
	 * @param numero_linea the numero_linea to set
	 */
	public void setNumero_linea(String numero_linea) {
		this.numero_linea = numero_linea;
	}

	/**
	 * @return the tipo_venta
	 */
	public String getTipo_venta() {
		return tipo_venta;
	}

	/**
	 * @param tipo_venta the tipo_venta to set
	 */
	public void setTipo_venta(String tipo_venta) {
		this.tipo_venta = tipo_venta;
	}

	/**
	 * @return the modalidad
	 */
	public String getModalidad() {
		return modalidad;
	}

	/**
	 * @param modalidad the modalidad to set
	 */
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

}

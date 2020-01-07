package pe.com.claro.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jhonny Cisneros
 *
 */
@Entity
@Table(name = "solicitud")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@Column(name = "telefono")
	private int telefono;

	@Column(name = "token", length = 128)
	private String token;

	@Column(name = "codigoSMS", length = 128)
	private String codigoSMS;

	@Column(name = "estado")
	private int estado;

	@Column(name = "fechageneracion")
	private Timestamp fechaGeneracion;

	@Column(name = "fechavalidacion")
	private Timestamp fechaValidacion;

	@Column(name = "intentosfallidos")
	private int intentosFallidos;

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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the codigoSMS
	 */
	public String getCodigoSMS() {
		return codigoSMS;
	}

	/**
	 * @param codigoSMS the codigoSMS to set
	 */
	public void setCodigoSMS(String codigoSMS) {
		this.codigoSMS = codigoSMS;
	}

	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaGeneracion
	 */
	public Timestamp getFechaGeneracion() {
		return fechaGeneracion;
	}

	/**
	 * @param fechaGeneracion the fechaGeneracion to set
	 */
	public void setFechaGeneracion(Timestamp fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	/**
	 * @return the fechaValidacion
	 */
	public Timestamp getFechaValidacion() {
		return fechaValidacion;
	}

	/**
	 * @param fechaValidacion the fechaValidacion to set
	 */
	public void setFechaValidacion(Timestamp fechaValidacion) {
		this.fechaValidacion = fechaValidacion;
	}

	/**
	 * @return the intentosFallidos
	 */
	public int getIntentosFallidos() {
		return intentosFallidos;
	}

	/**
	 * @param intentosFallidos the intentosFallidos to set
	 */
	public void setIntentosFallidos(int intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}

}

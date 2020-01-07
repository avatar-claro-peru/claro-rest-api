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
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "num_doc")
	private String numDoc;

	@Column(name = "correo")
	private String correo;

	@Column(name = "estado")
	private int estado;

	@Column(name = "pre_evaluacion")
	private int preEvaluacion;

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc() {
		return numDoc;
	}

	/**
	 * @param numDoc the numDoc to set
	 */
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
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
	 * @return the preEvaluacion
	 */
	public int getPreEvaluacion() {
		return preEvaluacion;
	}

	/**
	 * @param preEvaluacion the preEvaluacion to set
	 */
	public void setPreEvaluacion(int preEvaluacion) {
		this.preEvaluacion = preEvaluacion;
	}

}

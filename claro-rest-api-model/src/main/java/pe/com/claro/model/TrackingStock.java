package pe.com.claro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trackingstock")
public class TrackingStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "codmaterial")
	private String codmaterial;

	@Column(name = "codmaterialchip")
	private String codmaterialchip;

	@Column(name = "deslog")
	private String deslog;

	@Column(name = "nrolog")
	private String nrolog;

	@Column(name = "stockmaterial")
	private int stockmaterial;

	@Column(name = "stockchip")
	private int stockchip;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodmaterial() {
		return codmaterial;
	}

	public void setCodmaterial(String codmaterial) {
		this.codmaterial = codmaterial;
	}

	public String getCodmaterialchip() {
		return codmaterialchip;
	}

	public void setCodmaterialchip(String codmaterialchip) {
		this.codmaterialchip = codmaterialchip;
	}

	public String getDeslog() {
		return deslog;
	}

	public void setDeslog(String deslog) {
		this.deslog = deslog;
	}

	public String getNrolog() {
		return nrolog;
	}

	public void setNrolog(String nrolog) {
		this.nrolog = nrolog;
	}

	public int getStockmaterial() {
		return stockmaterial;
	}

	public void setStockmaterial(int stockmaterial) {
		this.stockmaterial = stockmaterial;
	}

	public int getStockchip() {
		return stockchip;
	}

	public void setStockchip(int stockchip) {
		this.stockchip = stockchip;
	}

}
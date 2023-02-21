
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "SINIESTRO", schema = "SEGUNI2")
public class Siniestro implements Serializable {

	private static final long serialVersionUID = 636940018674376069L;

	@Id
	@SequenceGenerator(schema = "SEGUNI", initialValue = 1, allocationSize = 1, name = "siniestroSeq", sequenceName = "SINIESTRO_SEQ")
	@GeneratedValue(generator = "siniestroSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_SINIESTRO")
	private Long idSiniestro;

	@Column(name = "FECHA_SINIESTRO")
	private String fechaSiniestro;

	@Column(name = "CAUSAS")
	private String causas;

	@Column(name = "ACEPTADO")
	private String aceptado;

	@Column(name = "INDEMNIZACION")
	private Double indemnizacion;

	@ManyToOne
	private Seguro seguro;

	@ManyToOne
	private Perito perito;

	public Long getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(Long idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public String getFechaSiniestro() {
		return fechaSiniestro;
	}

	public void setFechaSiniestro(String fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}

	public String getCausas() {
		return causas;
	}

	public void setCausas(String causas) {
		this.causas = causas;
	}

	public String getAceptado() {
		return aceptado;
	}

	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}

	public Double getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(Double indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Perito getPerito() {
		return perito;
	}

	public void setPerito(Perito perito) {
		this.perito = perito;
	}
}

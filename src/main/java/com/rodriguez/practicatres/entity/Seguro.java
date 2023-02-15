
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "SEGURO", schema = "SEGUNI")
public class Seguro implements Serializable {

	private static final long serialVersionUID = -1166060214266590796L;

	@Id
	@SequenceGenerator(schema = "SEGUNI", initialValue = 1, allocationSize = 1, name = "seguroSeq", sequenceName = "SEGURO_SEQ")
	@GeneratedValue(generator = "seguroSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "NUMERO_POLIZA")
	private Long numeroPoliza;

	@Column(name = "RAMO")
	private String ramo;

	@Column(name = "FECHA_INICIO")
	private String fechaInicio;

	@Column(name = "FECHA_VENCIMIENTO")
	private String fechaVencimiento;

	@Column(name = "CONDICIONES_PARTICULARES")
	private String condicionesParticulares;

	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@Column(name = "DNI_CL")
	private String dniCl;

	public Long getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Long numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCondicionesParticulares() {
		return condicionesParticulares;
	}

	public void setCondicionesParticulares(String condicionesParticulares) {
		this.condicionesParticulares = condicionesParticulares;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDniCl() {
		return dniCl;
	}

	public void setDniCl(String dniCl) {
		this.dniCl = dniCl;
	}

}

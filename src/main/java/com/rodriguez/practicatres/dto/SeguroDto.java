
package com.rodriguez.practicatres.dto;

import java.io.Serializable;

public class SeguroDto implements Serializable {

	private static final long serialVersionUID = 89561102274653484L;

	private Long numeroPoliza;
	private String ramo;
	private String fechaInicio;
	private String fechaVencimiento;
	private String condicionesParticulares;
	private String observaciones;
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

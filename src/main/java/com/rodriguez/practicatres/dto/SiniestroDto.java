
package com.rodriguez.practicatres.dto;

import java.io.Serializable;

public class SiniestroDto implements Serializable {

	private static final long serialVersionUID = -6750668116418331927L;

	private Long idSiniestro;
	private String fechaSiniestro;
	private String causas;
	private String aceptado;
	private Double indemnizacion;
	private SeguroDto seguroDto;
	private PeritoDto peritoDto;

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

	public SeguroDto getSeguroDto() {
		return seguroDto;
	}

	public void setSeguroDto(SeguroDto seguroDto) {
		this.seguroDto = seguroDto;
	}

	public PeritoDto getPeritoDto() {
		return peritoDto;
	}

	public void setPeritoDto(PeritoDto peritoDto) {
		this.peritoDto = peritoDto;
	}

}

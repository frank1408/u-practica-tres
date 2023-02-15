
package com.rodriguez.practicatres.dto;

import java.io.Serializable;

public class CompaniaDto implements Serializable {

	private static final long serialVersionUID = -5428940751571069311L;

	private String nombreCompania;
	private String claseVia;
	private String nombreVia;
	private String numeroVia;
	private String codigoPostal;
	private String telefonoContratacion;
	private String telefonoSiniestro;
	private String notas;

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getClaseVia() {
		return claseVia;
	}

	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(String numeroVia) {
		this.numeroVia = numeroVia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefonoContratacion() {
		return telefonoContratacion;
	}

	public void setTelefonoContratacion(String telefonoContratacion) {
		this.telefonoContratacion = telefonoContratacion;
	}

	public String getTelefonoSiniestro() {
		return telefonoSiniestro;
	}

	public void setTelefonoSiniestro(String telefonoSiniestro) {
		this.telefonoSiniestro = telefonoSiniestro;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

}

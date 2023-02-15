
package com.rodriguez.practicatres.dto;

import java.io.Serializable;

public class PeritoDto implements Serializable {

	private static final long serialVersionUID = -2289091714669855193L;

	private String dniPerito;
	private String nombrePerito;
	private String apellidoPerito1;
	private String apellidoPerito2;
	private String telefonoContacto;
	private String telefonoOficina;
	private String calleVia;
	private String nombreVia;
	private Long numeroVia;
	private String codigoPostal;
	private String ciudad;

	public String getDniPerito() {
		return dniPerito;
	}

	public void setDniPerito(String dniPerito) {
		this.dniPerito = dniPerito;
	}

	public String getNombrePerito() {
		return nombrePerito;
	}

	public void setNombrePerito(String nombrePerito) {
		this.nombrePerito = nombrePerito;
	}

	public String getApellidoPerito1() {
		return apellidoPerito1;
	}

	public void setApellidoPerito1(String apellidoPerito1) {
		this.apellidoPerito1 = apellidoPerito1;
	}

	public String getApellidoPerito2() {
		return apellidoPerito2;
	}

	public void setApellidoPerito2(String apellidoPerito2) {
		this.apellidoPerito2 = apellidoPerito2;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getTelefonoOficina() {
		return telefonoOficina;
	}

	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}

	public String getCalleVia() {
		return calleVia;
	}

	public void setCalleVia(String calleVia) {
		this.calleVia = calleVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public Long getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(Long numeroVia) {
		this.numeroVia = numeroVia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}

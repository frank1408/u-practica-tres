
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = -5936748654083010977L;

	private String dniCl;
	private String nombreCl;
	private String apellido1;
	private String apellido2;
	private String claseVia;
	private String nombreVia;
	private Long numeroVia;
	private String codigoPostal;
	private String ciudad;
	private String telefono;
	private String oberservaciones;
	private final List<SeguroDto> seguros = new ArrayList<>();

	public List<SeguroDto> getSeguros() {
		return seguros;
	}

	public String getDniCl() {
		return dniCl;
	}

	public void setDniCl(String dniCl) {
		this.dniCl = dniCl;
	}

	public String getNombreCl() {
		return nombreCl;
	}

	public void setNombreCl(String nombreCl) {
		this.nombreCl = nombreCl;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getOberservaciones() {
		return oberservaciones;
	}

	public void setOberservaciones(String oberservaciones) {
		this.oberservaciones = oberservaciones;
	}

}

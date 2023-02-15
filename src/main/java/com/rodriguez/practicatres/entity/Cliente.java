
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE", schema = "SEGUNI")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -633059216704908709L;

	@Id
	@Column(name = "DNI_CL", nullable = false, unique = true, length = 13)
	private String dniCl;

	@Column(name = "NOMBRE_CL")
	private String nombreCl;

	@Column(name = "APELLIDO_1")
	private String apellido1;

	@Column(name = "APELLIDO_2")
	private String apellido2;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private Long numeroVia;

	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name = "CIUDAD")
	private String ciudad;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "OBSERVACIONES")
	private String oberservaciones;

	@OneToMany(mappedBy = "dniCl", orphanRemoval = true, fetch = FetchType.EAGER)
	private final List<Seguro> seguros = new ArrayList<>();

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

	public List<Seguro> getSeguros() {
		return seguros;
	}
}

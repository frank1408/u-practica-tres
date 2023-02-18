
package com.rodriguez.practicatres.dto;

import java.io.Serializable;

public class CompaniaSeguroDto implements Serializable {

	private static final long serialVersionUID = -7063747058608553592L;

	private Long id;
	private Long numeroPoliza;
	private String nombreCompania;

	public Long getId() {
		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(Long numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
}

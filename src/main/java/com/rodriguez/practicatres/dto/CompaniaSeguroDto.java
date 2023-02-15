
package com.rodriguez.practicatres.dto;

import java.io.Serializable;

public class CompaniaSeguroDto implements Serializable {

	private static final long serialVersionUID = -7063747058608553592L;

	private Long id;
	private SeguroDto seguroDto;
	private CompaniaDto companiaDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SeguroDto getSeguroDto() {
		return seguroDto;
	}

	public void setSeguroDto(SeguroDto seguroDto) {
		this.seguroDto = seguroDto;
	}

	public CompaniaDto getCompaniaDto() {
		return companiaDto;
	}

	public void setCompaniaDto(CompaniaDto companiaDto) {
		this.companiaDto = companiaDto;
	}

}

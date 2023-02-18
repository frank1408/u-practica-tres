
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProcedimientoDto implements Serializable {
	
	private static final long serialVersionUID = 2912924366734437859L;
	
	private String estatus;
	private BigDecimal numA;
	
	public BigDecimal getNumA() {
		return numA;
	}
	public void setNumA(BigDecimal numA) {
		this.numA = numA;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}

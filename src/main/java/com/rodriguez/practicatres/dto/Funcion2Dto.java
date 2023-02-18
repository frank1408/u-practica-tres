
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Funcion2Dto implements Serializable {
	
	private static final long serialVersionUID = -7677027463995595561L;
	
	private Date retorno;

	private String outEstatus;
	
	private BigDecimal inoutNumber;

	public String getOutEstatus() {
		return outEstatus;
	}

	public void setOutEstatus(String outEstatus) {
		this.outEstatus = outEstatus;
	}

	public BigDecimal getInoutNumber() {
		return inoutNumber;
	}

	public void setInoutNumber(BigDecimal inoutNumber) {
		this.inoutNumber = inoutNumber;
	}

	public Date getRetorno() {
		return retorno;
	}

	public void setRetorno(Date retorno) {
		this.retorno = retorno;
	}
	
	
	
}


package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.util.Date;

public class FuncionDto implements Serializable {
	
	private static final long serialVersionUID = 1382961290955004847L;
	
	private String texto;
	private String salida;
	private Date retorno;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public Date getRetorno() {
		return retorno;
	}
	public void setRetorno(Date retorno) {
		this.retorno = retorno;
	}

}

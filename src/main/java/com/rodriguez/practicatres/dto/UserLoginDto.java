
package com.rodriguez.practicatres.dto;

import java.io.Serializable;

public class UserLoginDto implements Serializable {

	private static final long serialVersionUID = -306016538465519824L;

	private String usuario;
	private String contrasena;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}

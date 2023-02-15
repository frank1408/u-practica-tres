
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_LOGIN", schema = "SEGUNI")
public class UserLogin implements Serializable {

	private static final long serialVersionUID = 4897776014227149884L;

	@Id
	@Column(name = "USUARIO")
	private String usuario;

	@Column(name = "CONTRASENA")
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


package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USER_LOGIN", schema = "SEGUNI")
@Data
public class UserLogin implements Serializable {

	private static final long serialVersionUID = 4897776014227149884L;

	@Id
	@Column(name = "USUARIO")
	private String usuario;

	@Column(name = "CONTRASENA")
	private String contrasena;

}


package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserLoginDto implements Serializable {

	private static final long serialVersionUID = -306016538465519824L;

	private String usuario;
	private String contrasena;

}

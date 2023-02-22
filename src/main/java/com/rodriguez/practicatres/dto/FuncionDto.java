
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FuncionDto implements Serializable {

	private static final long serialVersionUID = 1382961290955004847L;

	private String texto;
	private String salida;
	private Date retorno;

}


package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class CompaniaDto implements Serializable {

	private static final long serialVersionUID = -5428940751571069311L;

	private String nombreCompania;
	private String claseVia;
	private String nombreVia;
	private String numeroVia;
	private String codigoPostal;
	private String telefonoContratacion;
	private String telefonoSiniestro;
	private String notas;

}

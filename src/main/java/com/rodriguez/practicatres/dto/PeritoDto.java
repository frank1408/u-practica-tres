
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class PeritoDto implements Serializable {

	private static final long serialVersionUID = -2289091714669855193L;

	private String dniPerito;
	private String nombrePerito;
	private String apellidoPerito1;
	private String apellidoPerito2;
	private String telefonoContacto;
	private String telefonoOficina;
	private String calleVia;
	private String nombreVia;
	private Long numeroVia;
	private String codigoPostal;
	private String ciudad;

}

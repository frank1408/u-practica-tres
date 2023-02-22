
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ClienteDto implements Serializable {

	private static final long serialVersionUID = -5936748654083010977L;

	private String dniCl;
	private String nombreCl;
	private String apellido1;
	private String apellido2;
	private String claseVia;
	private String nombreVia;
	private Long numeroVia;
	private String codigoPostal;
	private String ciudad;
	private String telefono;
	private String oberservaciones;
	private final List<SeguroDto> seguros = new ArrayList<>();

}

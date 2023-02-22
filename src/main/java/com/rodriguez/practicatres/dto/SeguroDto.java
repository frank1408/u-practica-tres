
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class SeguroDto implements Serializable {

	private static final long serialVersionUID = 89561102274653484L;

	private Long numeroPoliza;
	private String ramo;
	private String fechaInicio;
	private String fechaVencimiento;
	private String condicionesParticulares;
	private String observaciones;
	private String dniCl;

}


package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class SiniestroDto implements Serializable {

	private static final long serialVersionUID = -6750668116418331927L;

	private Long idSiniestro;
	private String fechaSiniestro;
	private String causas;
	private String aceptado;
	private Double indemnizacion;
	private SeguroDto seguroDto;
	private PeritoDto peritoDto;

}

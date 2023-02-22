
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class CompaniaSeguroDto implements Serializable {

	private static final long serialVersionUID = -7063747058608553592L;

	private Long id;
	private Long numeroPoliza;
	private String nombreCompania;

}

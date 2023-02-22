
package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProcedimientoDto implements Serializable {

	private static final long serialVersionUID = 2912924366734437859L;

	private String estatus;
	private BigDecimal numA;

}


package com.rodriguez.practicatres.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Funcion2Dto implements Serializable {

	private static final long serialVersionUID = -7677027463995595561L;

	private Date retorno;

	private String outEstatus;

	private BigDecimal inoutNumber;

}

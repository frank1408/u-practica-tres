
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COMPANIA_SEGURO", schema = "SEGUNI")
@Data
public class CompaniaSeguro implements Serializable {

	private static final long serialVersionUID = 6407755853374429021L;

	@Id
	@SequenceGenerator(schema = "SEGUNI", initialValue = 1, allocationSize = 1, name = "companiaSeguroSeq", sequenceName = "COMPANIA_SEGURO_SEQ")
	@GeneratedValue(generator = "companiaSeguroSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NUMERO_POLIZA", nullable = true)
	private Long numeroPoliza;

	@Column(name = "NOMBRE_COMPANIA", nullable = true)
	private String nombreCompania;

}

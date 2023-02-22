
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SINIESTRO", schema = "SEGUNI")
@Data
public class Siniestro implements Serializable {

	private static final long serialVersionUID = 636940018674376069L;

	@Id
	@SequenceGenerator(schema = "SEGUNI", initialValue = 1, allocationSize = 1, name = "siniestroSeq", sequenceName = "SINIESTRO_SEQ")
	@GeneratedValue(generator = "siniestroSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_SINIESTRO")
	private Long idSiniestro;

	@Column(name = "FECHA_SINIESTRO")
	private String fechaSiniestro;

	@Column(name = "CAUSAS")
	private String causas;

	@Column(name = "ACEPTADO")
	private String aceptado;

	@Column(name = "INDEMNIZACION")
	private Double indemnizacion;

	@ManyToOne
	private Seguro seguro;

	@ManyToOne
	private Perito perito;

}

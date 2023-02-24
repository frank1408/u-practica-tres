
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SEGURO", schema = "SEGUNI")
@Data
public class Seguro implements Serializable {

	private static final long serialVersionUID = -1166060214266590796L;

	@Id
	@SequenceGenerator(schema = "SEGUNI", initialValue = 1, allocationSize = 1, name = "seguroSeq", sequenceName = "SEGURO_SEQ")
	@GeneratedValue(generator = "seguroSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "NUMERO_POLIZA")
	private Long numeroPoliza;

	@Column(name = "RAMO")
	private String ramo;

	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;

	@Column(name = "FECHA_VENCIMIENTO")
	private Date fechaVencimiento;

	@Column(name = "CONDICIONES_PARTICULARES")
	private String condicionesParticulares;

	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@Column(name = "DNI_CL", nullable = true)
	private String dniCl;

	@ManyToMany(mappedBy = "seguros", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "seguros")
	private List<Compania> companias = new ArrayList<>();

}

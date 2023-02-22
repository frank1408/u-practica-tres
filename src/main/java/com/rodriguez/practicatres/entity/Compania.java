
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COMPANIA", schema = "SEGUNI")
@Data
public class Compania implements Serializable {

	private static final long serialVersionUID = 4897983171454778522L;

	@Id
	@Column(name = "NOMBRE_COMPANIA")
	private String nombreCompania;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private String numeroVia;

	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name = "TELEFONO_CONTRATACION")
	private String telefonoContratacion;

	@Column(name = "TELEFONO_SINIESTRO")
	private String telefonoSiniestro;

	@Column(name = "NOTAS")
	private String notas;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "COMPANIA_SEGURO", joinColumns = @JoinColumn(name = "NOMBRE_COMPANIA", nullable = true), inverseJoinColumns = @JoinColumn(name = "NUMERO_POLIZA", nullable = true))
	@JsonIgnoreProperties(value = "companias")
	private List<Seguro> seguros = new ArrayList<>();

}


package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENTE", schema = "SEGUNI")
@Data
public class Cliente implements Serializable {

	private static final long serialVersionUID = -633059216704908709L;

	@Id
	@Column(name = "DNI_CL", nullable = false, unique = true, length = 13)
	private String dniCl;

	@Column(name = "NOMBRE_CL")
	private String nombreCl;

	@Column(name = "APELLIDO_1")
	private String apellido1;

	@Column(name = "APELLIDO_2")
	private String apellido2;

	@Column(name = "CLASE_VIA")
	private String claseVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private Long numeroVia;

	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name = "CIUDAD")
	private String ciudad;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "OBSERVACIONES")
	private String oberservaciones;

	@OneToMany(mappedBy = "dniCl", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private final List<Seguro> seguros = new ArrayList<>();

}

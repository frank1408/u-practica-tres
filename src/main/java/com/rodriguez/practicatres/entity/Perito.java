
package com.rodriguez.practicatres.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PERITO", schema = "SEGUNI")
@Data
public class Perito implements Serializable {

	private static final long serialVersionUID = -7505548571505110857L;

	@Id
	@Column(name = "DNI_PERITO")
	private String dniPerito;

	@Column(name = "NOMBRE_PERITO")
	private String nombrePerito;

	@Column(name = "APELLIDO_PERITO_1")
	private String apellidoPerito1;

	@Column(name = "APELLIDO_PERITO_2")
	private String apellidoPerito2;

	@Column(name = "TELEFONO_CONTACTO")
	private String telefonoContacto;

	@Column(name = "TELEFONO_OFICINA")
	private String telefonoOficina;

	@Column(name = "CALLE_VIA")
	private String calleVia;

	@Column(name = "NOMBRE_VIA")
	private String nombreVia;

	@Column(name = "NUMERO_VIA")
	private Long numeroVia;

	@Column(name = "CODIGO_POSTAL")
	private String codigoPostal;

	@Column(name = "CIUDAD")
	private String ciudad;

}

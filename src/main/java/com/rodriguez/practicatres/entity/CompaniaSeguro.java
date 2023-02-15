
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

@Entity
@Table(name = "COMPANIA_SEGURO", schema = "SEGUNI")
public class CompaniaSeguro implements Serializable {

	private static final long serialVersionUID = 6407755853374429021L;

	@Id
	@SequenceGenerator(schema = "SEGUNI", initialValue = 1, allocationSize = 1, name = "companiaSeguroSeq", sequenceName = "COMPANIA_SEGURO_SEQ")
	@GeneratedValue(generator = "companiaSeguroSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	private Seguro seguro;

	@ManyToOne
	private Compania compania;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

}

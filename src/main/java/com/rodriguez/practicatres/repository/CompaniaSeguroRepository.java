
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libentity.entity.CompaniaSeguro;

@Repository("companiaSeguroRepository")
public interface CompaniaSeguroRepository extends JpaRepository<CompaniaSeguro, Serializable> {
	List<CompaniaSeguro> findByNumeroPolizaAndNombreCompania(Long numeroPoliza, String nombreCompania);
}

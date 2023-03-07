
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import libentity.entity.Siniestro;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Serializable> {

	List<Siniestro> findByFechaSiniestroStartingWith(String fechaSiniestro);

	List<Siniestro> findByCausasEquals(String causas);

	List<Siniestro> findByIndemnizacionLessThanEqual(Double indemnizacion);

	@Query(value = "SELECT * FROM SINIESTRO order by ID_SINIESTRO desc", countQuery = "SELECT COUNT(ID_SINIESTRO) FROM SINIESTRO", nativeQuery = true)
	Page<Siniestro> traerPorPagina(Pageable pageable);

}

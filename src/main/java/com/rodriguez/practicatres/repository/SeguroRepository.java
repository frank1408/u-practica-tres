
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rodriguez.practicatres.entity.Seguro;

@Repository("seguroRepository")
public interface SeguroRepository extends JpaRepository<Seguro, Serializable> {

	List<Seguro> findByFechaVencimientoBefore(Date fechaVencimiento);

	List<Seguro> findByCondicionesParticulares(String condicionesParticulares);

	List<Seguro> findByObservacionesContaining(String observaciones);

	@Query(value = "SELECT * FROM SEGURO order by NUMERO_POLIZA desc", countQuery = "SELECT COUNT(NUMERO_POLIZA) FROM SEGURO", nativeQuery = true)
	Page<Seguro> traerPorPagina(Pageable pageable);

}

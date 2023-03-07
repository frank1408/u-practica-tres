
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libentity.entity.Perito;

@Repository("peritoRepository")
public interface PeritoRepository extends JpaRepository<Perito, Serializable> {

	List<Perito> findByCiudadLike(String ciudad);

	List<Perito> findByCodigoPostalEquals(String codigoPostal);

}

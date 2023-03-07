
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import libentity.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {

	List<Cliente> findByNombreClContaining(String nombreCl);

	List<Cliente> findByApellido1IgnoreCase(String apellido1);

	List<Cliente> findByCiudadNot(String ciudad);

}

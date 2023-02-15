
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.practicatres.entity.CompaniaSeguro;

@Repository("companiaSeguroRepository")
public interface CompaniaSeguroRepository extends JpaRepository<CompaniaSeguro, Serializable> {
}

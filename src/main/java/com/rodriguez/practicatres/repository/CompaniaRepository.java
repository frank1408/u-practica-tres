
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.practicatres.entity.Compania;

@Repository("companiaRepository")
public interface CompaniaRepository extends JpaRepository<Compania, Serializable> {
}

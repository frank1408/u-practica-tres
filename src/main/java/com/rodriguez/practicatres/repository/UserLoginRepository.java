
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libentity.entity.UserLogin;

@Repository("userLoginRepository")
public interface UserLoginRepository extends JpaRepository<UserLogin, Serializable> {
	Optional<UserLogin> findByUsuarioAndContrasena(String usuario, String contrasena);
}

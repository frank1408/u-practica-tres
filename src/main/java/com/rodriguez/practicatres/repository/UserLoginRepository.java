
package com.rodriguez.practicatres.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rodriguez.practicatres.entity.UserLogin;

@Repository("userLoginRepository")
public interface UserLoginRepository extends JpaRepository<UserLogin, Serializable> {
	public UserLogin findByUsuarioAndContrasena(String usuario, String contrasena);
}

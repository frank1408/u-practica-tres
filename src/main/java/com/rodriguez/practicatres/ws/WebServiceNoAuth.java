
package com.rodriguez.practicatres.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rodriguez.practicatres.dto.TokenDto;
import com.rodriguez.practicatres.dto.UserLoginDto;
import com.rodriguez.practicatres.entity.UserLogin;
import com.rodriguez.practicatres.repository.UserLoginRepository;
import com.rodriguez.practicatres.security.TokenJwt;
import com.rodriguez.practicatres.wsint.IWebServiceNoAuth;

@Component
public class WebServiceNoAuth implements IWebServiceNoAuth {

	@Autowired
	UserLoginRepository userLoginRepository;

	@Autowired
	TokenJwt tokenJwt;
	


	@Override
	public TokenDto postLogin(UserLoginDto userLoginDto) {

		UserLogin userLogin = userLoginRepository.findByUsuarioAndContrasena(userLoginDto.getUsuario(),
				userLoginDto.getContrasena());

		if (userLogin == null) {
			return null;
		}

		final String ttoken = tokenJwt.generateToken(userLogin.getUsuario());
		TokenDto tt = new TokenDto();
		tt.setToken(ttoken);
		return tt;
	}

	@Override
	public UserLogin postLoginGuardar(UserLoginDto userLoginDto) {
		UserLogin userLogin = new UserLogin();
		userLogin.setContrasena(userLoginDto.getContrasena());
		userLogin.setUsuario(userLoginDto.getUsuario());
		return userLoginRepository.save(userLogin);
	}
	



}

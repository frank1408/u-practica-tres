
package com.rodriguez.practicatres.ws;

import java.util.Optional;
import org.modelmapper.ModelMapper;
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

		Optional<UserLogin> userLogin = userLoginRepository.findByUsuarioAndContrasena(userLoginDto.getUsuario(),
				userLoginDto.getContrasena());

		if (!userLogin.isPresent()) {
			return null;
		}

		TokenDto tt = new TokenDto();
		tt.setToken(  tokenJwt.generateToken(  userLogin.get().getUsuario()  )  );
		return tt;
	}

	@Override
	public UserLogin postLoginGuardar(UserLoginDto userLoginDto) {
		ModelMapper modelMapper = new ModelMapper();
		UserLogin userLogin = new UserLogin();
		modelMapper.map(userLoginDto, userLogin);
		return userLoginRepository.save(userLogin);
	}

}

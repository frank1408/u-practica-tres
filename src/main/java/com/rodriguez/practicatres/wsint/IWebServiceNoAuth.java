
package com.rodriguez.practicatres.wsint;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rodriguez.practicatres.dto.TokenDto;
import com.rodriguez.practicatres.dto.UserLoginDto;

import libentity.entity.UserLogin;

@RestController
@CrossOrigin
@RequestMapping("/noauth")
public interface IWebServiceNoAuth {
	@PostMapping("/login")
	public TokenDto postLogin(@RequestBody UserLoginDto userLoginDto);

	@PostMapping("/register")
	public UserLogin postLoginGuardar(@RequestBody UserLoginDto userLoginDto);

}

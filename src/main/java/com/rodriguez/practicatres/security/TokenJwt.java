
package com.rodriguez.practicatres.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenJwt implements Serializable {

	private static final long serialVersionUID = 5413804469582766219L;

	private static final long MILISEGUNDOS_DE_VALIDEZ = (long) 1000 * 3600 * 8;

	private static final String SECRET = "AA79FA97FA97DF7AS97FD79ADFA96DF6AA79FA97FA97DF7AS97FD79ADFA96DF6";

	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return generateToken(username, claims);
	}

	public String generateToken(String username, Map<String, Object> claims) {
		final Long milisegundoActual = System.currentTimeMillis();
		return Jwts.builder().setSubject(username).setClaims(claims).setIssuedAt(new Date(milisegundoActual))
				.setExpiration(new Date(milisegundoActual + MILISEGUNDOS_DE_VALIDEZ))
				.signWith(SignatureAlgorithm.HS256, SECRET).compact();
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}

	public Boolean isTokenExpired(String token) {
		final Date expiration = getClaimFromToken(token, Claims::getExpiration);
		return expiration.before(new Date(System.currentTimeMillis()));
	}

}

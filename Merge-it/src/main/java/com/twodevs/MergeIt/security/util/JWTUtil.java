package com.twodevs.MergeIt.security.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTUtil {
	
	private String SECRET_KEY = "E?%68zm7pT_y)?[?}e,vaD+08ub`9{Q\"w_sr0T/$E3zy0+`e)\"]uOf[O*z)6%Vk";
	
	private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	private Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}
	
	// Generates a token given the claims, the username and setting the expiration time on 10hs
	private String createToken(Map<String,Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
			   .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	
}

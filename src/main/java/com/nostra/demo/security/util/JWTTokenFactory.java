package com.nostra.demo.security.util;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import com.nostra.demo.security.auth.AccessJWTToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JWTTokenFactory {
	
	private final Key key;
	
	
	public AccessJWTToken createAccessJWTToken(String username, Collection<? extends GrantedAuthority> collection) {
		
		if (StringUtils.isBlank(username))
			throw new IllegalArgumentException("Cannot create JWT Token without username");

		if (collection == null || collection.isEmpty())
			throw new  IllegalArgumentException("User doesn't have any privileges");
			
		Claims claims =  Jwts.claims().setSubject(username);	
		claims.put("scopes", collection.stream().map(s -> s.getAuthority()).collect(Collectors.toList()));
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime expiredTime = currentTime.plusMinutes(15);
		Date curretTimeDate = Date.from(currentTime.atZone(ZoneId.of("Asia/Jakarta")).toInstant());
		Date expiredTimeDate = Date.from(expiredTime.atZone(ZoneId.of("Asia/Jakarta")).toInstant());

		String token = Jwts.builder()
		.setClaims(claims)
		.setIssuer("http://nostratech.com").setIssuedAt(curretTimeDate)
		.setExpiration(expiredTimeDate)
		.signWith(key, SignatureAlgorithm.HS256).compact();
		
		
		return new AccessJWTToken(token, claims);
		
	}

}

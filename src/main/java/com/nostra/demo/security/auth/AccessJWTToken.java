package com.nostra.demo.security.auth;

import io.jsonwebtoken.Claims;

public class AccessJWTToken implements Token{
	
	private final String rawToken;
	
	private Claims claims;
	

	
	public AccessJWTToken(String rawToken, Claims claims) {
		super();
		this.rawToken = rawToken;
		this.claims = claims;
	}


	public Claims getClaims() {
		return claims;
	}

	@Override
	public String getToken() {
		return this.rawToken;
	}

}

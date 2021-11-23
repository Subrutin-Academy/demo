package com.nostra.demo.exception;

import org.springframework.security.core.AuthenticationException;

import com.nostra.demo.security.auth.Token;





public class JwtExpiredTokenException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8474032168083618639L;

	private Token token;

	public JwtExpiredTokenException(String msg) {
		super(msg);
	}

	public JwtExpiredTokenException(Token token, String msg, Throwable t) {
		super(msg, t);
		this.token = token;
	}

	public String token() {
		return this.token.getToken();
	}

}

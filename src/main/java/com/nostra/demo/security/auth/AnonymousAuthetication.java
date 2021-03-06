package com.nostra.demo.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnonymousAuthetication extends AbstractAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6173067793992880464L;

	public AnonymousAuthetication() {
		super(null);
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}
}

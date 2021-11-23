package com.nostra.demo.security.auth;

import java.io.Serializable;
import java.security.Key;

import org.springframework.security.authentication.BadCredentialsException;

import com.nostra.demo.exception.JwtExpiredTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@SuppressWarnings("deprecation")
public class RawAccessJwtToken implements Token, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1672737865414606640L;
	private String token;	
    public RawAccessJwtToken(String token) {
        this.token = token;
    }
    
    public Jws<Claims> parseClaims(Key signingKey) {
        try {
            return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException| SignatureException ex) {
//            log.error("Invalid JWT Token");
            throw new BadCredentialsException("Invalid JWT token");
        } catch (ExpiredJwtException expiredEx) {
//            log.info("JWT Token is expired", expiredEx);
            throw new JwtExpiredTokenException(this, "JWT Token expired", expiredEx);
        }
        
    }

    @Override
    public String getToken() {
        return token;
    }

}

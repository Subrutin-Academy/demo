package com.nostra.demo.config;

import java.security.Key;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nostra.demo.security.util.JWTTokenFactory;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Configuration
public class ApplicationConfig {

	@Bean
	public Key key() {
		byte[] keyBytes = Decoders.BASE64.decode("qewiejqwehjewhkjwqehjewhqwe892813732873218932178923");
		return Keys.hmacShaKeyFor(keyBytes);

	}
	
	@Bean
	public JWTTokenFactory jwtTokenFactory(Key key) {
		return new JWTTokenFactory(key);
		
	}
	@Bean
	public ObjectMapper objectMapper() {
		
		return new ObjectMapper();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
}

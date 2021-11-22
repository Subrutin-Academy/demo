package com.nostra.demo.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nostra.demo.dto.ErrorResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UsernamePasswordAuthFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);	
		mapper.writeValue(response.getWriter(),
				ErrorResponseDTO.of("Authentication failed"));
	}

}

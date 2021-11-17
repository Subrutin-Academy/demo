package com.nostra.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nostra.demo.dto.ErrorResponseDTO;

@ControllerAdvice
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());
		ErrorResponseDTO dto = ErrorResponseDTO.of("data not found", details);
		
		return ResponseEntity.badRequest().body(dto);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for(ObjectError error:ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponseDTO dto = ErrorResponseDTO.of("invalid request", details);
		
		return ResponseEntity.badRequest().body(dto);
	}

}

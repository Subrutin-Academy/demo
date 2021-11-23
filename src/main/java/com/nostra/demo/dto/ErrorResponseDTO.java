package com.nostra.demo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7372394398755383201L;

	private Date timestamp;
	
	private String message;
	
	private List<String> details;

	public ErrorResponseDTO(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = new Date();
	}
	
	
	public ErrorResponseDTO(String message) {
		super();
		this.message = message;
		this.timestamp = new Date();

	}
	
	public static ErrorResponseDTO of(final String message, List<String> details) {
		return new ErrorResponseDTO(message, details);
	}
	
	public static ErrorResponseDTO of(final String message) {
		return new ErrorResponseDTO(message);
	}






}

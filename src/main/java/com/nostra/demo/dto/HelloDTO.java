package com.nostra.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class HelloDTO {
	
	@JsonProperty("msg")
	private String message;

	
	

}

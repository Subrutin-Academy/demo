package com.nostra.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AuthorCreateRequestDTO {
	
	private String name;
	
	private Long birthDate;

}

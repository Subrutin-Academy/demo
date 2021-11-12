package com.nostra.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.nostra.demo.service.validator.annotation.ValidName;

import lombok.Data;

@Data
public class AuthorCreateRequestDTO {
	
	@ValidName
	@NotBlank
	private String name;
	
	private Long birthDate;

}

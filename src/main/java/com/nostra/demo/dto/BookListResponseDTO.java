package com.nostra.demo.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

@Data
public class BookListResponseDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 859906286456262286L;

	private Long id;
	
	private String title;
	
	private String publisherName;
	
	private Set<String> authorsName;
}

package com.nostra.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookQueryDTO {
	
	private Long bookId;
	
	private String title;
	
	private String publisherName;
	
	private String description;

}

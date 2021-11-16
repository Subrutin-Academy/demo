package com.nostra.demo.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class BookCreateRequestDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5358642069985222389L;

	private String title;
	
	private String description;
	
	private Set<Long> authorIds;
	
	private Long publisherId;
	

}

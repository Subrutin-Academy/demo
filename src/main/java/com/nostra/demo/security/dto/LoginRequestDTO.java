package com.nostra.demo.security.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5668150424520161469L;

	private String username;
	
	private String password;
}

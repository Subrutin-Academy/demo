package com.nostra.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nostra.demo.domain.AppUser;


public interface AppUserService extends UserDetailsService{
	
	public AppUser findCurrentUser();
	
	

}

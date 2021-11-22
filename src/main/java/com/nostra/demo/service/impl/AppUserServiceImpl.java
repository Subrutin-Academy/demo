package com.nostra.demo.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nostra.demo.domain.AppUser;
import com.nostra.demo.repository.AppUserRepository;
import com.nostra.demo.service.AppUserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

	private final AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return appUserRepository.findOneByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("invalid.username"));
	}

	@Override
	public AppUser findCurrentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		log.info("username {}", username);
		

		return appUserRepository.findOneByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("invalid.username"));
	}

}

package com.nostra.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.demo.domain.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
	public Optional<AppUser> findOneByUsername(String username);

}

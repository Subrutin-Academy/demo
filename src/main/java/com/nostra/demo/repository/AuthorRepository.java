package com.nostra.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.demo.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	

}

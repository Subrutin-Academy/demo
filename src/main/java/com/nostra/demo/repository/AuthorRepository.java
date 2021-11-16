package com.nostra.demo.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.demo.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	Set<Author> findByIdIn(Set<Long> authorIds);
	
	

}

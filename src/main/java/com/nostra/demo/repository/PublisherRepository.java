package com.nostra.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.demo.domain.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	Optional<Publisher> findOneById(Long id);
}

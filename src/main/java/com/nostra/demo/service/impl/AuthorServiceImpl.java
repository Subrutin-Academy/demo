package com.nostra.demo.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nostra.demo.domain.Author;
import com.nostra.demo.dto.AuthorCreateRequestDTO;
import com.nostra.demo.dto.AuthorDetailResponseDTO;
import com.nostra.demo.exception.ResourceNotFoundException;
import com.nostra.demo.repository.AuthorRepository;
import com.nostra.demo.service.AuthorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService{
	
	private final AuthorRepository authorRepository;

	@Override
	public void createNewAuthor(AuthorCreateRequestDTO dto) {
		Author author = new Author();
		author.setName(dto.getName());
		author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
		authorRepository.save(author);
		
		
	}

	@Override
	public AuthorDetailResponseDTO findAuthorDetail(Long id) {
	 	Author author =  authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("author not found"));
	 	AuthorDetailResponseDTO dto = new AuthorDetailResponseDTO();
	 	dto.setAuthorName(author.getName());
	 	dto.setBirthDate(author.getBirthDate().toEpochDay());
		return dto;
	}

}

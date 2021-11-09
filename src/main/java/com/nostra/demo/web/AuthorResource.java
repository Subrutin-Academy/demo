package com.nostra.demo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nostra.demo.dto.AuthorCreateRequestDTO;
import com.nostra.demo.service.AuthorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AuthorResource {

	private final AuthorService authorService;
	
	@PostMapping("/v1/author")
	public ResponseEntity<Void> createAuthor(@RequestBody AuthorCreateRequestDTO dto){
	
		authorService.createNewAuthor(dto);
		return ResponseEntity.ok().build();
	}
}

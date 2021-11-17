package com.nostra.demo.web;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nostra.demo.dto.AuthorCreateRequestDTO;
import com.nostra.demo.dto.AuthorDetailResponseDTO;
import com.nostra.demo.service.AuthorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AuthorResource {

	private final AuthorService authorService;

	@PreAuthorize("hasRole('ADMINS')")
	@PostMapping("/v1/author")
	public ResponseEntity<Void> createAuthor(@RequestBody @Valid AuthorCreateRequestDTO dto) {

		authorService.createNewAuthor(dto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/v1/author/{authorId}")
	public ResponseEntity<AuthorDetailResponseDTO> findAuthorById(@PathVariable Long authorId) {

		return ResponseEntity.ok().body(authorService.findAuthorDetail(authorId));
	}
}

package com.nostra.demo.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nostra.demo.dto.BookListResponseDTO;
import com.nostra.demo.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class BookResource {

	private final BookService bookService;

	@GetMapping("/v1/book")
	public ResponseEntity<List<BookListResponseDTO>> findBooKlist(
			@RequestParam(name = "title", defaultValue = "", required = true) String bookTitle) {

		return ResponseEntity.ok().body(bookService.findBookList(bookTitle));
	}
}

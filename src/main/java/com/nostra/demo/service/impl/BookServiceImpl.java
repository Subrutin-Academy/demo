package com.nostra.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nostra.demo.domain.Book;
import com.nostra.demo.dto.BookListResponseDTO;
import com.nostra.demo.dto.BookQueryDTO;
import com.nostra.demo.repository.BookRepository;
import com.nostra.demo.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService{
	
	private final BookRepository bookRepository;

	@Override
	public List<BookListResponseDTO> findBookList(String title) {
		
		title = title + "%";
//		List<Book> books =  bookRepository.findByBookTitle(title);
		List<BookQueryDTO> books =  bookRepository.findByBookTitleWithJoin(title);
		return books.stream().map((b)->{
			BookListResponseDTO dto = new BookListResponseDTO();
			dto.setId(b.getBookId());
			dto.setPublisherName(b.getPublisherName());
			dto.setTitle(b.getTitle());
			return dto;
		}).collect(Collectors.toList());
	}

}

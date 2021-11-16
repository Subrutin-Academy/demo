package com.nostra.demo.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nostra.demo.domain.Author;
import com.nostra.demo.domain.Book;
import com.nostra.demo.domain.Publisher;
import com.nostra.demo.dto.BookCreateRequestDTO;
import com.nostra.demo.dto.BookListResponseDTO;
import com.nostra.demo.dto.BookQueryDTO;
import com.nostra.demo.exception.ResourceNotFoundException;
import com.nostra.demo.repository.AuthorRepository;
import com.nostra.demo.repository.BookRepository;
import com.nostra.demo.repository.PublisherRepository;
import com.nostra.demo.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	private final AuthorRepository authorRepository;

	private final PublisherRepository publisherRepository;

	@Override
	public List<BookListResponseDTO> findBookList(String title) {

		title = title + "%";
//		List<Book> books =  bookRepository.findByBookTitle(title);
		List<BookQueryDTO> books = bookRepository.findByBookTitleWithJoin(title);
		return books.stream().map((b) -> {
			BookListResponseDTO dto = new BookListResponseDTO();
			dto.setId(b.getBookId());
			dto.setPublisherName(b.getPublisherName());
			dto.setTitle(b.getTitle());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void createNewBook(BookCreateRequestDTO dto) {
		Set<Author> authors = authorRepository.findByIdIn(dto.getAuthorIds());

//		Publisher publisher = publisherRepository.findOneById(dto.getPublisherId())
//				.orElseThrow(() -> new ResourceNotFoundException("invalid.publisher.id"));
		Publisher publisher = new Publisher();
		//property
		Book book = new Book();
		book.setAuthors(authors);
		book.setPublisher(publisher);
		book.setTitle(dto.getTitle());
		book.setDescription(dto.getDescription());
		bookRepository.save(book);
		

	}

}

package com.nostra.demo.service;

import java.util.List;

import com.nostra.demo.dto.BookListResponseDTO;

public interface BookService {
	
	public List<BookListResponseDTO> findBookList(String title);

}

package com.nostra.demo.service;

import com.nostra.demo.dto.AuthorCreateRequestDTO;
import com.nostra.demo.dto.AuthorDetailResponseDTO;

public interface AuthorService {
	
	public void createNewAuthor(AuthorCreateRequestDTO dto);
	
	public AuthorDetailResponseDTO findAuthorDetail(Long id);

}

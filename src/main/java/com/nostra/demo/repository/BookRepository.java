package com.nostra.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nostra.demo.domain.Book;
import com.nostra.demo.dto.BookQueryDTO;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	//konvensi spring data  findByXXXXXX
	
	public List<Book> findByTitleLikeIgnoreCase(String title);
	
	//jpql / native = sql
	@Query("SELECT b FROM Book b WHERE b.title LIKE :title")
	public List<Book> findByBookTitle(String title);
	
	//jpa projection
	@Query("SELECT new com.nostra.demo.dto.BookQueryDTO(b.id, b.title, p.name, b.description) "
			+ "FROM Book b "
			+ "INNER JOIN Publisher p ON p.id = b.publisher.id "
			+ "WHERE b.title LIKE :title")
	public List<BookQueryDTO> findByBookTitleWithJoin(String title);
	
	//bikin table view
	
	

}

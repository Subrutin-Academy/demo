package com.nostra.demo.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany
	@JoinTable(name = "book_author", joinColumns = {
			@JoinColumn(name="book_id", referencedColumnName = "id")
	}, inverseJoinColumns = {
			@JoinColumn(name="author_id", referencedColumnName = "id")
	})
	private Set<Author> authors;
}

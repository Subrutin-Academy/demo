package com.nostra.demo.domain;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class Author extends AbstractBaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, columnDefinition = "VARCHAR(500)")
	private String name;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@ManyToMany(mappedBy = "authors")
	public Set<Book> books;
	

}

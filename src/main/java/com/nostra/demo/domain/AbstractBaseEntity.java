package com.nostra.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public abstract class AbstractBaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3963627764051465877L;

	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDate createdDate;
	
	@CreatedBy
	@Column(name = "created_by", nullable = false, updatable = false)
	private String createdBy;
	
	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDate modifiedDate;
	
	@LastModifiedBy
	@Column(name = "modified_by")
	private String modifiedBy;
	

}

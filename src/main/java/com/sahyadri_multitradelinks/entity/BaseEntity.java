package com.sahyadri_multitradelinks.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

	@Column
	private Integer createdBy;

	@Column(name = "created_date" ,nullable = false)
	private LocalDateTime createdDate = LocalDateTime.now(); // Default value

	@Column(name = "updated_date" ,nullable = true)
	private LocalDateTime updatedDate ; // Default value

	@Column
	private Integer updatedBy;

	@Column
	private Boolean isActive;

	@Column
	private Boolean isDeleted;
}

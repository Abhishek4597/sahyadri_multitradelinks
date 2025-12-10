package com.sahyadri_multitradelinks.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GemCategoryDTO {

	private Integer id;
	private String name;
	private String category_type;
	private String description;
	private Integer createdBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private Integer updatedBy;
	private Boolean isActive;
	private Boolean isDeleted;
}

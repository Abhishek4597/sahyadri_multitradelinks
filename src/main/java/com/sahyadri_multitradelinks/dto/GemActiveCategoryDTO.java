package com.sahyadri_multitradelinks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GemActiveCategoryDTO {

	private Integer id;
	private String name;
	private String category_type;
	private String description;
	private Boolean isActive;

}

package com.sahyadri_multitradelinks.service;

import java.util.List;

import com.sahyadri_multitradelinks.dto.GemActiveCategoryDTO;
import com.sahyadri_multitradelinks.dto.GemCategoryDTO;
import com.sahyadri_multitradelinks.entity.GemCategory;

public interface GemCategoryService {

	public Boolean SaveGemCategory(GemCategoryDTO gemCategoryDTO);

	public List<GemCategory> GetAllGemCategory();

	public List<GemActiveCategoryDTO> GetActiveGemCategory();

}
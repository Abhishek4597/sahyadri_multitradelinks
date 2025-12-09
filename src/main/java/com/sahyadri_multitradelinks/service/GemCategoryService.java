package com.sahyadri_multitradelinks.service;

import java.util.List;

import com.sahyadri_multitradelinks.entity.GemCategory;

public interface GemCategoryService {

	public Boolean SaveGemCategory(GemCategory gemCategory);

	public List<GemCategory> GetAllGemCAtegory();

}
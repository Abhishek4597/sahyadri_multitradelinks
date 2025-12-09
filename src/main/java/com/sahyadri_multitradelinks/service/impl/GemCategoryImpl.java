package com.sahyadri_multitradelinks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.sahyadri_multitradelinks.entity.GemCategory;
import com.sahyadri_multitradelinks.repository.GemCategoryRepository;
import com.sahyadri_multitradelinks.service.GemCategoryService;
@Service
public class GemCategoryImpl implements GemCategoryService {

	@Autowired
	private GemCategoryRepository gemCategoryRepository;

	@Override
	public Boolean SaveGemCategory(GemCategory gemCategory) {
		gemCategory.setIsDeleted(false);
		gemCategory.setCreatedBy(1);

		GemCategory saveGemCategory = gemCategoryRepository.save(gemCategory);
		if (ObjectUtils.isEmpty(saveGemCategory)) {
			return false;
		}
		return true;
	}

	@Override
	public List<GemCategory> GetAllGemCAtegory() {

		List<GemCategory> gemCategories = gemCategoryRepository.findAll();

		return gemCategories;
	}

}

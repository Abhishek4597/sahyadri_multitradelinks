package com.sahyadri_multitradelinks.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.sahyadri_multitradelinks.dto.GemActiveCategoryDTO;
import com.sahyadri_multitradelinks.dto.GemCategoryDTO;
import com.sahyadri_multitradelinks.entity.GemCategory;
import com.sahyadri_multitradelinks.repository.GemCategoryRepository;
import com.sahyadri_multitradelinks.service.GemCategoryService;
import java.time.LocalDateTime;

@Service
public class GemCategoryImpl implements GemCategoryService {

	@Autowired
	private GemCategoryRepository gemCategoryRepository;

	@Autowired
	private ModelMapper mapper;

	public Boolean SaveGemCategory(GemCategoryDTO gemCategoryDTO) {

//		GemCategory gemCategory = new GemCategory();
//		gemCategory.setName(gemCategoryDTO.getName());
//		gemCategory.setCategory_type(gemCategoryDTO.getCategory_type());
//		gemCategory.setDescription(gemCategoryDTO.getDescription());
//		gemCategory.setIsActive(gemCategoryDTO.getIsActive());

		GemCategory gemCategory = mapper.map(gemCategoryDTO, GemCategory.class);

		gemCategory.setIsDeleted(false);
		gemCategory.setCreatedBy(1);
		gemCategory.setCreatedDate(LocalDateTime.now());
		GemCategory saveGemCategory = gemCategoryRepository.save(gemCategory);
		if (ObjectUtils.isEmpty(saveGemCategory))
			return false;

		else {
			return true;
		}
	}

	public List<GemCategory> GetAllGemCategory() {
		List<GemCategory> gemCategories = gemCategoryRepository.findAll();
		return gemCategories;
	}

	@Override
	public List<GemActiveCategoryDTO> GetActiveGemCategory() {
		List<GemCategory> gemCategories = gemCategoryRepository.findByIsActiveTrue();
		List<GemActiveCategoryDTO> activeCategoryList = gemCategories.stream()
				.map(cat -> mapper.map(cat, GemActiveCategoryDTO.class)).toList();
		return activeCategoryList;
	}

}

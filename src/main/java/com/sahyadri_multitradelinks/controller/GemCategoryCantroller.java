package com.sahyadri_multitradelinks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahyadri_multitradelinks.entity.GemCategory;
import com.sahyadri_multitradelinks.repository.GemCategoryRepository;
import com.sahyadri_multitradelinks.service.GemCategoryService;

@RestController
@RequestMapping("/api/GemCategory")
public class GemCategoryCantroller {

	private final GemCategoryRepository gemCategoryRepository;

	@Autowired
	private GemCategoryService gemCategoryService;

	GemCategoryCantroller(GemCategoryRepository gemCategoryRepository) {
		this.gemCategoryRepository = gemCategoryRepository;
	}

	@PostMapping("/save-gem-category")
	public ResponseEntity<?> SaveAllGemCategory(@RequestBody GemCategory gemCategory) {

		Boolean SaveAllGemCategory = gemCategoryService.SaveGemCategory(gemCategory);
		
		if (SaveAllGemCategory) {
			return new ResponseEntity<>("Saved...", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Not Saved....", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

    @GetMapping("/get-gem-category")
	public ResponseEntity<?> GetAllGemCategory() {

		List<GemCategory> getAllGemCategories = gemCategoryService.GetAllGemCAtegory();

		if (CollectionUtils.isEmpty(getAllGemCategories)) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(getAllGemCategories, HttpStatus.OK);
		}
	}

}

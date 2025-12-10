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

import com.sahyadri_multitradelinks.dto.GemActiveCategoryDTO;
import com.sahyadri_multitradelinks.dto.GemCategoryDTO;
import com.sahyadri_multitradelinks.entity.GemCategory;
import com.sahyadri_multitradelinks.service.GemCategoryService;

@RestController
@RequestMapping("/api/GemCategory")
public class GemCategoryController { // Fixed spelling from "Cantroller" to "Controller"

	@Autowired
	private GemCategoryService gemCategoryService;

	@PostMapping("/save-gem-category")
	public ResponseEntity<?> saveGemCategory(@RequestBody GemCategoryDTO gemCategoryDTO) {
		try {
			Boolean savedCategory = gemCategoryService.SaveGemCategory(gemCategoryDTO);
			return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error saving category: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get-gem-category")
	public ResponseEntity<?> getAllGemCategory() {
		List<GemCategory> categories = gemCategoryService.GetAllGemCategory();

		if (CollectionUtils.isEmpty(categories)) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(categories, HttpStatus.OK);
		}
	}

	@GetMapping("/active-category")
	public ResponseEntity<?> getActiveCategory() {
		List<GemActiveCategoryDTO> categories = gemCategoryService.GetActiveGemCategory();

		if (CollectionUtils.isEmpty(categories)) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(categories, HttpStatus.OK);
		}
	}
}
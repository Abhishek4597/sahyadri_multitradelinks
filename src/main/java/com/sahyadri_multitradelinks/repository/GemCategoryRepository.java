package com.sahyadri_multitradelinks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahyadri_multitradelinks.entity.GemCategory;

public interface GemCategoryRepository extends JpaRepository<GemCategory, Integer> {

	List<GemCategory> findByIsActiveTrue();

}

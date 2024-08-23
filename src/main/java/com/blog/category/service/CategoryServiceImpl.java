package com.blog.category.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.category.dao.CategoryDao;
import com.blog.category.dto.CategoryDto;
import com.blog.category.entity.Category;
import com.blog.category.model.CategoryModel;
import com.blog.common.mapper.Mapper;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private Mapper mapper;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<CategoryModel> saveCategories(List<CategoryDto> categoriesDtos) {

		List<CategoryModel> categoryModels = new ArrayList<>();
		if (categoriesDtos != null && !categoriesDtos.isEmpty()) {
			categoryModels = categoriesDtos.stream().map(categoriesDto -> {
				CategoryModel categoryModel = new CategoryModel();
				if (categoriesDto != null) {

					Category category = mapper.convert(categoriesDto, Category.class);
					category.setUuid(UUID.randomUUID().toString().format("-", ""));
					category = categoryDao.saveCategory(category);
					categoryModel = mapper.convert(category, CategoryModel.class);
				}
				return categoryModel;
			}).collect(Collectors.toList());
		}

		return categoryModels;
	}

	@Override
	public CategoryModel updateCategory(CategoryDto categoryDto, String categoryUuid) {

		Category category = categoryDao.getCategoryUsingUuid(categoryUuid);

		category.setTitle(categoryDto.getTitle());
		category.setIsActive(categoryDto.getIsActive());
		category.setDescription(categoryDto.getDescription());
		category = categoryDao.saveCategory(category);

		return mapper.convert(category, CategoryModel.class);
	}

	@Override
	public CategoryModel getCategoryUsingUuid(String categoryUuid) {
		return mapper.convert(categoryDao.getCategoryUsingUuid(categoryUuid), CategoryModel.class);
	}

	@Override
	public List<CategoryModel> getCategoryList(int page) {
		return mapper.convertToList(categoryDao.getCategoryList(page), CategoryModel.class);
	}

	@Override
	public void deleteCategory(String categoryUuid) {
		Category category=categoryDao.getCategoryUsingUuid(categoryUuid);
		categoryDao.delteCategory(category);
		

	}

	@Override
	public List<CategoryModel> searchCategory(String searchText) {
		List<Category> categories=categoryDao.searchCategory(searchText);
		return mapper.convertToList(categories, CategoryModel.class);
	}

}

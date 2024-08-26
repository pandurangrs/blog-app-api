package com.blog.category.service;

import java.util.List;

import com.blog.category.dto.CategoryDto;
import com.blog.category.model.CategoryModel;
import com.blog.category.model.CategoryResponse;

public interface CategoryService {
	
	List<CategoryModel> saveCategories(List<CategoryDto> categoriesDtos);
	
	CategoryModel updateCategory(CategoryDto categoryDto,String categoryUuid);
	
	CategoryModel getCategoryUsingUuid(String categoryUuid);
	
	CategoryResponse getCategoryList(Integer pageNumber,Integer pageSize);
	
	void deleteCategory(String categoryUuid);

	List<CategoryModel> searchCategory(String searchText);
}

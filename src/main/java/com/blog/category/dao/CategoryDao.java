package com.blog.category.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.blog.category.entity.Category;
public interface CategoryDao {

	Category saveCategory(Category category);
	
	Category getCategoryUsingUuid(String categoryUuid);
	
	Page<Category> getCategoryList(Integer pageNumber,Integer pageSize);
	
	void delteCategory(Category category);

	List<Category> searchCategory(String searchText);
}

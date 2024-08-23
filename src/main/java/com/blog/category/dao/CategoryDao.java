package com.blog.category.dao;

import com.blog.category.entity.Category;
import java.util.List;
public interface CategoryDao {

	Category saveCategory(Category category);
	
	Category getCategoryUsingUuid(String categoryUuid);
	
	List<Category> getCategoryList(int page);
	
	void delteCategory(Category category);

	List<Category> searchCategory(String searchText);
}

package com.blog.category.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.blog.category.entity.Category;
import com.blog.category.repo.CategoryRepo;
import com.blog.common.exception.ResourceNotFoundException;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryUsingUuid(String categoryUuid) {
		
		return categoryRepo.findByUuid(categoryUuid).orElseThrow(() -> new ResourceNotFoundException("Category","categoryUuid",categoryUuid));
	}

	@Override
	public List<Category> getCategoryList(int page) {
		
		return categoryRepo.findByIsActiveTrue(PageRequest.of(--page, 5));
	}

	@Override
	public void delteCategory(Category category) {
		categoryRepo.delete(category);

	}

	@Override
	public List<Category> searchCategory(String searchText) {
//		List<Category> categories=categoryRepo.searchByTitle("%"+searchText+"%",true);
		return null;
	}

}

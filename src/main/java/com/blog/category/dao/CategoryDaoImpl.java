package com.blog.category.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

		return categoryRepo.findByUuid(categoryUuid)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryUuid", categoryUuid));
	}

	@Override
	public Page<Category> getCategoryList(Integer pageNumber,Integer pageSize) {

		return categoryRepo.findByIsActiveTrue(PageRequest.of(--pageNumber, pageSize));
	}

	@Override
	public void delteCategory(Category category) {
		categoryRepo.delete(category);

	}

	@Override
	public List<Category> searchCategory(String searchText) {
		return categoryRepo.searchByTitle(searchText, true);

	}

}

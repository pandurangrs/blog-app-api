package com.blog.category.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blog.category.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

	Optional<Category> findByUuid(String categoryUuid);

	Page<Category> findByIsActiveTrue(Pageable pageable);

	@Query("select c from Category c where c.title LIKE %:searchText% AND c.isActive = :b")
	List<Category> searchByTitle(String searchText, boolean b);

}

package com.blog.category.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.category.dto.CategoryDto;
import com.blog.category.model.CategoryModel;
import com.blog.category.service.CategoryService;
import com.blog.common.constant.UrlMapping;
import com.blog.common.payload.ApiResponse;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	//Save Categories
	
	@PostMapping(UrlMapping.CATEGORIES)
	public ResponseEntity<List<CategoryModel>> saveCategories(@Valid @RequestBody List<CategoryDto> categoryDtos){
		List<CategoryModel> categoryModels=categoryService.saveCategories(categoryDtos);
		return new ResponseEntity<>(categoryModels,HttpStatus.CREATED);
	}
	
	//Get CategoryUsing uuid
	@GetMapping(UrlMapping.CATEGORY_UUID)
	public ResponseEntity<CategoryModel> getCategoryUsingUuid(@PathVariable String categoryUuid){
		CategoryModel categoryModel=categoryService.getCategoryUsingUuid(categoryUuid);
		return new ResponseEntity<>(categoryModel,HttpStatus.OK);
	}
	
	//Get Category List
	
	@GetMapping(UrlMapping.CATEGORIES)
	public ResponseEntity<List<CategoryModel>> getCategoriesList(@RequestParam(defaultValue = "1", name = "page") int page){
	 List<CategoryModel> categoryModels=categoryService.getCategoryList(page);
	 return new ResponseEntity<>(categoryModels,HttpStatus.OK);
	}
	
	
	
	//Update Category
	@PutMapping(UrlMapping.CATEGORY_UUID)
	public ResponseEntity<CategoryModel> updateCategory(@RequestBody CategoryDto categoryDto,String categoryUuid){
		CategoryModel categoryModel=categoryService.updateCategory(categoryDto, categoryUuid);
		return new ResponseEntity<>(categoryModel,HttpStatus.OK);
	}
	
	
	//Delete Category
	@DeleteMapping(UrlMapping.CATEGORY_UUID)
	public ResponseEntity<ApiResponse> deleteCategory(String categoryUuid){
		categoryService.deleteCategory(categoryUuid);
		return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully.",true),HttpStatus.OK);
	}
	
	//search Category
	
	@GetMapping(UrlMapping.SEARCH_CATEGORY)
	public ResponseEntity<List<CategoryModel>> searchCategory(@RequestParam String searchText){
		List<CategoryModel> categoryModels=categoryService.searchCategory(searchText);
		return new ResponseEntity<>(categoryModels,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

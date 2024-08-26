package com.blog.category.model;

import java.util.List;

import com.blog.common.payload.PaginationResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryResponse extends PaginationResponse {
	private List<CategoryModel> categoryModels;

}

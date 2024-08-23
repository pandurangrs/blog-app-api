package com.blog.category.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

	private String uuid;

	private String title;

	private Boolean isActive;
	
	private String description;
}

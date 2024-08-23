package com.blog.category.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	@NotEmpty
	@Size(min = 2,message = "Title must be min 2 characters")
	private String title;

	private Boolean isActive;
	
	private String description;
	
}

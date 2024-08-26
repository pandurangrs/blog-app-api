package com.blog.post.model;

import java.util.Date;
import java.util.Set;

import com.blog.category.model.CategoryModel;
import com.blog.comment.model.CommentModel;
import com.blog.user.model.UserModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class PostModel{
	private String uuid;

	private String title;

	private String content;

	private Date postDate;

	private Date expiredDate;
	
	private Boolean isActive;

	private CategoryModel category;

	private UserModel user;
	
	private String postImage;
	
//	private Set<CommentModel> comments;
}

package com.blog.post.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

	private String title;

	private String content;

	private Date postDate;

	private Date expiredDate;
	
	private Boolean isActive;

	private String categoryUuid;

	private String userUuid;
	
	private String postImage;
}

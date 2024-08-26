package com.blog.post.model;

import java.util.List;

import com.blog.common.payload.PaginationResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse extends PaginationResponse{
	private List<PostModel> postModels;
	
}

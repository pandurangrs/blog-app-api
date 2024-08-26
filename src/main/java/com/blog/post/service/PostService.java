package com.blog.post.service;

import java.util.List;

import com.blog.post.dto.PostDto;
import com.blog.post.model.PostModel;
import com.blog.post.model.PostResponse;

public interface PostService {
	
	PostModel savePost(PostDto postDto);
	
	PostModel getPostUsingUuid(String postUuid);
	
	PostModel updatePost(PostDto postDto,String postUuid);
	
	void deletePost(String postUuid);
	
	PostResponse getAllPost(Integer pageSize,Integer pageNumber,String userUuid, String sortBy, String sortDir);

	List<PostModel> searchPost(String searchText);
	
	//get all post By category
	
	
	//get all post by user

}

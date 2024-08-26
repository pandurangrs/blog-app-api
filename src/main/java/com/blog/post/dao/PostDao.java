package com.blog.post.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.blog.post.entity.Post;

public interface PostDao {

	Post savePost(Post post);

	Post getPostUsingUuid(String postUuid);

	void deletePost(Post post);

	Page<Post> getAllPost(Integer pageSize,Integer pageNumber,String userUuid,String sortBy, String sortDir);

	List<Post> searchPost(String searchText);

}

package com.blog.post.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.blog.category.dao.CategoryDao;
import com.blog.category.entity.Category;
import com.blog.common.mapper.Mapper;
import com.blog.post.dao.PostDao;
import com.blog.post.dto.PostDto;
import com.blog.post.entity.Post;
import com.blog.post.model.PostModel;
import com.blog.post.model.PostResponse;
import com.blog.user.dao.UserDao;
import com.blog.user.entity.User;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private Mapper mapper;

	@Autowired
	private PostDao postDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public PostModel savePost(PostDto postDto) {

		Post post = mapper.convert(postDto, Post.class);
		post.setUuid(UUID.randomUUID().toString());
		if (postDto.getUserUuid() != null) {
			User user = userDao.getUserUsingUuid(postDto.getUserUuid());
			post.setUser(user);
		}

		if (postDto.getCategoryUuid() != null) {
			Category category = categoryDao.getCategoryUsingUuid(postDto.getCategoryUuid());
			post.setCategory(category);
		}

		return mapper.convert(postDao.savePost(post), PostModel.class);
	}

	@Override
	public PostModel getPostUsingUuid(String postUuid) {
		Post post = postDao.getPostUsingUuid(postUuid);
		return mapper.convert(post, PostModel.class);
	}

	@Override
	public PostModel updatePost(PostDto postDto, String postUuid) {

		Post post = postDao.getPostUsingUuid(postUuid);
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setExpiredDate(postDto.getExpiredDate());
		post.setUpdatedAt(new Date());
		post.setIsActive(postDto.getIsActive());
		post.setPostImage(postDto.getPostImage());
		if (postDto.getUserUuid() != null) {
			User user = userDao.getUserUsingUuid(postDto.getUserUuid());
			post.setUser(user);
		}

		if (postDto.getCategoryUuid() != null) {
			Category category = categoryDao.getCategoryUsingUuid(postDto.getCategoryUuid());
			post.setCategory(category);
		}
		return mapper.convert(postDao.savePost(post), PostModel.class);
	}

	@Override
	public void deletePost(String postUuid) {
		Post post = postDao.getPostUsingUuid(postUuid);
		postDao.deletePost(post);

	}

	@Override
	public PostResponse getAllPost(Integer pageSize, Integer pageNumber, String userUuid,String sortBy, String sortDir) {
		Page<Post> pagePosts = postDao.getAllPost(pageSize, pageNumber, userUuid,sortBy,sortDir);
		List<Post> posts = pagePosts.getContent();
		List<PostModel> postModels = mapper.convertToList(posts, PostModel.class);
		PostResponse postResponse = new PostResponse();
		postResponse.setPostModels(postModels);
		buildPagePost(postResponse, pagePosts);
		return postResponse;
	}

	private void buildPagePost(PostResponse postResponse, Page<Post> pagePosts) {
		postResponse.setPageNumber(pagePosts.getNumber());
		postResponse.setPageSize(pagePosts.getSize());
		postResponse.setTotalElements(pagePosts.getTotalElements());
		postResponse.setTotalPages(pagePosts.getTotalPages());
		postResponse.setLastPage(pagePosts.isLast());

	}

	@Override
	public List<PostModel> searchPost(String searchText) {
		List<Post> posts = postDao.searchPost(searchText);
		return mapper.convertToList(posts, PostModel.class);
	}

}

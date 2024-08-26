package com.blog.post.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.blog.common.exception.ResourceNotFoundException;
import com.blog.post.entity.Post;
import com.blog.post.repo.PostRepo;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private PostRepo postRepo;

	@Override
	public Post savePost(Post post) {
		return postRepo.save(post);
	}

	@Override
	public Post getPostUsingUuid(String postUuid) {
		return postRepo.findByUuid(postUuid)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postUuid", postUuid));
	}

	@Override
	public void deletePost(Post post) {

		try {
			postRepo.delete(post);
		} catch (Exception e) {
			throw new ResourceNotFoundException("An error occurred while attempting to delete the data. ",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public Page<Post> getAllPost(Integer pageSize,Integer pageNumber,String userUuid,String sortBy, String sortDir) {
		
		Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Page<Post> posts=postRepo.getPostList(userUuid,PageRequest.of(--pageNumber, pageSize,sort),true);
		return posts;
	}

	@Override
	public List<Post> searchPost(String searchText) {
		
		return postRepo.searchPost(searchText,true);
	}

}

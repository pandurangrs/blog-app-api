package com.blog.comment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.blog.comment.entity.Comment;
import com.blog.comment.repo.CommentRepo;
import com.blog.common.exception.ResourceNotFoundException;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	private CommentRepo commentRepo;

	@Override
	public Comment saveComment(Comment comment) {

		return commentRepo.save(comment);
	}

	@Override
	public Comment getComentUsingUuid(String commentUuid) {

		return commentRepo.findByUuid(commentUuid)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "commentUuid", commentUuid));
	}

	@Override
	public void deleteComment(Comment comment) {
		try {
			commentRepo.delete(comment);
		} catch (Exception e) {
			throw new ResourceNotFoundException("An error occurred while attempting to delete the data.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

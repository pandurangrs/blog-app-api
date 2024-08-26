package com.blog.comment.service;

import com.blog.comment.dto.CommentDto;
import com.blog.comment.model.CommentModel;

public interface CommentService {
	
	CommentModel saveComment(CommentDto commentDto);
	
	void deleteComment(String commentUuid);

}

package com.blog.comment.dao;

import com.blog.comment.entity.Comment;

public interface CommentDao {

	Comment saveComment(Comment comment);
	Comment getComentUsingUuid(String commentUuid);
	
	void deleteComment(Comment comment);
	
}

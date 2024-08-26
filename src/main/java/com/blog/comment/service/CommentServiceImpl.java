package com.blog.comment.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.comment.dao.CommentDao;
import com.blog.comment.dto.CommentDto;
import com.blog.comment.entity.Comment;
import com.blog.comment.model.CommentModel;
import com.blog.common.mapper.Mapper;
import com.blog.post.dao.PostDao;
import com.blog.post.entity.Post;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private Mapper mapper;

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private PostDao postDao;

	@Override
	public CommentModel saveComment(CommentDto commentDto) {

		Comment comment = mapper.convert(commentDto, Comment.class);
		comment.setUuid(UUID.randomUUID().toString());
		Post post=postDao.getPostUsingUuid(commentDto.getPostUuid());
		comment.setPost(post);		
		comment = commentDao.saveComment(comment);
		
		return mapper.convert(comment, CommentModel.class);
	}

	@Override
	public void deleteComment(String commentUuid) {
		Comment comment = commentDao.getComentUsingUuid(commentUuid);
		commentDao.deleteComment(comment);
	}

}

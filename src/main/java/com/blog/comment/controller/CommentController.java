package com.blog.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.comment.dto.CommentDto;
import com.blog.comment.model.CommentModel;
import com.blog.comment.service.CommentService;
import com.blog.common.constant.UrlMapping;
import com.blog.common.payload.ApiResponse;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping(UrlMapping.COMMENTS)
	public ResponseEntity<CommentModel> saveComments(@RequestBody CommentDto commentDto) {
		CommentModel commentModel = commentService.saveComment(commentDto);
		return new ResponseEntity<>(commentModel, HttpStatus.CREATED);
	}

	@DeleteMapping(UrlMapping.COMMENTS_UUID)
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable String commentUuid) {
		commentService.deleteComment(commentUuid);
		return new ResponseEntity<>(new ApiResponse("Comment Deleted Successfully.", true), HttpStatus.OK);
	}

}

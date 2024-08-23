package com.blog.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	private HttpStatus status;

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format(" %s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldName;
	}
	
	public ResourceNotFoundException(String message,HttpStatus status) {
		super(message);
		this.status=status;
	}
}

package com.blog.user.service;

import com.blog.user.dto.UserDto;
import com.blog.user.model.UserModel;
import com.blog.user.model.UserResponse;

public interface UserService {

	
	UserModel saveUser(UserDto userDto);
	
	UserModel updateUser(UserDto userDto,String userUuid);
	
	UserModel getUserUsingUuid(String userUuid);
	
	void deleteUser(String userUuid);

	UserResponse getUserList(Integer pageNumber, Integer pageSize);
}

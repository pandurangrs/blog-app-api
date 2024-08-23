package com.blog.user.service;

import java.util.List;

import com.blog.user.dto.UserDto;
import com.blog.user.model.UserModel;

public interface UserService {

	
	UserModel saveUser(UserDto userDto);
	
	UserModel updateUser(UserDto userDto,String userUuid);
	
	UserModel getUserUsingUuid(String userUuid);
	
	void deleteUser(String userUuid);

	List<UserModel> getUserList(int page);
}

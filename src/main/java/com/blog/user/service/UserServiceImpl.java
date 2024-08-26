package com.blog.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.blog.common.mapper.Mapper;
import com.blog.user.dao.UserDao;
import com.blog.user.dto.UserDto;
import com.blog.user.entity.User;
import com.blog.user.model.UserModel;
import com.blog.user.model.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private Mapper mapper;

	@Override
	public UserModel saveUser(UserDto userDto) {
		UserModel userModel = new UserModel();
		if (userDto != null) {
			User user = mapper.convert(userDto, User.class);
			user.setUuid(UUID.randomUUID().toString());
			user = userDao.saveUser(user);
			userModel = mapper.convert(user, UserModel.class);
		}

		return userModel;
	}

	@Override
	public UserModel updateUser(UserDto userDto, String userUuid) {
		UserModel userModel = new UserModel();
		if (userDto != null) {
			User user = userDao.getUserUsingUuid(userUuid);
			user.setAddress(userDto.getAddress());
			user.setEmail(userDto.getEmail());
			user.setIsActive(userDto.getIsActive());
			user.setMobile(userDto.getMobile());
			user.setName(userDto.getName());
			user.setPassword(userDto.getPassword());
			user = userDao.saveUser(user);
			userModel = mapper.convert(user, UserModel.class);
		}

		return userModel;
	}

	@Override
	public UserModel getUserUsingUuid(String userUuid) {
		return mapper.convert(userDao.getUserUsingUuid(userUuid), UserModel.class);
	}

	@Override
	public void deleteUser(String userUuid) {
		User user = userDao.getUserUsingUuid(userUuid);
		userDao.deleteUser(user);

	}

	@Override
	public UserResponse getUserList(Integer pageNumber, Integer pageSize) {
		Page<User> pagePost = userDao.getUserList(pageNumber, pageSize);
		List<User> users = pagePost.getContent();
		List<UserModel> userModels = mapper.convertToList(users, UserModel.class);
		UserResponse userResponse = new UserResponse();
		userResponse.setUserModels(userModels);
		buildUserResponse(userResponse, pagePost);

		return userResponse;
	}

	private void buildUserResponse(UserResponse userResponse, Page<User> pagePost) {
		userResponse.setPageNumber(pagePost.getNumber());
		userResponse.setPageSize(pagePost.getSize());
		userResponse.setTotalElements(pagePost.getTotalElements());
		userResponse.setTotalPages(pagePost.getTotalPages());
		userResponse.setLastPage(pagePost.isLast());
	}

}

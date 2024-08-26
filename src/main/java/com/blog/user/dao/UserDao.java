package com.blog.user.dao;

import org.springframework.data.domain.Page;

import com.blog.user.entity.User;

public interface UserDao {
	User saveUser(User user);

	User getUserUsingUuid(String userUuid);

	void deleteUser(User user);

	Page<User> getUserList(Integer pageNumber, Integer pageSize);
}

package com.blog.user.dao;

import java.util.List;

import com.blog.user.entity.User;

public interface UserDao {
	User saveUser(User user);

	User getUserUsingUuid(String userUuid);

	void deleteUser(User user);

	List<User> getUserList(int page);
}

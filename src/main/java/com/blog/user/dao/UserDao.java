package com.blog.user.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.blog.common.entity.Role;
import com.blog.user.entity.User;

public interface UserDao {
	User saveUser(User user);

	User getUserUsingUuid(String userUuid);

	void deleteUser(User user);

	Page<User> getUserList(Integer pageNumber, Integer pageSize);

	Optional<Role> getRoles();

	Boolean checkEmailExists(String email);
}

package com.blog.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.blog.common.exception.ResourceNotFoundException;
import com.blog.user.entity.User;
import com.blog.user.repo.UserRepo;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {

		return userRepo.save(user);
	}

	@Override
	public User getUserUsingUuid(String userUuid) {

		return userRepo.findByUuid(userUuid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userUuid", userUuid));
	}

	@Override
	public void deleteUser(User user) {

		try {
			userRepo.delete(user);
		} catch (Exception e) {
			throw new ResourceNotFoundException("An error occurred while attempting to delete the data. ",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public Page<User> getUserList(Integer pageNumber, Integer pageSize) {

		return userRepo.findByIsActiveTrue(PageRequest.of(--pageNumber, pageSize));
	}

}

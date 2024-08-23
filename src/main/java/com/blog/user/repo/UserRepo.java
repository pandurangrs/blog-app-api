package com.blog.user.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.user.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByUuid(String userUuid);

	List<User> findByIsActiveTrue(Pageable pageable);

}

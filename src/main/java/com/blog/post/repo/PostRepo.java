package com.blog.post.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.post.entity.Post;


public interface PostRepo extends JpaRepository<Post, Long>{

	Optional<Post> findByUuid(String postUuid);
	
	@Query("select p from Post p where p.userUuid = :userUuid AND p.isActive = :b")
	Page<Post> getPostList(@Param("userUuid") String userUuid,Pageable pageable,boolean b);

	@Query("select p from Post p where p.title LIKE %:searchText% AND p.isActive = :b")
	List<Post> searchPost(String searchText,boolean b);

}

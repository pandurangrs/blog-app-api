package com.blog.comment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.blog.comment.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long>{

	Optional<Comment> findByUuid(String commentUuid);

}

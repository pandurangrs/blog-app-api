package com.blog.post.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.blog.category.entity.Category;
import com.blog.comment.entity.Comment;
import com.blog.common.entity.Audit;
import com.blog.user.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Post extends Audit {

	private static final long serialVersionUID = 1L;

	@Column
	private String uuid;

	@Column(nullable = false)
	private String title;

	@Column(length = 1000)
	private String content;

	@Column
	private Date postDate;

	@Column
	private Boolean isActive;

	@Column
	private Date expiredDate;

	@ManyToOne
	private Category category;

	@ManyToOne
	private User user;

	@Column
	private String userUuid;
	
	@Column
	private String postImage;
	
	@OneToMany(mappedBy="post",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Comment> comments=new HashSet<>();
	

}

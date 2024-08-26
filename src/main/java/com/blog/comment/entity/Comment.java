package com.blog.comment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.blog.common.entity.Audit;
import com.blog.post.entity.Post;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "comment")
@Data
@EqualsAndHashCode(callSuper = true)
public class Comment extends Audit {

	private static final long serialVersionUID = 1L;

	@Column
	private String uuid;

	@Column(length = 500)
	private String content;

	@Column
	private String imageUrl;

	@ManyToOne
	private Post post;

	@Column
	private String isActive;

	@Column
	private String userUuid;

	@Column
	private String postUuid;

}

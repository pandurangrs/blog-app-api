package com.blog.user.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.blog.common.entity.Audit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Audit {

	private static final long serialVersionUID = 1L;

	private String uuid;

	private String name;

	private String mobile;

	private String email;

	private String password;

	private Boolean isActive;

	private String address;
	
	private String about;


}

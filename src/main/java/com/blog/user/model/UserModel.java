package com.blog.user.model;

import java.util.HashSet;
import java.util.Set;

import com.blog.common.model.RoleModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

	private String uuid;

	private String name;

	private String mobile;

	private String email;

	@JsonIgnore
	private String password;
	
	private Boolean isActive;

	private String address;
	
	private String about;
	
	private Set<RoleModel> roles = new HashSet<>();


	
	
	
}

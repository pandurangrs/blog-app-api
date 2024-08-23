package com.blog.user.model;

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

	private String password;

	private Boolean isActive;

	private String address;
	
	private String about;


	
	
	
}

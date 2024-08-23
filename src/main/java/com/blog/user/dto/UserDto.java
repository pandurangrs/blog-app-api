package com.blog.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	@NotEmpty
	@Size(min = 2, message = "UserName must be min 4 characters !!")
	private String name;

	@NotEmpty
	@Size(min = 10,max=12, message = "Mobile no size must be 12 digit")
	private String mobile;

	@Email(message = "Email address is not valid !!")
	private String email;

	@Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
	private String password;

	private Boolean isActive;

	@NotEmpty
	private String address;
	
	@NotEmpty
	private String about;

}

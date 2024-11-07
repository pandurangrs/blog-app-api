package com.blog.common.constant;

public class Constants {
	
	private Constants() {
		super();
	}

	public static final String ROLE_ADMIN="hasAnyRole('ROLE_ADMIN')";
	public static final String ROLE_NORMAL="hasAnyRole('ROLE_NORMAL')";
	public static final String ROLE_NORMAL_AND_ADMIN="hasAnyRole('ROLE_ADMIN','ROLE_NORMAL')";
}

package com.blog.common.constant;

public class UrlMapping {

	
	private UrlMapping() {
		super();
	}
	
	public static final String BASE_URL="blog/api/";
	
	//User
	public static final String USERS="users";
	public static final String USERS_UUID=USERS+"/{userUuid}";
	
	//Category
	public static final String CATEGORIES="categories";
	public static final String CATEGORY_UUID=CATEGORIES+"/{categoryUuid}";
	public static final String SEARCH_CATEGORY=CATEGORIES+"/search";
	
	
}

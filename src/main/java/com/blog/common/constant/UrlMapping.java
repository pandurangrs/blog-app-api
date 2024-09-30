package com.blog.common.constant;

public class UrlMapping {

	
	private UrlMapping() {
		super();
	}
	
	public static final String BASE_URL="/api/blog";
	public static final String API_V1_AUTH="api/v1/auth/";
	
	//User
	public static final String USERS="users";
	public static final String USERS_UUID=USERS+"/{userUuid}";
	public static final String USER_LOGIN="login";
	
	//Category
	public static final String CATEGORIES="categories";
	public static final String CATEGORY_UUID=CATEGORIES+"/{categoryUuid}";
	public static final String SEARCH_CATEGORY=CATEGORIES+"-search";
	
	//post
	public static final String POSTS="posts";
	public static final String POST_UUID=POSTS+"/{postUuid}";
	public static final String SEARCH_POST=POSTS+"-search";
	public static final String POST_FILE_UPLOAD=POSTS+"-file-upload/{postUuid}";
	public static final String SERVE_POST_IMAGE=POSTS+"-image-serve/{imageName}";
	
	
	//comment
	public static final String COMMENTS="comments";
	public static final String COMMENTS_UUID=COMMENTS+"/{commentsUuid}";
	
	
}

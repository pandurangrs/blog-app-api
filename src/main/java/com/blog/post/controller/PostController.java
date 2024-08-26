package com.blog.post.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.common.constant.AppConstant;
import com.blog.common.constant.UrlMapping;
import com.blog.common.mapper.Mapper;
import com.blog.common.payload.ApiResponse;
import com.blog.post.dto.PostDto;
import com.blog.post.model.PostModel;
import com.blog.post.model.PostResponse;
import com.blog.post.service.FileService;
import com.blog.post.service.PostService;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

//	@Value("${project.imag}")
//	private String path;

	@Autowired
	private Mapper mapper;
	
//	public final String path = "";
	public final String UPLOAD_DIR = "F:\\Pandurang_Dev\\Spring-Boot-Dev-Tools\\blog-app-api\\src\\main\\resources\\static\\image";



	@PostMapping(UrlMapping.POSTS)
	public ResponseEntity<PostModel> savePost(@RequestBody PostDto postDto) {
		PostModel postModel = postService.savePost(postDto);
		return new ResponseEntity<>(postModel, HttpStatus.CREATED);
	}

	@GetMapping(UrlMapping.POST_UUID)
	public ResponseEntity<PostModel> getPostUsingUuid(@PathVariable String postUuid) {
		PostModel postModel = postService.getPostUsingUuid(postUuid);
		return new ResponseEntity<>(postModel, HttpStatus.OK);
	}

	@PutMapping(UrlMapping.POST_UUID)
	public ResponseEntity<PostModel> updatePost(@RequestBody PostDto postDto, @PathVariable String postUuid) {
		PostModel postModel = postService.updatePost(postDto, postUuid);
		return new ResponseEntity<>(postModel, HttpStatus.OK);
	}

	@DeleteMapping(UrlMapping.POST_UUID)
	public ResponseEntity<ApiResponse> deletePost(@PathVariable String postUuid) {
		postService.deletePost(postUuid);
		return new ResponseEntity<>(new ApiResponse("Post Deleted Successfully.", true), HttpStatus.OK);
	}

	@GetMapping(UrlMapping.POSTS)
	public ResponseEntity<PostResponse> getPostList(
			@RequestParam(value = "pageSize", defaultValue = AppConstant.PSOT_PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstant.SORT_DIR, required = false) String sortDir,
			@RequestParam String userUuid) {
		PostResponse postResponse = postService.getAllPost(pageSize, pageNumber, userUuid, sortBy, sortDir);
		return new ResponseEntity<>(postResponse, HttpStatus.OK);
	}

	@GetMapping(UrlMapping.SEARCH_POST)
	public ResponseEntity<List<PostModel>> searchPost(@RequestParam String searchText) {
		List<PostModel> proModels = postService.searchPost(searchText);
		return new ResponseEntity<>(proModels, HttpStatus.OK);
	}

	@PostMapping(UrlMapping.POST_FILE_UPLOAD)
	public ResponseEntity<PostModel> uploadImage(@RequestParam(value = "file") MultipartFile file,
			@PathVariable String postUuid) throws IOException {
		PostModel postModel = postService.getPostUsingUuid(postUuid);
		String name = fileService.uploadImage(UPLOAD_DIR, file);
		PostDto postDto = mapper.convert(postModel, PostDto.class);
		postDto.setPostImage(name);
		postModel = postService.updatePost(postDto, postUuid);
		return new ResponseEntity<>(postModel, HttpStatus.OK);

	}
	
	@GetMapping(value=UrlMapping.SERVE_POST_IMAGE,produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName,HttpServletResponse response) throws IOException {
		 InputStream resource=this.fileService.getResource(UPLOAD_DIR, imageName);
		 response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
		
	
	
	}
	

}

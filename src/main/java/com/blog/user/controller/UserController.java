package com.blog.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.blog.common.constant.UrlMapping;
import com.blog.common.payload.ApiResponse;
import com.blog.user.dto.UserDto;
import com.blog.user.model.UserModel;
import com.blog.user.service.UserService;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(UrlMapping.USERS)
	public ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
	}

	@GetMapping(UrlMapping.USERS_UUID)
	public ResponseEntity<UserModel> getUserUsingUuid(@PathVariable String userUuid) {
		return new ResponseEntity<>(userService.getUserUsingUuid(userUuid), HttpStatus.OK);
	}

	@PutMapping(UrlMapping.USERS_UUID)
	public ResponseEntity<UserModel> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable String userUuid) {
		UserModel userModel = userService.updateUser(userDto, userUuid);
		return new ResponseEntity<>(userModel, HttpStatus.OK);
	}

	@GetMapping(UrlMapping.USERS)
	public ResponseEntity<List<UserModel>> getUserList(@RequestParam(name="page",defaultValue = "1",required = false) int page){
		List<UserModel> userModels=userService.getUserList(page);
		return new ResponseEntity<>(userModels,HttpStatus.OK);
	}

	@DeleteMapping(UrlMapping.USERS_UUID)
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userUuid) {
		userService.deleteUser(userUuid);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}

}

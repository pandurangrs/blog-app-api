package com.blog.common.payload;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JwtAuthResponse {

	private String token;
}

package com.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@PropertySource(value="classpath:/profiles/${spring.profiles.active}/application.properties")
public class BlogAppApiApplication implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println(passwordEncoder.encode("om111"));
	}

}

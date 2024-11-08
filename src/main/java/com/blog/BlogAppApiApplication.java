package com.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.common.constant.AppConstant;
import com.blog.common.entity.Role;
import com.blog.common.repository.RoleRepository;

@SpringBootApplication
@PropertySource(value="classpath:/profiles/${spring.profiles.active}/application.properties")
public class BlogAppApiApplication implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println(passwordEncoder.encode("om111"));
		
		try {
			Role role=new Role();
			role.setId(AppConstant.ROLE_ADMIN);
			role.setRole("ROLE_ADMIN");
			
			Role role1=new Role();
			role1.setId(AppConstant.ROLE_NORMAL);
			role1.setRole("ROLE_NORMAL");
			
			List<Role> roles=new ArrayList<>();
			roles.add(role);
			roles.add(role1);
			List<Role> result = this.roleRepository.saveAll(roles);
		
			result.forEach(r ->{
				System.out.println(r.getRole());
			});
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

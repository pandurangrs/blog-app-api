package com.blog.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.common.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

//	Role findById(Long roleNormal);

}

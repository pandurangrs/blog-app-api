package com.blog.category.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.blog.common.entity.Audit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="category")
@Data
@EqualsAndHashCode(callSuper=true)
public class Category extends Audit{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String uuid;
	
	@Column
	private String title;
	
	@Column
	private Boolean isActive;
	
	@Column
	private String description;
	

}

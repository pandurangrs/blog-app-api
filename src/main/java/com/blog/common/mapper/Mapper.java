package com.blog.common.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.blog.common.exception.ResourceNotFoundException;

@Component
public class Mapper {

	@Autowired
	private ModelMapper modelMapper;

	public <T> T convert(Object srcObj, Class<T> targetClass) {
		T response = null;

		try {
			response = modelMapper.map(srcObj, targetClass);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Entity not convert properly", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	public <S, T> List<T> convertToList(List<S> srcObj, Class<T> targetClass) {
		List<T> response = null;

		try {
			response = srcObj.stream().map(r -> modelMapper.map(r, targetClass)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ResourceNotFoundException("Data not convert properly", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}

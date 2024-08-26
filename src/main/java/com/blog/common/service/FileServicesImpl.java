package com.blog.common.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServicesImpl implements FileServices {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		// File name
		String name = file.getOriginalFilename();

		// random name generate file
		String rendomId = UUID.randomUUID().toString();
		String fileName = rendomId.concat(name.substring(name.lastIndexOf(".")));

		// full Path
		String filePath = path + File.separator + fileName;

		// create folder if not created
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}

		// file Copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return name;

	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath=path+ File.separator+fileName;
		
		InputStream is=new FileInputStream(fullPath);
		//do logic to return inputstream
		
		return is;
	}

}

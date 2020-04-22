package com.cbp;

import java.io.InputStream;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static final Logger logger = Logger.getLogger(FileUploadService.class.getName());
	
	public ResponseEntity<String> uploadData(MultipartFile file) throws Exception {

		if (file == null) {
			throw new RuntimeException("You must select a file for uploading");
		}

		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();

		logger.info("inputStream: " + inputStream);
		logger.info("originalName: " + originalName);
		logger.info("name: " + name);
		logger.info("contentType: " + contentType);
		logger.info("size: " + size);

		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(originalName+" was uploaded successfully", HttpStatus.OK);
	}
}

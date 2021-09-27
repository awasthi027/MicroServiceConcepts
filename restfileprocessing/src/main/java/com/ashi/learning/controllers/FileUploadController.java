package com.ashi.learning.controllers;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	@Value("${upload.dir.path}")
	private String upload_dir;
	
	@RequestMapping("/upload")
	public boolean upload(@RequestParam("file")  MultipartFile file) throws IllegalStateException, IOException {
		
		file.transferTo(new File(upload_dir + file.getOriginalFilename()));
		return true;
		
	}
	
	@RequestMapping("/download/{fileName}")
	public ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName) throws IOException {
	  byte [] fileData = Files.readAllBytes(new File(upload_dir + fileName).toPath());
	
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_PDF);
	  
	  return new ResponseEntity<byte[]>(fileData, headers, HttpStatus.OK);
	}
}

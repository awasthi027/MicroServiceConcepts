package com.ashi.learning;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.sun.xml.internal.stream.Entity;

@SpringBootTest
class RestfileprocessingApplicationTests {

	private static final String DOWNLOADS_PATH  = "/Users/ashishawasthi/Documents/downloads/";
	private static final String UPLOAD_PATH  = "/Users/ashishawasthi/Documents/upload/";
	private static final String DOWNLOAD_PATH  = "/Users/ashishawasthi/Documents/download/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	void testDownloadFile() {
//		HttpHeaders headers = new HttpHeaders();	
//		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
//		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
//		String fileName = "pp.jpg";
//		ResponseEntity<Byte[]> response = restTemplate.exchange(DOWNLOAD_PATH + fileName, HttpMethod.GET,httpEntity, fileName, headers);
//		Files.write(Paths.get(DOWNLOAD_PATH + fileName), response.getBody());
		
	}
	
	@Test
	void testUploadFile() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		String path = new ClassPathResource("ashi.png").toString();
		body.add("file", path);
		
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String,String>>(body,headers);
		ResponseEntity<Boolean> response = restTemplate.postForEntity(UPLOAD_PATH, httpEntity, Boolean.class);
		System.out.println(response.getBody());
	}

}

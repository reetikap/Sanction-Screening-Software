package com.cbp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rest/sanctions")
public class EntryController {
	
	@Autowired
	SanctionService sanctionService;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@GetMapping("/view/{id}")
	public Map<String, Object> index(@PathVariable final String id) {
		return sanctionService.view(id);
	}
	
	 @GetMapping("/view/name/{field}")
	 public Map<String, Object> index1(@PathVariable final String field) {
		 return sanctionService.searchByName(field);
	 }
	 
	 @PostMapping("/upload")
	 public ResponseEntity<String> index2(@RequestParam("file") MultipartFile file) throws Exception{
		 return fileUploadService.uploadData(file);
	 }
}

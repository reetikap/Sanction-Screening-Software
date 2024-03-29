package com.cbp.sanctions.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cbp.sanctions.models.PaymtTransaction;
import com.cbp.sanctions.models.User;
import com.cbp.sanctions.service.FileUploadService;
import com.cbp.sanctions.service.RegistrationService;
import com.cbp.sanctions.service.ViewService;
@RestController
@RequestMapping("/rest/sanctions")


public class Controller {
	
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	ViewService viewService;

	@Autowired
	RegistrationService registrationService;
	
	 Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins= "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception { //registration service
			String tempEmailId = user.getEmailId();
			if(tempEmailId != null  && "".contentEquals(tempEmailId))
			{
				User userobj=registrationService.fetchUserByEmailId(tempEmailId);
				if(userobj !=null) {
					throw new Exception("user with"+tempEmailId + "is already exist");
				}
			}
		User userObj =null;
		registrationService.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins= "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPass =user.getPassword();
		User userObj = null;
		if(tempEmailId != null && tempPass != null) {
			userObj= registrationService.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj ==null)
		{
			logger.error("Bad credentials");
			throw new Exception("Bad Credentials");
		}
		logger.info("User logged in "+user.getEmailId());
		return userObj;
	}
	

	 @PostMapping("/upload") //upload file service
	 @CrossOrigin(origins= "http://localhost:4200")
	 public ResponseEntity<String> index(@RequestParam("file") MultipartFile file) throws Exception{
		 logger.info("File uploaded successfully "+file.getName());
		 return fileUploadService.uploadData(file);
	 }
	 
	 @GetMapping("/view") //view transactions service
	 @CrossOrigin(origins= "http://localhost:4200")
	 public List<PaymtTransaction> index2() throws Exception{
		 logger.info("Transactions view successful");
		 return viewService.view();
	 }
}

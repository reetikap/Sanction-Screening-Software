package com.cbp.sanctions.controller;

import java.util.List;

<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> Stashed changes:src/main/java/com/cbp/sanctions/controller/Controller.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> Stashed changes:src/main/java/com/cbp/sanctions/controller/Controller.java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
@RestController
@RequestMapping("/rest/sanctions")
public class EntryController {
	@Autowired
	Client client;
	
	@GetMapping("/view/{id}")
    public Map<String, Object> view(@PathVariable final String id) {
        GetResponse getResponse = client.prepareGet("sanctions", "un_sanctions", id).get();
        return getResponse.getSource();
    }
	
	 @GetMapping("/view/name/{field}")
	    public Map<String, Object> searchByName(@PathVariable final String field) {
	        Map<String,Object> map = null;
	        SearchResponse response = client.prepareSearch("sanctions")
	                                .setTypes("un_sanctions")
	                                .setSearchType(SearchType.QUERY_THEN_FETCH)
	                                .setQuery(QueryBuilders.matchQuery("name", field))
	                                .get()
	                                ;
	        List<SearchHit> searchHits = Arrays.asList(response.getHits().getHits());
	        map =   searchHits.get(0).getSourceAsMap();
	        return map;
	    }
}
=======
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
>>>>>>> Stashed changes:src/main/java/com/cbp/sanctions/controller/Controller.java

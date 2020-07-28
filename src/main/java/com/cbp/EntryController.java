package com.cbp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/rest/sanctions")
<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
public class EntryController {
=======
public class Controller {
	
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	ViewService viewService;
>>>>>>> Stashed changes:src/main/java/com/cbp/Controller.java
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins= "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
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
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}
	
<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
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
=======
	 @PostMapping("/upload")
	 @CrossOrigin(origins= "http://localhost:4200")
	 public ResponseEntity<String> index(@RequestParam("file") MultipartFile file) throws Exception{
		 return fileUploadService.uploadData(file);
	 }
	 
	 @GetMapping("/view")
	 @CrossOrigin(origins= "http://localhost:4200")
	 public List<PaymtTransaction> index2() throws Exception{
		 return viewService.view();
	 }
>>>>>>> Stashed changes:src/main/java/com/cbp/Controller.java
}

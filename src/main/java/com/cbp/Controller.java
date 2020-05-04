package com.cbp;

<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
import java.util.Arrays;
=======
>>>>>>> Stashed changes:src/main/java/com/cbp/Controller.java
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/rest/sanctions")
<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
public class EntryController {
=======
public class Controller {
	
	@Autowired
	SanctionService sanctionService;
	
>>>>>>> Stashed changes:src/main/java/com/cbp/Controller.java
	@Autowired
	Client client;
	
	@GetMapping("/view/{id}")
    public Map<String, Object> view(@PathVariable final String id) {
        GetResponse getResponse = client.prepareGet("sanctions", "un_sanctions", id).get();
        return getResponse.getSource();
    }
	
	 @GetMapping("/view/name/{field}")
<<<<<<< Updated upstream:src/main/java/com/cbp/EntryController.java
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
	 public Map<String, Object> index1(@PathVariable final String field) {
		 return sanctionService.searchByName(field);
	 }
	 
	 @PostMapping("/upload")
	 public ResponseEntity<String> index2(@RequestParam("file") MultipartFile file) throws Exception{
		 return fileUploadService.uploadData(file);
	 }
	 
>>>>>>> Stashed changes:src/main/java/com/cbp/Controller.java
}

package com.cbp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanctionService {
	@Autowired
	Client client;
	
	public Map<String, Object> view(String id) {
        GetResponse getResponse = client.prepareGet("sanctions", "un_sanctions", id).get();
        return getResponse.getSource();
    }
	
	public Map<String, Object> searchByName(String field) {
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

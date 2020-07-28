package com.cbp;

import java.util.Arrays;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionProcessor implements ItemProcessor<PaymtTransaction, PaymtTransaction> {
    private static final Logger log = LoggerFactory.getLogger(TransactionProcessor.class);
    
    @Autowired
	Client client;
    @Autowired
	TransactionDAO dao;
    Validation validate;
    
    @Override
    public PaymtTransaction process(final PaymtTransaction transaction) throws Exception {
        
        validate = new Validation();
        boolean isValid=validate.isValid(transaction)&&dao.searchRef(transaction.ref);
        if(isValid)
        {
        	transaction.valid="Valid";
    		//Map<String,Object> map = null;
            SearchResponse response = client.prepareSearch("sanctions")
                                    .setTypes("un_sanctions")
                                    .setSearchType(SearchType.QUERY_THEN_FETCH)
                                    .setQuery(QueryBuilders.boolQuery()
                                    		.should(QueryBuilders.matchQuery("name", transaction.payerName))
                                            .should(QueryBuilders.matchQuery("name", transaction.payeeName))
                                            .should(QueryBuilders.matchQuery("*Name", transaction.payerName))
                                            .should(QueryBuilders.matchQuery("*Name", transaction.payerName))
                                            .should(QueryBuilders.matchQuery("alias", transaction.payerName))
                                            .should(QueryBuilders.matchQuery("alias", transaction.payerName))
                                            .should(QueryBuilders.matchQuery("*Alias", transaction.payerName))
                                            .should(QueryBuilders.matchQuery("*Alias", transaction.payerName)))
                                    .get()
                                    ;
        
            List<SearchHit> searchHits = Arrays.asList(response.getHits().getHits());
            //map =   searchHits.get(0).getSourceAsMap();
        if(searchHits.isEmpty())	
        	transaction.sanctioned="Not sanctioned";
        else
        	transaction.sanctioned="Sanctioned";
        }
        else
        {
            	transaction.valid="Invalid";
            	if(transaction.payeeAccNo.length()>12)
            		transaction.payeeAccNo=transaction.payeeAccNo.substring(0,12);
            	if(transaction.payerAccNo.length()>12)
            		transaction.payerAccNo=transaction.payerAccNo.substring(0,12);
            	if(transaction.ref.length()>12)
            		transaction.ref=transaction.ref.substring(0,12);
            	String s=String.valueOf(transaction.amount);
            	if(s.length()>10)
            		transaction.amount=Double.parseDouble(s.substring(0,10));
            	s=String.valueOf(transaction.date);
            	if(s.length()>8)
            		transaction.date=Integer.parseInt(s.substring(0, 8));
            	transaction.sanctioned="NA";
        }
        
        return transaction;
    }
    
}

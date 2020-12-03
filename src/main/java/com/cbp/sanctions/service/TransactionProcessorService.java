package com.cbp.sanctions.service;

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
import org.springframework.stereotype.Component;

import com.cbp.sanctions.constants.AppConstants;
import com.cbp.sanctions.models.PaymtTransaction;
import com.cbp.sanctions.repository.TransactionDAO;
import com.cbp.sanctions.util.Validation;
@Component
public class TransactionProcessorService implements ItemProcessor<PaymtTransaction, PaymtTransaction> {
    private static final Logger log = LoggerFactory.getLogger(TransactionProcessorService.class);
    
    @Autowired
	Client client;
    @Autowired
	TransactionDAO dao;
    Validation validate;
    
    Logger logger = LoggerFactory.getLogger(TransactionProcessorService.class);
    
    @Override
    public PaymtTransaction process(final PaymtTransaction transaction) throws Exception {
        
        validate = new Validation();
        boolean isValid=validate.isValid(transaction);//&&dao.searchRef(transaction.getRef());
        if(isValid)
        {
        	transaction.setValid(AppConstants.VALID);
            SearchResponse response = client.prepareSearch("sanctions") //querying elasticsearch for sanctions
                                    .setTypes("un_sanctions")
                                    .setSearchType(SearchType.QUERY_THEN_FETCH)
                                    .setQuery(QueryBuilders.boolQuery()
                                    		.should(QueryBuilders.matchQuery("name", transaction.getPayerName()))
                                            .should(QueryBuilders.matchQuery("name", transaction.getPayeeName()))
                                            .should(QueryBuilders.matchQuery("*Name", transaction.getPayerName()))
                                            .should(QueryBuilders.matchQuery("*Name", transaction.getPayeeName()))
                                            .should(QueryBuilders.matchQuery("alias", transaction.getPayerName()))
                                            .should(QueryBuilders.matchQuery("alias", transaction.getPayeeName()))
                                            .should(QueryBuilders.matchQuery("*Alias", transaction.getPayerName()))
                                            .should(QueryBuilders.matchQuery("*Alias", transaction.getPayeeName())))
                                    .get()
                                    ;
        
            List<SearchHit> searchHits = Arrays.asList(response.getHits().getHits());
            //map =   searchHits.get(0).getSourceAsMap();
        if(searchHits.isEmpty())	
        	transaction.setSanctioned(AppConstants.NOT_SANCTIONED);
        else
        	transaction.setSanctioned(AppConstants.SANCTIONED);
        }
        else
        {
            	transaction.setValid(AppConstants.INVALID);
            	if(transaction.getPayeeAccNo().length()>12)
            		transaction.setPayeeAccNo(transaction.getPayeeAccNo().substring(0,12));
            	if(transaction.getPayeeAccNo().length()>12)
            		transaction.setPayeeAccNo(transaction.getPayeeAccNo().substring(0,12));
            	if(transaction.getRef().length()>12)
            		transaction.setRef(transaction.getRef().substring(0,12));
            	String s=transaction.getDate();
            	if(s.length()>8)
            		transaction.setDate(s.substring(0, 8));
            	transaction.setSanctioned("NA");
        }
        logger.info("Transaction validated and sanctioned successfully");
        return transaction;
    }
    
}

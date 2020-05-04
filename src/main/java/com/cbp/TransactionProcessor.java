package com.cbp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TransactionProcessor implements ItemProcessor<PaymtTransaction, PaymtTransaction> {
    private static final Logger log = LoggerFactory.getLogger(TransactionProcessor.class);
    @Override
    public PaymtTransaction process(final PaymtTransaction transaction) throws Exception {
        /*final String ref = transaction.getRef();
        final String payeeName = transaction.getPayeeName();
        final String payerName = transaction.getPayerName();
        final String payerAccNo=transaction.getPayerAccNo();
        final String payeeAccNo=transaction.getPayeeAccNo();
        final int date=transaction.getDate();
        final double amt=transaction.getAmount();*/
        return transaction;
    }
}

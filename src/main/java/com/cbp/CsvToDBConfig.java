package com.cbp;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

@EnableBatchProcessing
@Configuration
public class CsvToDBConfig {
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    public DataSource dataSource;
    
    @StepScope
	@Bean
	//public FlatFileItemReader < PaymtTransaction > csvTransactionReader(@Value("#{jobParameters[fullPathFileName]}") String pathToFile) throws IOException {
	public FlatFileItemReader < PaymtTransaction > csvTransactionReader() throws IOException {
		    FlatFileItemReader<PaymtTransaction> reader = new FlatFileItemReader<>();
		    reader.setResource(new FileSystemResource("C:\\Users\\Lenovo\\Desktop\\tmpuploads\\file"));
		    //reader.setResource(new FileSystemResource(pathToFile));
		    reader.open(new ExecutionContext());
		    // more code here
		    reader.setLineMapper(new DefaultLineMapper < PaymtTransaction > () {
		        {
		            setLineTokenizer(new DelimitedLineTokenizer() {
		                {
		                    setNames(new String[] {
		                        "ref",
		                        "date",
		                        "payerName",
		                        "payerAccNo",
		                        "payeeName",
		                        "payeeAccNo",
		                        "amount"
		                    });
		                }
		            });
		            setFieldSetMapper(new BeanWrapperFieldSetMapper < PaymtTransaction > () {
		                {
		                    setTargetType(PaymtTransaction.class);
		                }
		            });
		        }
		    });
		return reader;
	}
	
	@Bean
	ItemProcessor<PaymtTransaction, PaymtTransaction> csvTransactionProcessor() {
		return new TransactionProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<PaymtTransaction> csvTransactionWriter() {
		 JdbcBatchItemWriter<PaymtTransaction> csvTransactionWriter = new JdbcBatchItemWriter<PaymtTransaction>();
		 csvTransactionWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PaymtTransaction>());
		 csvTransactionWriter.setSql("INSERT INTO transactions (ref,dt,payerName,payerAccNo,payeeName,payeeAccNo,amount,valid,sanctioned) VALUES (:ref,:date,:payerName,:payerAccNo,:payeeName,:payeeAccNo,:amount,:valid,:sanctioned)");
		 csvTransactionWriter.setDataSource(dataSource);
	        return csvTransactionWriter;
	}
	
	@Bean
	public Step csvFileToDatabaseStep(ItemReader<PaymtTransaction> csvTransactionReader) throws IOException {
		return stepBuilderFactory.get("csvFileToDatabaseStep")
				.allowStartIfComplete(true)
				.<PaymtTransaction, PaymtTransaction>chunk(1)
				.reader(csvTransactionReader())
				.processor(csvTransactionProcessor())
				.writer(csvTransactionWriter())
				.build();
	}

	@Bean	
	public Job csvFileToDatabaseJob(ItemReader<PaymtTransaction> csvTransactionReader) throws IOException {
		return jobBuilderFactory.get("csvFileToDatabaseJob")
				.incrementer(new RunIdIncrementer())
				.flow(csvFileToDatabaseStep(csvTransactionReader))
				.end()
				.build();
	}
}

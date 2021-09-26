package com.ashi.learning.config;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ashi.learning.model.Product;

@Configuration
public class BatchConfig {

	 @Autowired
	 private JobBuilderFactory jbf;
	 
	 @Autowired
	 private StepBuilderFactory sbf;
	 
	 
	 @Bean
	 public Step step() {
		 return sbf.get("Step1").<Product, Product>chunk(1).reader(readerData()).processor(processor()).writer(writer()).build();
	 }
	 
	 @Bean
	 public Job job() {
	 Job job = jbf.get("job1").incrementer(new RunIdIncrementer()).start(step()).build();
	   return job;
	 }
	
	 @Bean
	 public FlatFileItemReader <Product> readerData() {
		 
		 FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("product.csv"));
		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","name","description","price");
		
		BeanWrapperFieldSetMapper<Product> feildMapper = new BeanWrapperFieldSetMapper<>();
		feildMapper.setTargetType(Product.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(feildMapper);
		reader.setLineMapper(lineMapper);
		 System.out.println("Read the data");
	    return reader;
	 }
	 
	 @Bean
	 public ItemProcessor<Product, Product> processor() {
		 return (p)-> { p.setPrice(p.getPrice() - (p.getPrice() * 10) / 100 );
		 System.out.println("Process discounnted Price:-" + p.getPrice());
		 return p;
		 };
	 }
	 
	 @Bean
	 public JdbcBatchItemWriter<Product> writer() {
		 JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<Product>();
		  writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		  writer.setDataSource(dataSource());
		  String sql = "insert into product (id, name, description, price) VALUES (:id, :name, :description, :price )";
		  writer.setSql(sql);
		  System.out.println("Write the data");
		 return writer;
	 }
	 
	 @Bean
	 public DataSource dataSource() {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		 dataSource.setUsername("root");
		 dataSource.setPassword("test");
		 return dataSource;
	 }
	 
	 
}

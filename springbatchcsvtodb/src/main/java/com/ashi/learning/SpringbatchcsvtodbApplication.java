package com.ashi.learning;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringbatchcsvtodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbatchcsvtodbApplication.class, args);
	}

}

package com.ashi.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SendandreceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendandreceiverApplication.class, args);
	}

}

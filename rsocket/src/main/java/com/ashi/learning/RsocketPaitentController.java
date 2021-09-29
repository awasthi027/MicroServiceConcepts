package com.ashi.learning;

import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ashi.learning.model.ClinicalData;
import com.ashi.learning.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

@RestController
public class RsocketPaitentController {
	
	Logger logger = LoggerFactory.getLogger(RsocketPaitentController.class);
	
	@MessageMapping("get-patient-data")
	public Mono<ClinicalData> resquestResponse(Patient patient) {
		logger.info("================ info resquestResponse");
		return Mono.just(new ClinicalData(90, "90/120"));
	}

}

package com.ashi.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.learning.model.ClinicalData;
import com.ashi.learning.model.Patient;

import reactor.core.publisher.Mono;

@RestController
public class RSocketClientController {
	
   private final RSocketRequester rSocketRequester;
   
  
   @SuppressWarnings("deprecation")
public RSocketClientController(@Autowired RSocketRequester.Builder builder) {
	   this.rSocketRequester =  (RSocketRequester) builder
               .dataMimeType(MediaType.APPLICATION_CBOR)
               .connectTcp("localhost", 7000).retry(5).cache();
   }
   
   @GetMapping(path =  "/request-response")
   public Mono<ClinicalData> requestResponse(Patient patient) {
	  return this.rSocketRequester.route("get-patient-data").data(patient).retrieveMono(ClinicalData.class);
   }
   
}

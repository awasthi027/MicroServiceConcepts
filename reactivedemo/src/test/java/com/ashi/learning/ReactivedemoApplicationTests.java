package com.ashi.learning;

import java.time.Duration;
import java.util.Map;

import javax.xml.crypto.Data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactivedemoApplicationTests {

	@Test
	void testMono() {
		Mono<String> mono = Mono.just("Macbook Pro");
		mono.log().map(data->data.toUpperCase()).subscribe(data->System.out.print(data));
		
 	}
	
	@Test
	void testFlux() {
		Flux<String> flux = Flux.just("Macbook Pro", "iPhone Pro");
		flux.log().map(data->data.toUpperCase()).subscribe(data->System.out.print(data));
	}
	
	@Test
	void testFluxOrder() {
		Flux<String> flux = Flux.just("Macbook Pro", "iPhone Pro");
		flux.log().map(data->data.toUpperCase()).subscribe(new OrderConsumer());
	}
	
	@Test
	void testFluxDelay() {
		Flux<String> flux = Flux.just("Macbook Pro", "iPhone Pro");
		flux.delayElements(Duration.ofSeconds(2)) .log().map(data->data.toUpperCase()).subscribe(new OrderConsumer());
	}

}

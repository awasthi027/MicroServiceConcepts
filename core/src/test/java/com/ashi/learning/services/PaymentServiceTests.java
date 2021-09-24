package com.ashi.learning.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceTests {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentServiceImpl paymentServiceimpl;
	
	@Test
	void testPaymentServiceDependency() {
		assertNotNull(paymentService);
	}
	
	@Test
	void testPaymentServiceRespository() {
		assertNotNull(paymentServiceimpl.getPaymentDAORepo());
	}

}

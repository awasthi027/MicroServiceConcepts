package com.ashi.learning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashi.learning.respository.PaymentDAORepo;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAORepo paymentDAORepo;

	public PaymentDAORepo getPaymentDAORepo() {
		return paymentDAORepo;
	}

	public void setPaymentDAORepo(PaymentDAORepo paymentDAORepo) {
		this.paymentDAORepo = paymentDAORepo;
	}

}

package com.ashi.learning.receiver;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@JmsListener(destination = "${springjms.myQueue}")
  public void receive(String messsage) {
		
	  System.out.println("Message received===>" + messsage);
    }
	
}

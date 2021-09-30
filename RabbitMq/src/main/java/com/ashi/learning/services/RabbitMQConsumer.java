package com.ashi.learning.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.ashi.learning.models.Person;

@Service
public class RabbitMQConsumer {
	
// Not sure about the data type 
	@RabbitListener(queues = "mobile")
	public void getMessage(byte [] message) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(message);
		ObjectInput input = new ObjectInputStream(bis);
		Person person = (Person)input.readObject();
		System.out.println("Received Message:====" + person.toString());
		input.close();
		bis.close();
		
	}
	
//	@RabbitListener(queues = "mobile")
//    public void getMessage(Person person) {
//		System.out.println("Receved message:====" + person.toString());
//	}

}

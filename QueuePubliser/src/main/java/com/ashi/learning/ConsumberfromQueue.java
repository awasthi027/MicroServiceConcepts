package com.ashi.learning;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ConsumberfromQueue {
	
   public static void main(String[] args) throws IOException, TimeoutException {
	   ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		DeliverCallback deliverCallback = (consumerTag, delivery)-> {
			String message = new String(delivery.getBody());
			System.out.println("Mesage Received ===" + message);
		};
		
		channel.basicConsume("mobile", true, deliverCallback, consumerTag ->{});
		channel.basicConsume("ac", true, deliverCallback, consumerTag ->{});
		channel.basicConsume("tv", true, deliverCallback, consumerTag ->{});
		
    }
}

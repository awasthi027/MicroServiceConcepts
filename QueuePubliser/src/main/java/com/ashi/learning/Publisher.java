package com.ashi.learning;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		System.out.println("send message===========");
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		String [] messages = {"First", "Second", "Third", "Fourth"};
		
		for(String message:  messages) {
			channel.basicPublish("", "queue-1", null, message.getBytes());
		}
		channel.close();
		connection.close();
	}
}

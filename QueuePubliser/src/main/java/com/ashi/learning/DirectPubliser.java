package com.ashi.learning;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPubliser {
   public static void main(String[] args) throws IOException, TimeoutException {
	   System.out.println("send message===========");
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "This is my tv";
		channel.basicPublish("direct-exchange", "tvkey", null, message.getBytes());
		channel.close();
		connection.close();
}   
}

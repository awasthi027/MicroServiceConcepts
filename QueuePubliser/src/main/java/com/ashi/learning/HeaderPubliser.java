package com.ashi.learning;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.Basic;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class HeaderPubliser {

	public static void main(String[] args) throws IOException, TimeoutException {
		System.out.println("send message===========");
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
         
		String message = "mesage mobile and TV";
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("item1", "mobile");
		headerMap.put("item2", "ac");
		BasicProperties br = new BasicProperties();
		br = br.builder().headers(headerMap).build();
		
		channel.basicPublish("header-exchange", "", br, message.getBytes());
		channel.close();
		connection.close();
	}

}

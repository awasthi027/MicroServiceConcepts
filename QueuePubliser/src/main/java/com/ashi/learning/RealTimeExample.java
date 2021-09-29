package com.ashi.learning;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RealTimeExample {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
	   	Channel channel = connection.createChannel();
	   	JSONObject json = new JSONObject();
	   	json.put("from_date", "01-jan-2019");
	   	json.put("to_date", "31-dec-2019");
	   	json.put("email", "myemail.awasthi@gmail.com");
	   	json.put("query", "select * from data");
	   	
	   	channel.basicPublish("", "queue-1", null, json.toString().getBytes());
	   	channel.close();
	   	connection.close();

	}

}

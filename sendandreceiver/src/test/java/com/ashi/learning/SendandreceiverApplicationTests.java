package com.ashi.learning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ashi.learning.sender.MessageSender;

@SpringBootTest
class SendandreceiverApplicationTests {
	
	@Autowired
	MessageSender msgSender;

	@Test
	void testSendAndReceive() {
		msgSender.send("Hello JMS!!!");
	}
	
	@Test
	void testSendCreateMessage() {
		msgSender.sendMessageCreater("Hello Message Creater JMS!!!");
	}

}

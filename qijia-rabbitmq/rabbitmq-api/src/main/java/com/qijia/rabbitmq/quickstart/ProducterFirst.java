package com.qijia.rabbitmq.quickstart;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by weichen on 2019/1/25.
 */
public class ProducterFirst {

	public static void main(String[] args) throws IOException,TimeoutException, InterruptedException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.31.152");
		connectionFactory.setVirtualHost("/");
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setPort(5672);

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		for (int i = 0; i <	5 ; i++) {
			String msg = "hello world11";
			channel.basicPublish("", "com.qijia.test01",null, msg.getBytes());
		}

		channel.close();
		connection.close();
	}

}

package com.qijia.rabbitmq.api.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by weichen on 2019/1/25.
 */
public class ConsumerFirst {

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.31.152");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setVirtualHost("/");

		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare("com.qijia.test01", true, false, false, null);

		QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
		channel.basicConsume("com.qijia.test01", true, queueingConsumer);

		while (true) {
			QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println("接收到消息: " + msg);

			Map<String, Object> headers = delivery.getProperties().getHeaders();
			System.err.println("headers get my1 value: " + headers.get("my1"));
		}

//		channel.close();
//		connection.close();
	}


}

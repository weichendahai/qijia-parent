package com.qijia.rabbitmq.api.ack;

import com.rabbitmq.client.*;
import com.rabbitmq.client.impl.AMQBasicProperties;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by weichen on 2019/2/15.
 */
public class ProducerTest {

	public static void main(String[] args) throws Exception {
		//1 创建ConnectionFactory
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.31.152");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setVirtualHost("/");

		//2 创建Connection
		Connection connection = connectionFactory.newConnection();
		//3 创建Channel
		Channel channel = connection.createChannel();

		// 4. 指定我们的消息投递模式: 消息的确认模式
		channel.confirmSelect();

		String exchangeName = "test_ack_exchange";
		String routingKey = "ack.save";
		//5 发送一条消息
		String msg = "Hello RabbitMQ ACK consumer Message";

		HashMap<String, Object> headers = new HashMap<>();
		for (int i = 0; i < 5; i++) {

			headers.put("my_msg_id", i);
			AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
					.deliveryMode(2)
					.contentEncoding("UTF-8")
					.headers(headers)
					.build();

			channel.basicPublish(exchangeName, routingKey, properties, msg.getBytes());
		}

		// 如果想想要监听不被路由的消息，发送端，需要将 mandatory = true； 否则returnlistener 无效
//		channel.basicPublish(exchangeName, routingKeyError, true,null, msg.getBytes());
//		channel.basicPublish(exchangeName, routingKeyError, false,null, msg.getBytes());

	}
}

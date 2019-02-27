package com.qijia.rabbitmq.api.dlx;

import com.rabbitmq.client.*;

import java.io.IOException;

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

		String exchangeName = "test_dlx_exchange";
		String routingKey = "dlx.save";

		String msg = "Hello RabbitMQ DLX Message";

		for (int i = 0; i < 3; i++) {

			AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
					.deliveryMode(2)
					.contentEncoding("UTF-8")
					.expiration("10000")
					.build();

			channel.basicPublish(exchangeName, routingKey, properties, msg.getBytes());
		}
	}
}

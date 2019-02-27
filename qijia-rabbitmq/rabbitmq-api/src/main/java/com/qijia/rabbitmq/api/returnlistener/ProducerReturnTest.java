package com.qijia.rabbitmq.api.returnlistener;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by weichen on 2019/2/15.
 */
public class ProducerReturnTest {

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

		channel.addConfirmListener(new ConfirmListener() {
			@Override
			public void handleAck(long deliveryTag, boolean multiple) throws IOException {
				System.out.println("---rabbitmq broker return ack----");
				System.out.println(String.format("deliveryTag=%s, multiple=%s", deliveryTag, multiple));
			}

			@Override
			public void handleNack(long deliveryTag, boolean multiple) throws IOException {
				System.err.println("---rabbitmq broker return not ack----");
				System.err.println(String.format("deliveryTag=%s, multiple=%s", deliveryTag, multiple));
			}
		});

		channel.addReturnListener(new ReturnListener() {
			@Override
			public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.err.println("---------handle  return----------");
				System.err.println("replyCode: " + replyCode);
				System.err.println("replyText: " + replyText);
				System.err.println("exchange: " + exchange);
				System.err.println("routingKey: " + routingKey);
				System.err.println("properties: " + properties);
				System.err.println("body: " + new String(body));
			}
		});

		String exchangeName = "test_return_exchange";
		String routingKey = "return.save";
		String routingKeyError = "abc.save";
		//5 发送一条消息
		String msg = "Hello RabbitMQ Return Message";

		channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());

		// 如果想想要监听不被路由的消息，发送端，需要将 mandatory = true； 否则returnlistener 无效
		channel.basicPublish(exchangeName, routingKeyError, true,null, msg.getBytes());
//		channel.basicPublish(exchangeName, routingKeyError, false,null, msg.getBytes());

	}
}

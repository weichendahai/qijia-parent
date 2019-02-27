package com.qijia.rabbitmq.api.confirmlistener;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by weichen on 2019/2/15.
 */
public class ProducerConfirmTest {

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

		String exchangeName = "test_confirm_exchange";
		String routingKey = "confirmlistener.save";

		//5 发送一条消息
		String msg = "Hello RabbitMQ Send confirmlistener message!";
		channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
		// 如果此时立刻关闭生产者端 channel；将会接收不到 任何listener，因此此处不调用 channel.close();
		// channel.close();
	}
}

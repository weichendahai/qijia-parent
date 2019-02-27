package com.qijia.rabbitmq.api.exchange.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

/**
 * Created by weichen on 2019/2/14.
 * 测试exchange type 为 topic类型
 */
public class Consumer4TopicExchange {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		connectionFactory.setHost("192.168.31.152");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setVirtualHost("/");

		connectionFactory.setAutomaticRecoveryEnabled(true);
		connectionFactory.setNetworkRecoveryInterval(3000);

		Connection connection = connectionFactory.newConnection();

		Channel channel = connection.createChannel();
		//4 声明
		String exchangeName = "test_topic_exchange";
		String exchangeType = "topic";
		String queueName = "test_topic_queue";
		//匹配路由: user.save, user.update
		String routingKey = "user.*";
		//匹配路由: user.save, user.update, user.delete.abc
		//String routingKey = "user.#";
		// 1 声明交换机
		channel.exchangeDeclare(exchangeName, exchangeType, true, false, false, null);
		// 2 声明队列
		channel.queueDeclare(queueName, false, false, false, null);
		// 3 建立交换机和队列的绑定关系:
		channel.queueBind(queueName, exchangeName, routingKey);

		//durable 是否持久化消息
		QueueingConsumer consumer = new QueueingConsumer(channel);
		//参数：队列名称、是否自动ACK、Consumer
		channel.basicConsume(queueName, true, consumer);
		//循环获取消息
		int numMsg = 1;
		while (true) {
			//获取消息，如果没有消息，这一步将会一直阻塞
			Delivery delivery = consumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println("收到消息：" + "[" + numMsg + "] " + msg);
			numMsg ++;
		}
	}
}

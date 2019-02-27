package com.qijia.rabbitmq.api.ack;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by weichen on 2019/2/15.
 */
public class ConsumerTest {

	public static void main(String[] args) throws Exception {
		//1 创建ConnectionFactory
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.31.152");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setVirtualHost("/");

		//2 获取Connection
		Connection connection = connectionFactory.newConnection();

		//3 通过Connection创建一个新的Channel
		Channel channel = connection.createChannel();

		String exchangeName = "test_ack_exchange";
		String routingKey = "ack.save";
		String queueName = "test_ack_queue";

		//4 声明交换机和队列 然后进行绑定设置, 最后制定路由Key
		channel.exchangeDeclare(exchangeName, "topic", true);
		channel.queueDeclare(queueName, true, false, false, null);
		channel.queueBind(queueName, exchangeName, routingKey);

		// 限制客户端消费流量
		// 1. 设定每次只消费1条数据记录
		// 2. 设定自动签收ack为false； auto_ack = false;
		channel.basicQos(0, 1, false);
		Boolean isAutoAck = false;
		channel.basicConsume(queueName, isAutoAck, new MyConsumer(channel));
	}

}

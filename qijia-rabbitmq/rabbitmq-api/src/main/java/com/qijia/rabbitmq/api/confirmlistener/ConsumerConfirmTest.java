package com.qijia.rabbitmq.api.confirmlistener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

/**
 * Created by weichen on 2019/2/15.
 */
public class ConsumerConfirmTest {

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

		String exchangeName = "test_confirm_exchange";
		String routingKey = "confirmlistener.#";
		String queueName = "test_confirm_queue";

		//4 声明交换机和队列 然后进行绑定设置, 最后制定路由Key
		channel.exchangeDeclare(exchangeName, "topic", true);
		channel.queueDeclare(queueName, true, false, false, null);
		channel.queueBind(queueName, exchangeName, routingKey);

		//5 创建消费者
		QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, true, queueingConsumer);

		int numMsg = 1;
		while (true) {
			Delivery delivery = queueingConsumer.nextDelivery();
			String msg = new String(delivery.getBody());

			System.out.println("收到消息：" + "[" + numMsg + "] " + msg);
			numMsg ++;
		}
	}

}

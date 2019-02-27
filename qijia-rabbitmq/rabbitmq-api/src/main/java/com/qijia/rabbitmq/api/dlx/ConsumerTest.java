package com.qijia.rabbitmq.api.dlx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;

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

		String exchangeName = "test_dlx_exchange";
		String routingKey = "dlx.save";
		String queueName = "test_dlx_queue";

		//4 声明交换机和队列 然后进行绑定设置, 最后制定路由Key
		Map<String, Object> agruments = new HashMap<String, Object>();
		agruments.put("x-dead-letter-exchange", "dlx.exchange");

		channel.exchangeDeclare(exchangeName, "topic", true);
		channel.queueDeclare(queueName, true, false, false, agruments);
		channel.queueBind(queueName, exchangeName, routingKey);

		/*======== 私信本身定义 开始 ========*/
		/*
			定义死信exchange名称为: dlx.exchange,
			定义死信queue   名称为: dlx.queue,
			定义私信exchange与quque绑定关系为：#; 也是就所有消息都转存至 dlx.queue
		*/
		channel.exchangeDeclare("dlx.exchange", "topic", true, false, null);
		channel.queueDeclare("dlx.queue", true, false, false, null);
		channel.queueBind("dlx.queue", "dlx.exchange", "#");
		/*======== 私信本身定义 结束 ========*/

		channel.basicConsume(queueName, true, new MyConsumer(channel));
	}

}

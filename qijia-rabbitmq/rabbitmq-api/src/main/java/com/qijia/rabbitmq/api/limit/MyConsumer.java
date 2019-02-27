package com.qijia.rabbitmq.api.limit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class MyConsumer extends DefaultConsumer {

	Channel channel;

	public MyConsumer(Channel channel) {
		super(channel);
		this.channel = channel;
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
		try {
			System.out.println("-----------自定义消费端收到消息: consume message----------");
			System.out.println("consumerTag: " + consumerTag);
			System.out.println("envelope: " + envelope);
			System.out.println("properties: " + properties);
			System.out.println("body: " + new String(body));

			// 接收消息，业务处理成功，返回ack
			channel.basicAck(envelope.getDeliveryTag(), false);
		} catch (Exception e) {
			// 接收消息，业务处失败异常，返回nack；
			channel.basicNack(envelope.getDeliveryTag(), false, false);
			e.printStackTrace();
		}
	}
}

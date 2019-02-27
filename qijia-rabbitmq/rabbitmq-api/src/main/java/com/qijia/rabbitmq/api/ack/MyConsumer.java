package com.qijia.rabbitmq.api.ack;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.Map;

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
			System.out.println("envelope: " + envelope);
			System.out.println("body: " + new String(body));

			Map<String, Object> headers = properties.getHeaders();
			Object myMsgId = headers.get("my_msg_id");

			if (myMsgId.equals(1)) {
				//手动自己模拟一个 nack；这样可以看到requeue 效果
				System.err.println("properties: " + properties);
				channel.basicNack(envelope.getDeliveryTag(), false, false);
				Thread.sleep(1000);
				return;
			}

			if (myMsgId.equals(2)) {
				//手动自己模拟一个 nack；这样可以看到requeue 效果
				System.err.println("properties: " + properties);
				channel.basicNack(envelope.getDeliveryTag(), false, true);
				Thread.sleep(1000);
				return;
			}

			// 接收消息，业务处理成功，返回ack
			channel.basicAck(envelope.getDeliveryTag(), false);
		} catch (Exception e) {
			// 接收消息，业务处失败异常，返回nack；
			channel.basicNack(envelope.getDeliveryTag(), false, false);
			e.printStackTrace();
		}
	}
}

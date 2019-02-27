package com.qijia.rabbitmq.spring.adapter;

import com.qijia.rabbitmq.spring.model.Order;
import com.qijia.rabbitmq.spring.model.Order22;
import com.qijia.rabbitmq.spring.model.Packaged;

import java.io.File;
import java.util.Map;

/**
 * Created by weichen on 2019/2/26.
 */
public class MessageDelegate {

	/**
	 * messageListenerAdapter 默认使用方法
	 * 如果此方法名修改，那么 messageListenerAdapter 的方法设定也需要相应修改
	 *
	 * @param messageBody
	 */
	public void handleMessage(byte[] messageBody) {
		System.out.println("默认方法, 消息内容:" + new String(messageBody));
	}

	/**
	 * 自定义处理方法名
	 *
	 * @param messageBody
	 */
	public void consumeMessage(byte[] messageBody) {
		System.out.println("字节数组方法, 消息内容:" + new String(messageBody));
	}

	/**
	 * 在消息监听适配器中，已经设定消息转换器，消息byte[] 转换为 string 类型了
	 *
	 * @param messageBody
	 */
	public void consumeMessage(String messageBody) {
		System.out.println("字符串方法, 消息内容:" + messageBody);
	}


	public void method1(String messageBody) {
		System.out.println("method1 收到消息内容:" + new String(messageBody));
	}

	public void method2(String messageBody) {
		System.out.println("method2 收到消息内容:" + new String(messageBody));
	}


	// byte 转换为 map 对象，非java bean ; 也就是 通过 byte[] --> json_string --> Map
	public void consumeMessage(Map messageBody) {
		System.err.println("map方法, 消息内容:" + messageBody);
	}

	// java 对象 json；也就是 通过 byte[] --> json_string --> java Bean对象
	public void consumeMessage(Order22 order) {
		System.err.println(" Order22 对象, 消息内容, id: " + order.getId() +
				", name: " + order.getName() +
				", content: " + order.getContent());
	}

	// java 对象 json；也就是 通过 byte[] --> json_string --> java Bean对象
	public void consumeMessage(Order order) {
		System.err.println("order对象, 消息内容, id: " + order.getId() +
				", name: " + order.getName() +
				", content: " + order.getContent());
	}

	// java 对象 json；也就是 通过 byte[] --> json_string --> java Bean对象
	public void consumeMessage(Packaged pack) {
		System.err.println("package对象, 消息内容, id: " + pack.getId() +
				", name: " + pack.getName() +
				", content: " + pack.getDescription());
	}

	public void consumeMessage(File file) {
		System.err.println("文件对象 方法, 消息内容:" + file.getName());
	}
}

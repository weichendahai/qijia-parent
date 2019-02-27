package com.qijia.rabbitmq.spring.convert;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * Created by weichen on 2019/2/26.
 * 此转换器，未做任何处理
 */
public class MyMessageConvert implements MessageConverter {

	@Override
	public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
		return new Message(o.toString().getBytes(), messageProperties);
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		return message.getBody();
	}

}

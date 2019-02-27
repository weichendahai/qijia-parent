package com.qijia.rabbitmq.spring.config;

import com.qijia.rabbitmq.spring.adapter.MessageDelegate;
import com.qijia.rabbitmq.spring.convert.ImageMessageConverter;
import com.qijia.rabbitmq.spring.convert.MyMessageConvert;
import com.qijia.rabbitmq.spring.convert.PDFMessageConverter;
import com.qijia.rabbitmq.spring.convert.TextMessageConvert;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by weichen on 2019/2/19.
 */

@Configuration
public class RabbitMQConfig {

	// ------------------------------ rabbitmq ConnectionFactory  ----------------------------------

	/**
	 * 此处使用的 ConnectionFactory 使用 org.springframework.amqp.rabbit.connection 而不要使用ampq 原生 connection；
	 *
	 * @return
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses("192.168.31.152");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setVirtualHost("/");
		return connectionFactory;
	}

	// ------------------------------ rabbitmq rabbitAdmin  ----------------------------------

	/**
	 * rabbitAdmin 主要是用于管理 mq 队列，交换机，绑定关系；
	 * 如定义队列，交换机，绑定关系等; 清空队列，删除队列等
	 *
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
		// 此处rabbitAdmin 必须设定 AutoStartup = true
		// 否则，rabbitAdmin 会自动注册失败
		rabbitAdmin.setAutoStartup(true);
		return rabbitAdmin;
	}

	// ------------------------------ rabbitmq Template  ----------------------------------

	/**
	 * rabbitmq Template 是主要使用对象；比如发送消息，接受消息等等
	 *
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}


	// ------------------------------ rabbit mq 简单消息监听容器 ----------------------------------

	/**
	 * rabbit mq 简单消息监听容器；其中很多客户端消费者参数，需要在此设定
	 * 比如消费者的 接收消息监听处理，并发数，消息是否自动签收，拒绝消息是否重回队列，消费者名称Id生成策略 ...
	 *
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {

		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);

		// 设置 监听 队列 queues
		container.setQueues(queue001(), queue002(), queue003(), queue_image(), queue_pdf());
		// 设置 消费者 客户端 并发个数；可以理解为是channel 对象个数
		container.setConcurrentConsumers(1);
		// 设置 消费者客户端 最大并发个数
		container.setMaxConcurrentConsumers(5);
		// 设置 消费者消息签收方式是否自动； ack 一般都是采用 非自动
		container.setAcknowledgeMode(AcknowledgeMode.AUTO);
		// 设置 消费者拒绝消息或是失败消息，是否重回队列，一般设置为不在重回队列
		container.setDefaultRequeueRejected(false);
		container.setExposeListenerChannel(true);
		// 设置 消费者名称Id 方案
		container.setConsumerTagStrategy(new ConsumerTagStrategy() {
			@Override
			public String createConsumerTag(String queue) {
				return queue + "_" + UUID.randomUUID().toString();
			}
		});

		/*
		// 设置 接受消息，处理消息逻辑；使用对象为 MessageListener 或是 ChannelAwareMessageListener
		container.setMessageListener(new ChannelAwareMessageListener() {
			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				String msg = new String(message.getBody());
				System.err.println("----------消费者: " + msg);
			}
		});
		*/

		/* ------------- 设置处理消息的适配器 ------------- */

		/**
		 // 1. 适配器方式. 默认是有自己的方法名字的：handleMessage
		 // 1. 声明适配器
		 MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new MessageDelegate());
		 // 2. 设定适配器执行方法；默认方法名字 "handleMessage"；可自行定义；比如 "method001" ..
		 messageListenerAdapter.setDefaultListenerMethod("handleMessage");
		 // 3. 设定消息监听适配器的消息转换器；
		 messageListenerAdapter.setMessageConverter(new MyMessageConvert());
		 // 4. 设置消息容器的消息监听器适配器
		 container.setMessageListener(messageListenerAdapter);
		 */

		/**
		 // 1. 适配器方式. 设定自己的方法名字的：consumeMessage
		 // 也可以添加一个转换器: 从字节数组转换为String

		 // 1. 声明适配器
		 MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new MessageDelegate());
		 // 2. 设定适配器执行方法；默认方法名字 "handleMessage"；可自行定义；比如 "method001" ..
		 messageListenerAdapter.setDefaultListenerMethod("consumeMessage");
		 // 3. 设定消息监听适配器的消息转换器；
		 messageListenerAdapter.setMessageConverter(new TextMessageConvert());
		 // 4. 设置消息容器的消息监听器适配器
		 container.setMessageListener(messageListenerAdapter);
		 */


		/**
		 // 2. 适配器方式: 我们的队列名称 和 方法名称 也可以进行一一的匹配;
		 // 也就是一个每个队列，可以对应不同的处理方法；
		 MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new MessageDelegate());
		 // 2. 设定适配器执行方法；默认方法名字 "handleMessage"；可自行定义；比如 "method001" ..;
		 HashMap<String, String> queueOrTagToMethodName = new HashMap<>();
		 queueOrTagToMethodName.put("queue001", "method1");
		 queueOrTagToMethodName.put("queue002", "method2");
		 messageListenerAdapter.setQueueOrTagToMethodName(queueOrTagToMethodName);
		 // 3. 设定消息监听适配器的消息转换器；
		 messageListenerAdapter.setMessageConverter(new TextMessageConvert());
		 // 4. 设置消息容器的消息监听器适配器
		 container.setMessageListener(messageListenerAdapter);
		 */

		/**
		 // 3. 支持json格式的转换器; byte[] --> string --> map
		 MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageDelegate());
		 adapter.setDefaultListenerMethod("consumeMessage");

		 Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
		 adapter.setMessageConverter(jackson2JsonMessageConverter);

		 container.setMessageListener(adapter);
		 */


		/**
		 // 4.  DefaultJackson2JavaTypeMapper & Jackson2JsonMessageConverter 支持java对象转换
		 // byte[] --> string --> java bean
		 // 发送方生产者，需要设定 message properties 相关属性； setContentType 及 headers['__TypeId__'] 属性
		 //// MessageProperties messageProperties = new MessageProperties();
		 //// //这里注意一定要修改contentType为 application/json
		 //// messageProperties.setContentType("application/json");
		 //// messageProperties.getHeaders().put("__TypeId__", "com.qijia.rabbitmq.spring.model.Order");

		 MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageDelegate());
		 adapter.setDefaultListenerMethod("consumeMessage");

		 Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();

		 DefaultJackson2JavaTypeMapper javaTypeMapper = new DefaultJackson2JavaTypeMapper();
		 jackson2JsonMessageConverter.setJavaTypeMapper(javaTypeMapper);

		 adapter.setMessageConverter(jackson2JsonMessageConverter);
		 container.setMessageListener(adapter);
		 */


		/**
		 // 5. DefaultJackson2JavaTypeMapper & Jackson2JsonMessageConverter 支持java对象多映射转换

		 // byte[] --> string --> java bean
		 // 发送方生产者，需要设定 message properties 相关属性； setContentType 及 headers['__TypeId__'] 属性

		 //// MessageProperties messageProperties1 = new MessageProperties();
		 //// //这里注意一定要修改contentType为 application/json
		 //// messageProperties1.setContentType("application/json");
		 //// messageProperties1.getHeaders().put("__TypeId__", "order");

		 MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageDelegate());
		 adapter.setDefaultListenerMethod("consumeMessage");
		 Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
		 DefaultJackson2JavaTypeMapper javaTypeMapper = new DefaultJackson2JavaTypeMapper();

		 Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
		 idClassMapping.put("order", com.qijia.rabbitmq.spring.model.Order22.class);
		 idClassMapping.put("packaged", com.qijia.rabbitmq.spring.model.Packaged.class);

		 javaTypeMapper.setIdClassMapping(idClassMapping);

		 jackson2JsonMessageConverter.setJavaTypeMapper(javaTypeMapper);
		 adapter.setMessageConverter(jackson2JsonMessageConverter);
		 container.setMessageListener(adapter);
		 */

		/**
		 * 全局的转换器: 根据message的contentype指定不同的消息转换器
		 */
		//1.4 ext convert

		MessageListenerAdapter adapter = new MessageListenerAdapter(new MessageDelegate());
		adapter.setDefaultListenerMethod("consumeMessage");

		//全局的转换器:
		ContentTypeDelegatingMessageConverter convert = new ContentTypeDelegatingMessageConverter();

		TextMessageConvert textConvert = new TextMessageConvert();

		convert.addDelegate("text", textConvert);
		convert.addDelegate("html/text", textConvert);
		convert.addDelegate("xml/text", textConvert);
		convert.addDelegate("text/plain", textConvert);

		Jackson2JsonMessageConverter jsonConvert = new Jackson2JsonMessageConverter();
		convert.addDelegate("json", jsonConvert);
		convert.addDelegate("application/json", jsonConvert);

		ImageMessageConverter imageConverter = new ImageMessageConverter();
		convert.addDelegate("image/png", imageConverter);
		convert.addDelegate("image", imageConverter);

		PDFMessageConverter pdfConverter = new PDFMessageConverter();
		convert.addDelegate("application/pdf", pdfConverter);

		adapter.setMessageConverter(convert);
		container.setMessageListener(adapter);

		return container;

	}


	// ------------------------------ 队列，交换机，绑定关系定义 ----------------------------------

	/**
	 * spring bean 方式定义 队列，交换机，绑定关系 注入容器定义
	 * 针对消费者配置
	 * 1. 设置交换机类型
	 * 2. 将队列绑定到交换机
	 * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
	 * HeadersExchange ：通过添加属性key-value匹配
	 * DirectExchange:按照routingkey分发到指定队列
	 * TopicExchange:多关键字匹配
	 */

	@Bean
	public TopicExchange exchange001() {
		return new TopicExchange("topic001", true, false);
	}

	@Bean
	public Queue queue001() {
		return new Queue("queue001", true); //队列持久
	}

	@Bean
	public Binding binding001() {
		return BindingBuilder.bind(queue001()).to(exchange001()).with("spring.*");
	}

	@Bean
	public TopicExchange exchange002() {
		return new TopicExchange("topic002", true, false);
	}

	@Bean
	public Queue queue002() {
		return new Queue("queue002", true); //队列持久
	}

	@Bean
	public Binding binding002() {
		return BindingBuilder.bind(queue002()).to(exchange002()).with("rabbit.*");
	}

	@Bean
	public Queue queue003() {
		return new Queue("queue003", true); //队列持久
	}

	@Bean
	public Binding binding003() {
		return BindingBuilder.bind(queue003()).to(exchange001()).with("mq.*");
	}

	@Bean
	public Queue queue_image() {
		return new Queue("image_queue", true); //队列持久
	}

	@Bean
	public Queue queue_pdf() {
		return new Queue("pdf_queue", true); //队列持久
	}
}

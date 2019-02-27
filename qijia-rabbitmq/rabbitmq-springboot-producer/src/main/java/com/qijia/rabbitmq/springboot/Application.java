package com.qijia.rabbitmq.springboot;

/**
 * Created by weichen on 2019/2/19.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.qijia.rabbitmq.springboot.*"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
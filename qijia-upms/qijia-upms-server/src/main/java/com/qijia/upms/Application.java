package com.qijia.upms;

/**
 * Created by weichen on 2018/9/18.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages={"com.qijia.upms"})
public class Application {

	private Logger logger = LoggerFactory.getLogger(Application.class);;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
package com.qijia.shop.admin;

/**
 * Created by weichen on 2018/9/18.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"com.qijia.shop.admin"})
@ComponentScan(basePackages={"com.qijia.shop.admin", "com.qijia.upms"})
public class Application {

	private Logger logger = LoggerFactory.getLogger(Application.class);;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
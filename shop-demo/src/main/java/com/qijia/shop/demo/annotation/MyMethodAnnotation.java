package com.qijia.shop.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by weichen on 2018/8/11.
 * 方法注解，且在运行至起作用
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyMethodAnnotation {
	String value();
	String name();
}
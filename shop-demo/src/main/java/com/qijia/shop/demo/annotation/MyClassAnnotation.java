package com.qijia.shop.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by weichen on 2018/8/11.
 * 类注解,且在运行至起作用
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyClassAnnotation {
	String value();
}

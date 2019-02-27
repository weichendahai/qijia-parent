package com.qijia.shop.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by weichen on 2018/8/11.
 * 属性注解, 且在运行至起作用
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface MyFieldAnnotation {

	int[] value();
//	错误写法
//	Integer value();
}

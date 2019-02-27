package com.qijia.shop.demo.annotation.Test;

import com.qijia.shop.demo.annotation.MyClassAnnotation;
import com.qijia.shop.demo.annotation.MyFieldAnnotation;
import com.qijia.shop.demo.annotation.MyMethodAnnotation;

/**
 * Created by weichen on 2018/8/11.
 */
@MyClassAnnotation(value = "testMyAnnotationXXXX")
public class TestMyAnnotation {

	@MyFieldAnnotation(value = {11, 22})
	String userName = "lili";

//	@MyMethodAnnotation("getUserName")
	@MyMethodAnnotation(value = "getUserName", name = "hello method")
	public String getUserName() {
		return userName;
	}
}

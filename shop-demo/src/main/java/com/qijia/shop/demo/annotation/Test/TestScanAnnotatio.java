package com.qijia.shop.demo.annotation.Test;


import com.qijia.shop.demo.annotation.MyClassAnnotation;
import com.qijia.shop.demo.annotation.MyFieldAnnotation;
import com.qijia.shop.demo.annotation.MyMethodAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by weichen on 2018/8/11.
 * https://www.cnblogs.com/lyy-2016/p/6288535.html
 * https://blog.csdn.net/briblue/article/details/73824058
 * https://blog.csdn.net/javazejian/article/details/70768369
 */
public class TestScanAnnotatio {

	public static void main(String[] args) throws Exception {

		StringBuffer sb = new StringBuffer();

//		获取的是类对象；而不是类 实例；
//		获取的是实例TestMyAnnotation.this
		Class<?> clsByFinded = TestMyAnnotation.class;

		System.out.println(clsByFinded);
//		Constructor<?> constructor = clsByFinded.getConstructor();
//		System.out.println(constructor);

		sb.append("Class注解：").append("\n");
		MyClassAnnotation myClassAnnotation = clsByFinded.getAnnotation(MyClassAnnotation.class);
		if (myClassAnnotation != null) {
//			获取类修饰符;类修饰符，设计是使用数字1，200，.. 设计，调用ToString 转换为英文字符串
			String modigerStr = Modifier.toString(clsByFinded.getModifiers());
//			获取类简单名称
			String simpleName = clsByFinded.getSimpleName();
//			获取注解值
			String annotationValue = myClassAnnotation.value();

			sb.append(modigerStr)
					.append(" ")
					.append(simpleName)
					.append("\n");
			sb.append("注解值: ")
					.append(annotationValue)
					.append("\n\n");


			Object o = clsByFinded.newInstance();
			TestMyAnnotation x= (TestMyAnnotation)o;
			String userName = x.getUserName();
			System.out.println(" ==1 > " + userName);


			Method getUserName2 = clsByFinded.getMethod("getUserName");
			String userName2 = (String)getUserName2.invoke(x);
			System.out.println(" ==2 > " + userName2);

		}

		sb.append("Field注解：").append("\n");
		Field[] fields = clsByFinded.getDeclaredFields();
		for (Field field : fields) {
			MyFieldAnnotation fieldInfo = field.getAnnotation(MyFieldAnnotation.class);
			if (fieldInfo != null) {
				sb.append(Modifier.toString(field.getModifiers())).append(" ")
						.append(field.getType().getSimpleName()).append(" ")
						.append(field.getName()).append("\n");
				sb.append("注解值: ").append(Arrays.toString(fieldInfo.value())).append("\n\n");
			}
		}

		sb.append("Method注解：").append("\n");
		Method[] methods = clsByFinded.getDeclaredMethods();
		for (Method method : methods) {
			MyMethodAnnotation methodInfo = method.getAnnotation(MyMethodAnnotation.class);
			if (methodInfo != null) {
				sb.append(Modifier.toString(method.getModifiers())).append(" ")
						.append(method.getReturnType().getSimpleName()).append(" ")
						.append(method.getName()).append("\n");
				sb.append("注解值: ").append("\n");
				sb.append("name: ").append(methodInfo.name()).append("\n");
			}
		}
		System.out.print(sb.toString());

	}
}

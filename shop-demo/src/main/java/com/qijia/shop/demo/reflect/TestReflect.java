package com.qijia.shop.demo.reflect;

import java.lang.reflect.Method;

/**
 * Created by weichen on 2018/8/13.
 */

public class TestReflect {

	public static void test() throws Exception {

//		1.定义一个已有包名，和类名；
		String packageName = "com.qijia.shop.demo.reflect";
		String className = "TestUserInfo";
		Class<?> testUserInfo = Class.forName(String.format("%s.%s", packageName, className));

		TestUserInfo testUserInfo2 = new TestUserInfo();
		Class<? extends Class> aClass = testUserInfo.getClass();
		System.out.println(aClass);

		Class<?> testUserInfoClass3 = TestUserInfo.class;
		System.out.println(testUserInfoClass3);

		// TODO: 2018/8/13 待修改
		boolean instance = testUserInfoClass3.isInstance(TestUserInfo.class);
		System.out.println(instance);


		TestUserInfo.class.getMethods();
		TestUserInfo.class.getMethod("setName", String.class);
		TestUserInfo.class.getDeclaredMethods();
		TestUserInfo.class.getDeclaredMethod("setName", String.class);
	}

	public static void test2() throws Exception{

		Class<TestUserInfo> testUserInfoClass = TestUserInfo.class;
		TestUserInfo XXXXUser = testUserInfoClass.newInstance();

		Method setNameMethod = testUserInfoClass.getMethod("setName", String.class);
		setNameMethod.invoke(XXXXUser, "lili");
		System.out.println(XXXXUser.getName());
		System.out.println(XXXXUser);
	}

	public static void main(String[] args) throws Exception {
		test();
		test2();
	}
}

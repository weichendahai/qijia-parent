package com.qijia.shop.admin.model;

/**
 * Created by weichen on 2018/8/11.
 */
public class User {
	String name;
	String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}

package com.qijia.rabbitmq.spring.model;

/**
 * Created by weichen on 2019/2/26.
 */
public class Order22 {
	private String id;

	private String name;

	private String content;

	public Order22() {
	}

	public Order22(String id, String name, String content) {
		this.id = id;
		this.name = name;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

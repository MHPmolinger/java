package com.neusoft.spring.domain;

import org.springframework.stereotype.Component;

@Component(value="emp")
public class Employee {

	private String name="ÀîËÄ";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

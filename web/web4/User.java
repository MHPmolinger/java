package com.neusoft.javaweb.domain;

public class User {

	private String name;
    private Address address;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
}

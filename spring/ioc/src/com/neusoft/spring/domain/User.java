package com.neusoft.spring.domain;

import java.util.Arrays;
import java.util.List;

public class User {

	private String name;
	private int age;
	private  String[] addresses;
	private List<String> mobiles;
	private List<BankCard> bankCards;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", addresses="
				+ Arrays.toString(addresses) + ", mobiles=" + mobiles
				+ ", bankCards=" + bankCards + "]";
	}
	public String[] getAddresses() {
		return addresses;
	}
	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}
	public List<String> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<String> mobiles) {
		this.mobiles = mobiles;
	}
	public User(String name, int age, String[] addresses, List<String> mobiles) {
		super();
		this.name = name;
		this.age = age;
		this.addresses = addresses;
		this.mobiles = mobiles;
	}
	public List<BankCard> getBankCards() {
		return bankCards;
	}
	public void setBankCards(List<BankCard> bankCards) {
		this.bankCards = bankCards;
	}
	public User(String name, int age, String[] addresses, List<String> mobiles,
			List<BankCard> bankCards) {
		super();
		this.name = name;
		this.age = age;
		this.addresses = addresses;
		this.mobiles = mobiles;
		this.bankCards = bankCards;
	}
	
	
}

package com.neusoft.mybatis.domain;

import java.util.Date;

public class Product {

	private int pid;
	private String name;
	private double price;
	private Date madeTime;
	private String desc;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getMadeTime() {
		return madeTime;
	}
	public void setMadeTime(Date madeTime) {
		this.madeTime = madeTime;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price
				+ ", madeTime=" + madeTime + ", desc=" + desc + "]";
	}
	
	
	
}

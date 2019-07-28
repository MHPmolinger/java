package com.neusoft.reflect;

import java.util.Date;

public class Student {

	protected final static int num=200;
	private String stuId;
	private String name;
	private boolean gender;
	private Date birthday;
	private int age;
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static void method(){
		
	}
	public int method(int a,int b,String c){
		
		return 0;
	}
	public final int method(String s1,String s2,int num){
		return 100;
	}
	public static String guoji="中国";
	public void sayHello(){
		System.out.println("你好同学： "+name);
	}
	
	public void sayHello(String name,int age){
		System.out.println(name+"同学的年龄为："+age);
	}
}

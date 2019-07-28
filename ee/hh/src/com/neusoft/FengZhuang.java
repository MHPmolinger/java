package com.neusoft;

import java.util.Scanner;

public class FengZhuang {
private int age;
private String name;
private String gender;

public void setAge(int age){
	this.age=age;
}
public int getAge(){
	return this.age;
}
public void setName(String name){
	this.name=name;
}
public String getName(){
	return this.name;
}
public void setGender(String gender){
	this.gender=gender;
}
public String getGender(){
	return this.gender;
}
public static void main(String[] args) {
	FengZhuang obj=new FengZhuang();
	Scanner input = new Scanner(System.in);
	System.out.print("请输入姓名：");
	String name=input.nextLine();
	System.out.print("请输入性别：");
	String gender=input.nextLine();
	System.out.print("请输入年龄：");
	int age=input.nextInt();
	obj.setName(name);
	obj.setGender(gender);
	obj.setAge(age);
	System.out.println("\n输入信息如下：");
	System.out.println("姓名："+obj.getName());
	System.out.println("性别："+obj.getGender());
	System.out.println("年龄："+obj.getAge());
	input.close();
}
}

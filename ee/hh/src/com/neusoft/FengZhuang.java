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
	System.out.print("������������");
	String name=input.nextLine();
	System.out.print("�������Ա�");
	String gender=input.nextLine();
	System.out.print("���������䣺");
	int age=input.nextInt();
	obj.setName(name);
	obj.setGender(gender);
	obj.setAge(age);
	System.out.println("\n������Ϣ���£�");
	System.out.println("������"+obj.getName());
	System.out.println("�Ա�"+obj.getGender());
	System.out.println("���䣺"+obj.getAge());
	input.close();
}
}

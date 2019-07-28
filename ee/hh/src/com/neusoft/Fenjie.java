package com.neusoft;

import java.util.Scanner;

public class Fenjie {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	System.out.println("请输入数字：");
	int num=input.nextInt();
	System.out.print("各位是：");
	System.out.println(num%10);
	System.out.print("十位是：");
	System.out.println(num/10%10);
	System.out.print("百位是：");
	System.out.println(num/100%10);
	System.out.print("千位是：");
	System.out.println(num/1000);
	input.close();
}
}

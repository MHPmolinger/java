package com.neusoft;

import java.util.Scanner;

public class Fenjie {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	System.out.println("���������֣�");
	int num=input.nextInt();
	System.out.print("��λ�ǣ�");
	System.out.println(num%10);
	System.out.print("ʮλ�ǣ�");
	System.out.println(num/10%10);
	System.out.print("��λ�ǣ�");
	System.out.println(num/100%10);
	System.out.print("ǧλ�ǣ�");
	System.out.println(num/1000);
	input.close();
}
}

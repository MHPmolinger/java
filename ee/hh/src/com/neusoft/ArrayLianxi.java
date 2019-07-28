package com.neusoft;

/**
 * 输出数组中相同的元素
 * 输出数组中不同的元素
 */
import java.util.Scanner;

public class ArrayLianxi {
	/**
	 * 统计数组中有几个重复的元素
	 * @param a
	 * @return num1
	 */
	public static int reLength(int[] a) {
		int sum = 0;//数组的所有重复的元素之和
		int num1=0;//统计有几个相同的元素
		loop: for (int i = 0; i < a.length; i++) {// 统计相同的元素
			for (int k = 0; k < i; k++)
				if (a[i] == a[k])
					continue loop;
			int num = 1;//单个元素出现的次数
			

			for (int j = i + 1; j < a.length; j++) {// 统计出现的次数
				if (a[i] == a[j]) {
				//	num += 1;//统计相同元素出现的次数需删掉break语句
					num1+=1;
					break;
				}
			}
			if (num > 1) {
			//	System.out.println(a[i] + ":" + num);//打印元素出现的次数
				sum += num;
			}
		}
		return num1;
	}
	/**
	 * 将数组中相同的元素创建为一个数组
	 * @param a 原数组
	 * @param b 需要创建的数组的长度
	 * @return re
	 */
	
	public static int[] getRe(int[] a,int b){
		int[] re=new int[b];
		int index=0;
		loop:for(int i=0;i<a.length-1;i++){
			for(int k=0;k<i;k++){
				if(a[i]==a[k])
					continue loop;
			}
			for(int j=i+1;j<a.length;j++)
				if(a[i]==a[j]){
					re[index]=a[i];
					index++;
					break;
				}
	}
		return re;
	}
	public static void printArray(int[] a){
		for(int x:a)
			System.out.print(x+"\t");
	}
	/**
	 * 统计数组中不同元素的个数
	 * @param a 原数组
	 */
public static int noLength(int[] a){
	int num=0;
	loop:for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length;j++){
			if(a[i]==a[j]&&i!=j){
				continue loop;
			}
		}num++;
	}
	return num;
}
public static int[] getNo(int[] a,int b){
	int[] new1=new int[b];
	int index=0;
	loop1:for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length;j++){
			if(a[i]==a[j]&&i!=j){
				continue loop1;
			}
		}
		{
			new1[index]=a[i];
			index++;
		}
	}
	
	return new1;
}
	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 78, 6, 2, 5, 12, 56 };
		int ab=noLength(a);
		printArray(getRe(a,reLength(a)));
		System.out.println();
		printArray(getNo(a,noLength(a)));
		

	}
}

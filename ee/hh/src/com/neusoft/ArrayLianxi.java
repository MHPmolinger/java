package com.neusoft;

/**
 * �����������ͬ��Ԫ��
 * ��������в�ͬ��Ԫ��
 */
import java.util.Scanner;

public class ArrayLianxi {
	/**
	 * ͳ���������м����ظ���Ԫ��
	 * @param a
	 * @return num1
	 */
	public static int reLength(int[] a) {
		int sum = 0;//����������ظ���Ԫ��֮��
		int num1=0;//ͳ���м�����ͬ��Ԫ��
		loop: for (int i = 0; i < a.length; i++) {// ͳ����ͬ��Ԫ��
			for (int k = 0; k < i; k++)
				if (a[i] == a[k])
					continue loop;
			int num = 1;//����Ԫ�س��ֵĴ���
			

			for (int j = i + 1; j < a.length; j++) {// ͳ�Ƴ��ֵĴ���
				if (a[i] == a[j]) {
				//	num += 1;//ͳ����ͬԪ�س��ֵĴ�����ɾ��break���
					num1+=1;
					break;
				}
			}
			if (num > 1) {
			//	System.out.println(a[i] + ":" + num);//��ӡԪ�س��ֵĴ���
				sum += num;
			}
		}
		return num1;
	}
	/**
	 * ����������ͬ��Ԫ�ش���Ϊһ������
	 * @param a ԭ����
	 * @param b ��Ҫ����������ĳ���
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
	 * ͳ�������в�ͬԪ�صĸ���
	 * @param a ԭ����
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

package com.neusoft;

import java.util.Random;
import java.util.Scanner;

public class VipCard {
	public int tonum(int[] a) {
		int b = 0;
		for (int i = 0; i < a.length; i++)
			for (int j = a.length - i - 1;;)
				if (i + j == a.length - 1) {
					b += Math.pow(10, j) * a[i];
					break;
				}
		return b;
	}

	public boolean compare(int[] a, int b) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == b)
				return false;
			else
				return true;
		return false;
	}

	public int[] createVipCard() {
		int[] a = new int[8];
		Random obj = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = obj.nextInt(9) + 1;
			if (a[i] == 4 || a[i] == 7 || a[i] == 3) {
				int k = obj.nextInt(2);
				if (k == 1)
					a[i] = 6;
				else
					a[i] = 8;
			}
		}
		return a;
	}

	public void printVipCard(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.print("请输入打印张数：");
		VipCard obj = new VipCard();
		int c = 0;// 已经有几条记录
		int d = 0;// 会员卡相对应的数字
		boolean isEqual;
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		input.close();
		int[] b = new int[num];// 所有会员卡
		for (int i = 1; i <= num; i++) {
			d = obj.tonum(obj.createVipCard());
			isEqual = obj.compare(obj.createVipCard(), d);
			if (isEqual) {
				obj.printVipCard(obj.createVipCard());
				b[c] = d;
				c++;
			}
		}
	}
}

package com.neusoft;

import java.util.Random;
import java.util.Scanner;

public class Lottery {
	public int[] createLottery() {
		Random obj = new Random();
		int[] a = new int[5];
		for (int i = 0; i < 5; i++) {
			a[i] = obj.nextInt(12);
		}
		return a;
	}

	public void printLottery(int[] a) {
		for (int x : a)
			System.out.print(x + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Lottery obj1 = new Lottery();
		Scanner input = new Scanner(System.in);
		System.out.print("请输入打印彩票的数量：");
		int a = input.nextInt();
		for (int i = 1; i <= a; i++) {
			obj1.printLottery(obj1.createLottery());
		}
		input.close();
	}
}

package com.neusoft;

import java.util.Scanner;

public class SanMuShuChu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 定义数组
		int[] num = { 8, 4, 2, 1, 23, 344, 12 };
		// 输入幸运数字
		System.out.print("请输入数字：");
		int xy = input.nextInt();
		// 是否含有此数字
		boolean isLk = false;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == xy) {
				isLk = true;
				break;
			}
		}
		System.out.println(isLk ? "存在" : "不存在");
		/*
		 * if (isLk) { System.out.println("存在"); } else {
		 * System.out.println("不存在"); }
		 */
		input.close();
	}
}

package com.neusoft;

import java.util.Scanner;

public class SanMuShuChu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// ��������
		int[] num = { 8, 4, 2, 1, 23, 344, 12 };
		// ������������
		System.out.print("���������֣�");
		int xy = input.nextInt();
		// �Ƿ��д�����
		boolean isLk = false;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == xy) {
				isLk = true;
				break;
			}
		}
		System.out.println(isLk ? "����" : "������");
		/*
		 * if (isLk) { System.out.println("����"); } else {
		 * System.out.println("������"); }
		 */
		input.close();
	}
}

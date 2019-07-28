package com.neusoft;

public class Thread3 {
	public static void main(String[] args) {
		int min = 0;
		int sec = 1;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (min == 0) {
				if (sec == 60) {
					sec = 0;
					min++;
					System.out.println(min + "MIN" + sec);
				} else {
					System.out.println(sec);
					sec++;
				}
			} else {
				if (sec == 60) {
					sec = 0;
					min++;
				}
				System.out.println(min + "MIN" + sec);
				sec++;
			}
		}
	}
}

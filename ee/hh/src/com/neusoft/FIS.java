package com.neusoft;

import java.io.File;
import java.io.FileInputStream;

public class FIS {
	public static void main(String[] args) throws Exception {
		File file = new File("d:\\x.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[10];
		while (fis.read(b) > -1) {
			System.out.println(new String(b));
			b = new byte[10];
		}
		fis.close();
	}
}

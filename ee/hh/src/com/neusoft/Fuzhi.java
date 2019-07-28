package com.neusoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fuzhi {
	public static void main(String[] args) throws IOException {
		File oldfile = new File("d:\\a\\a.txt");
		FileInputStream fis = new FileInputStream(oldfile);
		File newfile = new File("d:\\ÄãºÃ.txt");
		FileOutputStream fos = new FileOutputStream(newfile);
		byte[] b = new byte[50];
		while (fis.read(b) > -1) {
			System.out.println(new String(b));
			fos.write(b);
			b = new byte[50];
		}
		fis.close();
		fos.flush();
		fos.close();
	}
}

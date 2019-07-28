package com.neusoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DaxieTihuan {
	public static void main(String[] args) throws Exception {
		File oldfile = new File("d:\\x.txt");
		FileInputStream fis1 = new FileInputStream(oldfile);

		byte[] b = new byte[1];
		String str;
		String append = "";
		while (fis1.read(b) > -1) {

			str = new String(b);
			if (b[0] > 90)
				str = str.toUpperCase();
			else
				str = str.toLowerCase();
			str = str.replace('1', '0');
			append += str;
			b = new byte[1];
		}
		fis1.close();
		File newfile = new File("d:\\x.txt");
		FileOutputStream fos1 = new FileOutputStream(newfile);
		fos1.write(append.getBytes());
		fos1.flush();
		fos1.close();
	}
}

package com.neusoft;

import java.io.File;
import java.io.FileOutputStream;

public class FOS {
	public static void main(String[] args) throws Exception {
		String s = "再别\r\n康桥";
		byte[] b = s.getBytes();
		File obj = new File("d:\\a\\再别康桥.txt");
		FileOutputStream fos = new FileOutputStream(obj);
		fos.write(b);
		fos.flush();
		fos.close();
	}
}

package com.neusoft;

import java.io.File;
import java.io.FileOutputStream;

public class FOS {
	public static void main(String[] args) throws Exception {
		String s = "�ٱ�\r\n����";
		byte[] b = s.getBytes();
		File obj = new File("d:\\a\\�ٱ���.txt");
		FileOutputStream fos = new FileOutputStream(obj);
		fos.write(b);
		fos.flush();
		fos.close();
	}
}

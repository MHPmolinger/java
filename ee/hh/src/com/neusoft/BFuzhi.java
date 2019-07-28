package com.neusoft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BFuzhi {
	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader breader = null;
		FileOutputStream fos = null;
		OutputStreamWriter writer = null;
		BufferedWriter bwriter = null;
		String str = "";
		try {
			fis = new FileInputStream("d:\\new.txt");
			reader = new InputStreamReader(fis);
			breader = new BufferedReader(reader);
			fos = new FileOutputStream("d:\\new1.txt");
			writer = new OutputStreamWriter(fos);
			bwriter = new BufferedWriter(writer);
			while ((str = breader.readLine()) != null) {
				bwriter.write(str);
			}
			bwriter.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				breader.close();
				reader.close();
				fis.close();
				bwriter.close();
				writer.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

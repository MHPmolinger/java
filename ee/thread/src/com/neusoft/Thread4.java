package com.neusoft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Thread4 {
	/**
	 * 将str写入到文件f
	 */
	public void shuchu(File f, String s) {
		try {
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(s);
			bw.flush();
			bw.close();
			writer.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 从磁盘中读取文件f
	 */
	public String duru(File f) {
		String ok = "";
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader reader = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(reader);
			String s = "";
			
			while ((s = br.readLine()) != null) {
				ok += s + "\r\n";
			}
			br.close();
			reader.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;

	}

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("d:\\cf.txt"));
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(writer);
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= i; j++) {
					bw.write(j + "x" + i + "=" + i * j + "\t");
				}
				bw.newLine();
			}
			bw.flush();
			bw.close();
			writer.close();
			fos.close();
			FileInputStream fis = new FileInputStream(new File("d:\\cf.txt"));
			InputStreamReader reader = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(reader);
			String str = "";
			ArrayList<String> temp = new ArrayList<String>();
			while ((str = br.readLine()) != null) {
				temp.add(str);
			}
			br.close();
			reader.close();
			fis.close();
			FileOutputStream fos1 = new FileOutputStream(new File("d:\\ncf.txt"));
			OutputStreamWriter writer1 = new OutputStreamWriter(fos1);
			BufferedWriter bw1 = new BufferedWriter(writer1);
			for (int i = temp.size() - 1; i >= 0; i--) {
				bw1.write(temp.get(i));
				bw1.newLine();
			}
			bw1.flush();
			bw1.close();
			writer1.close();
			fos1.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.neusoft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class NewStory {
	public static String replaceStr(String[] illegal, String[] legal, String str) {
		Random random = new Random();
		for (int i = 0; i < illegal.length; i++) {
			if (str.contains(illegal[i])) {
				str = str.replace(illegal[i], legal[random.nextInt(legal.length)]);
			}
		}

		return str;
	}

	public static void main(String[] args) {
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader breader = null;
		FileOutputStream fos = null;
		OutputStreamWriter writer = null;
		BufferedWriter bwriter = null;
		String str = "";
		String newstr = "";
		String[] illegal = { "fucking", "asshole" };
		String[] legal = { "good", "hello" };
		try {
			fis = new FileInputStream("d:\\a\\story.txt");
			reader = new InputStreamReader(fis);
			breader = new BufferedReader(reader);
			fos = new FileOutputStream("d:\\a\\story1.txt");
			writer = new OutputStreamWriter(fos);
			bwriter = new BufferedWriter(writer);
			while ((str = breader.readLine()) != null) {
				newstr += str;
			}
			newstr = replaceStr(illegal, legal, newstr);
			String[] content = newstr.split("\\.");
			for (int i = 0; i < content.length; i++) {
				bwriter.write(content[i] + ".");
				bwriter.newLine();
			}
			bwriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				fis.close();
				breader.close();
				reader.close();
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

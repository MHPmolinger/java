package com.neusoft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Story {
	public static void main(String[] args)  {
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader breader = null;
		FileOutputStream fos = null;
		OutputStreamWriter writer = null;
		BufferedWriter bwriter = null;
		String str = "";
		String newstr="";
		try {
			fis = new FileInputStream("d:\\story.txt");
			reader = new InputStreamReader(fis);
			breader = new BufferedReader(reader);
			fos = new FileOutputStream("d:\\story1.txt");
			writer = new OutputStreamWriter(fos);
			bwriter = new BufferedWriter(writer);

			while ((str = breader.readLine()) != null) {
				newstr=str.replaceAll("fucking", "good");
				newstr=newstr.replaceAll("asshole", "good1");
				bwriter.write(newstr);
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

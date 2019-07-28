package com.neusoft;

public class LearnReader {
/*
	package com.dongruan.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class LearnReader {
/**
 * 1.inputstream 被inputstreamreader 
 *   inputstreamreader被bufferedreader包裹 
 * 2.OutputStream 被outputStreamWriter包裹
 *   outputStreamWriter 被 BufferedWriter 包裹
 * 
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream(new File(("e://a.txt")));
		OutputStreamWriter writer=new OutputStreamWriter(fos);
		BufferedWriter  bwriter=new BufferedWriter(writer);
		String str="";
		for(int i=1;i<=100;i++){
			str=str+"*";   
			bwriter.write(i+str);
			bwriter.newLine();
		}
		bwriter.flush();
	}
	/**
	 *  FileInputStream  fis=new FileInputStream(new File("e://a.txt"));
		InputStreamReader reader=new InputStreamReader(fis);
		BufferedReader  breader=new BufferedReader(reader);
		String str="";
		while((str=breader.readLine())!=null){
			System.out.println(str);
		}
	

}

	*/
}

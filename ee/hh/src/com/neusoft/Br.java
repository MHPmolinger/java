package com.neusoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Br {
public static void main(String[] args) throws Exception {
	File file=new File("d:\\we.txt");
	FileInputStream fis=new FileInputStream(file);
	InputStreamReader reader=new InputStreamReader(fis);
	BufferedReader breader=new BufferedReader(reader);
	String str="";
	while((str=breader.readLine())!=null){
		System.out.println(str);
	}
	breader.close();
}
}

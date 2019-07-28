package com.neusoft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Bw {
public static void main(String[] args) throws Exception {
	File file=new File("d:\\new.txt");
	FileOutputStream fos=new FileOutputStream(file);
	OutputStreamWriter  writer=new OutputStreamWriter(fos);
	BufferedWriter bwriter=new BufferedWriter(writer);
	for(int i=1;i<100;i++){
		bwriter.write(i+"");
		bwriter.newLine();
	}
	bwriter.flush();
	bwriter.close();
}
}

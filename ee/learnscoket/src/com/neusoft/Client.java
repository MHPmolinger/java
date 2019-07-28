package com.neusoft;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) throws Exception {
	Socket s=new Socket("10.25.102.14", 31013);
	Scanner input = new Scanner(System.in);
	while(true){
	System.out.println("ÇëÊäÈë·¢ËÍÄÚÈİ£º");
	String content=input.nextLine();
	PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
	pw.println(content);
	}
	
	
}
}

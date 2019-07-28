package com.neusoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
public static void main(String[] args) throws Exception{
	ServerSocket ss=new ServerSocket(60330);
	BufferedReader in=null;
	while(true){
		Socket s=ss.accept();
		in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println("客户端信息："+in.readLine());
	}
	
}
}

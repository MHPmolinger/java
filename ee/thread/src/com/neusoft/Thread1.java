package com.neusoft;

public class Thread1 implements Runnable{
	@Override
	public  void run() {
		for(int i=1;i<=5;i++){
			System.out.println(rename(Thread.currentThread().getName())+"�������е�"+i+"��");
		}
	}
	public String rename(String str){
		if("Thread-0".equals(str))
			return "�߳�1:";
		else 
			return "�߳�2:";
	}
}

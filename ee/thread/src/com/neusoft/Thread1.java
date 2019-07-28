package com.neusoft;

public class Thread1 implements Runnable{
	@Override
	public  void run() {
		for(int i=1;i<=5;i++){
			System.out.println(rename(Thread.currentThread().getName())+"正在运行第"+i+"遍");
		}
	}
	public String rename(String str){
		if("Thread-0".equals(str))
			return "线程1:";
		else 
			return "线程2:";
	}
}

package com.neusoft;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Thread2{
	public static void main(String[] args) {
		Date date=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(true){
			date=new Date();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(sdf.format(date));
		}
	}
}

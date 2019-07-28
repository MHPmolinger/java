package com.neusoft;

/**
 * 1、编写一个Java程序(包括一个主程序类，一个线程类。在主程序类中创建2个线程，将其中一个线程的优先级设为10,
 * 另一个线程的优先级设为6。让优先级为10的线程打印200次“线程1正在运行”，
 *  优先级为6的线程打印200次“线程2正在运行”。 [选做题]
 * 2、编写一个电子表，每隔一秒钟，在控制台打印出最新时间（年月日 时分秒） 。 [必做题] （使用Thread.sleep(毫秒)）
 * 功能让线程休息的方式实现 自行学习 类 SimpleDateFormate 以及Date 类 等工具类的使用（参见API文档） 
 * 3、做一个秒表 秒表实现
 * 在控制台 打印 1、2、3、……59 1Min 1 1Min2 1Min3 1Min4…… 
 * 4、利用高级字符流 实现将乘法口诀表 写入
 * 某磁盘txt文件中写入后 再将其读出倒序 写入到另一个txt文件中 
 * 5、把老师之前给的笔试卷子里面的题自己过几遍 多练习打字 速度！！！！
 */

public class TestTT{
public static void main(String[] args) {
	Thread1 obj1=new Thread1();//200次打印
	Thread t1=new Thread(obj1);
	Thread t2=new Thread(obj1);
//	t1.setPriority(10);
//	t2.setPriority(6);
	t1.start();
	t2.start();
//	try {
//		t2.join();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
}
}

package com.neusoft;

public class LearnThread {
/*
package com.dongruan.learnThread;

public class LearnThread extends Thread {
	/**
	 * 1、进程： 多进程：在同一时刻内  多个程序 可以 同时  运行我们管这一现象称之为 多进程
	 * 2、线程：线程是一个 进程 上被   切 分 出的多个片段其中的一个小片段 称为一个线程
	 * 3、多线程：在同一时刻 多个线程在 同步 运行
	 * 4、Java是如何 帮助我们实现多线程的
	 *    1.继承Thread类
	 *    2.实现 runnable接口 
	 *    目的只有一个 就是去重写  run方法
	 * 5、卖票案例： 假设现在 有一部电影的剩余票数为50 总共开放三个窗口在同时进行售票（每次每个窗口只售出一张票 大家共用一个票的库存）
	 * 6、线程不安全：多个线程 并发去访问操作 公共资源的时候  会产生线程不安全问题 
	 *    如何解决：使用 synchronized 关键字  对  操作  公共资源部分  逻辑  加上  锁    
	 * 7、现在有个  问题回顾 ：回顾 单利模式  
	 *    单利模式的书写方法 分为两种   一种为懒汉模式（就是在  获取对象的时候  才去 现创建对象   ）一种为 饿汉模式  
	 *    （在刚一创建全局变量的时候 就通过new 对象对其进行赋值）
	 *    饿汉模式 线程安全
	 *    懒汉模式创建对象  过程发生在  方法业务逻辑中  当多线程并发调用该方法时候  容易出现线程不安全问题
	 *    饿汉模式的缺点 ：刚一开始就创建 在 资源空间以及 时间方面效率要低于  懒汉模式   懒汉模式 是在需要的时候才去创建
	 *    如何解决   懒汉模式的线程不安全问题？在获取 对象的方法上 加上synchronized关键字  就可以解决这一问题
	 * 8、多线程权限问题
	 * 
	 * 9、既然有两种形式 可以帮助我们实现多线程 那么我们 推荐使用哪种？
	 *   1.继承 Thread类    2.实现 Runnable接口          推荐使用 第二种    因为类继承的单一性      而接口可以多实现
	 * 10、编程实现  求30000以内质数     （1种 使用多线程  一种 不使用多线程    观察 使用多线程与不使用多线程 执行效率高低  ）

                待续…………………………………………………………………………（多线程生命周期 以及 多线程其他一些方法的应用  api）
      
	int i=0;

	public void run() {
		 while(true){
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(i+++"===============>>");
		 }
	}
	public static void main(String[] args) {
		LearnThread  threadobj=new LearnThread();
		Thread  t1=new Thread(threadobj);
		Thread  t2=new Thread(threadobj);
		Thread  t3=new Thread(threadobj);
		t1.start();
		t2.start();
		t3.start();
	}
}
*/}

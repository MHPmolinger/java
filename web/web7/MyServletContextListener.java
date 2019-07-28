package cn.zdxy.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		//当上下文对象被销毁前该方法被调用
          System.out.println("上下文对象Context被销毁了！");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// 当上下文对象被创建时该方法被调用
		 System.out.println("上下文对象Context被创建了 了！");
		 //
		 /**在开发中我们可以把某个系统上线立刻要做的事情，可以把这些代码放到该监听器的这个方法中来，例如
		  * 某个网站上下是创建该系统中用到的所有库和表，也可以把数据库连接池对象的创建放到这里来，或某个系统
		  * 资源的访问，在开发中也可以把定时器的扫描代码放到这里面来。
		  *
		  */
	}

}

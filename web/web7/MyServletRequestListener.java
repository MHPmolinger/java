package cn.zdxy.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request 请求对象被销毁了！");

	}

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request 请求对象被创建了！");

	}

}

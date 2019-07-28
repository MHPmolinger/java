package cn.zdxy.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessoin对象被创建了！");

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessoin对象被销毁了！");
	}

}

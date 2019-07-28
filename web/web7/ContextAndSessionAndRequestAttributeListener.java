package cn.zdxy.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ContextAndSessionAndRequestAttributeListener implements
		ServletContextAttributeListener, ServletRequestAttributeListener,
		HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent e) {
		System.out.println("在session域中添加了名称-对象");
	}

	public void attributeRemoved(HttpSessionBindingEvent e) {
		// TODO Auto-generated method stub
		System.out.println("在session域移除了名称-对象");
	}

	public void attributeReplaced(HttpSessionBindingEvent e) {
		System.out.println("在session域中替换了名称-对象");

	}

	public void attributeAdded(ServletRequestAttributeEvent e) {
		//通过request事件对象可以获取客户端的Ip地址，
		String hostIp=e.getServletRequest().getRemoteAddr();
		System.out.println("在reuest域中添加了名称-对象");

	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("在request域中移除了名称-对象");

	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("在request域中替换了名称-对象");

	}

	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("在application域中添加了名称-对象");

	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("在application域中移除了名称-对象");


	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("在application域中替换了名称-对象");


	}

}

package cn.zdxy.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumberListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session=se.getSession();
		ServletContext context=session.getServletContext();
		if(context.getAttribute("onlineNumber")==null){//表示是第一个用户访问
			context.setAttribute("onlineNumber", new Integer(1));
			
		}else{
		  int number= (Integer) context.getAttribute("onlineNumber");
			context.setAttribute("onlineNumber", ++number);
		}

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context=se.getSession().getServletContext();
		int number=(Integer)context.getAttribute("onlineNumber");
		number--;
		context.setAttribute("onlineNumber", number);

	}

}

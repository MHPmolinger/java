package cn.zdxy.web.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimerSendMail implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent se) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent se) {
		//创建一个定时器
		Timer timer=new Timer();
		System.out.println("-----------TimerSendMail-----");
		//设置时间
		Calendar c=Calendar.getInstance();
		//注意设置日期时，月份是从0开始的
		c.set(2018, 7, 1, 9, 56, 20);
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("定时发送邮件！");
				
			}
			
		}, c.getTime());

	}

}

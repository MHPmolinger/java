package cn.zdxy.web.listener;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionScaner implements HttpSessionListener,
		ServletContextListener {
	
  // private List<HttpSession> list=new LinkedList<HttpSession>();因为存在线程安全问题
	private List<HttpSession> list=Collections.synchronizedList(new LinkedList<HttpSession>());
	private Object lock=new Object();
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		//在系统启动时创建一个定时器对象
		Timer timer=new Timer();
		//每隔2分钟进行一次对session对象的扫描
		timer.schedule(new MyTimerTask(list,lock), 0, 2*60*1000);

	}
    
	public void sessionCreated(HttpSessionEvent e) {
		//通过事件对象得到session对象
		HttpSession session=e.getSession();
		// 把创建的session加到集合中来
		synchronized(lock){
			this.list.add(session);
		}
		
        System.out.println("session被创建了！");
	}

	public void sessionDestroyed(HttpSessionEvent e) {
		System.out.println("session被销毁了！");

	}

}
class MyTimerTask extends TimerTask{

	private List<HttpSession> list;
	private Object lock;
	public MyTimerTask(List<HttpSession> list,Object lock){
		this.list=list;
		this.lock=lock;
	}
	@Override
	public void run() {
		//遍历集合，也就是扫描集合
		synchronized(this.lock){
			ListIterator it=list.listIterator();
			while(it.hasNext()){
				HttpSession session=(HttpSession) it.next();
				//判断session是否超过2分钟,用系统的当前时间-session最后被访问的时间
				if(System.currentTimeMillis()-session.getLastAccessedTime()>2*60*1000){
					session.invalidate();
					it.remove();
				}
			}
		}
		
		
	}
	
}

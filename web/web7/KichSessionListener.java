package cn.zdxy.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.zdxy.listener.domain.User;
/**
 * 思路：把用户对象的session放到上下文范围中，并以map类型来存放,
 * map中的key用来保存用户的名称，用户所对应的session对象作为map的值
 * 
 * @author Administrator
 *
 */
public class KichSessionListener implements HttpSessionAttributeListener {

	//当往session域中添加属性-值的映射时，该方法被调用
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 获取到上下文对象
		ServletContext context=se.getSession().getServletContext();
		//查看context上下文域中是否存在map集合，如果不存在表示是第一次被访问
		Map<String,HttpSession> map=(Map<String, HttpSession>) context.getAttribute("map");
        if(map==null){
        	//创建一个map对象
        	map=new HashMap<String,HttpSession>();
        	//把map设置到上下文范围中
        	context.setAttribute("map", map);
        }
        //获取该用户对应的那个session对象
        HttpSession session=se.getSession();
        //获取用户在session中放置的user对象，因为我们是要把用户的名称作为map的key
         //先获取session中添加的值
        Object value=se.getValue();
        if(value instanceof User){
        	//把值强制转化为User
        	User user=(User)value;
        	//把值设置到map中来
        	System.out.println(user.getUsername()+"用户所对象的session："+session+"被加入进来了！");
        	map.put(user.getUsername(), session);
        }
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

}

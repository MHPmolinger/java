package com.neusoft.springmvc.web.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neusoft.springmvc.domain.User;

@Controller
@SessionAttributes(value="user",types={User.class})
public class UserHandler {

	@RequestMapping("/cookieValue")
	public String testCookie(@CookieValue(value="JSESSIONID")String sessionid,Map<String,Object> map){
		
		System.out.println("sessionId="+sessionid);
		map.put("sessionid", sessionid);
		return "info";
	}
	@RequestMapping("/addCookie")
	public String addCookie(HttpServletResponse response){
		Cookie cookie=new Cookie("name","zhangsan");
		cookie.setMaxAge(60*60*5);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "info";
	}
	@RequestMapping("/showCookie")
	public String showCookie(@CookieValue(value="name") String name,@CookieValue(value="pwd",defaultValue="123456")String password,HttpServletRequest request,Map<String,Object> map){
		  map.put("name", name);
		  map.put("password", password);
		  Cookie[] cs=request.getCookies();
		  for(Cookie c:cs){
			  System.out.println(c.getName()+"="+c.getValue());
		  }
		return "info";
	}
	@RequestMapping("/user/add")
	public String addUser(User user,Map<String,Object> map){
		map.put("user", user);
		return "info";
	}
	
	@RequestMapping("/servletApi")
	public void testServletAPI(PrintWriter out,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("张三你好！");
		out.println(new String("你好，用户！".getBytes("iso8859-1"),"utf-8"));
		
	}
	@RequestMapping("/interceptor1")
	public String test5(HttpServletRequest request,Map<String ,Object> map){
		System.out.println("执行目录方法：[UserHandler.test5()");
		map.put("name", "z张三");
		return "info";
	}
}

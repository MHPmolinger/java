package cn.zdxy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import cn.zdxy.dao.UserDao;
import cn.zdxy.domain.User;
import cn.zdxy.utils.WebUtils;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=null;
		UserDao udao=new UserDao();
		//判断用户时候是合法的
		user=udao.findUser(username, password);
		String message="";
		//如果用户为空，表示用户名或密码错误
		if(user==null){
			message="用户名或密码错误！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		}
		//如果用户是合法的，把用户信息保存到session会话中
		request.getSession().setAttribute("user", user);
		try{
			//创建cookie,为了安全起见我们把用户名，用户的有效时间进行加密，
			int loginExpiresTime=Integer.parseInt(request.getParameter("loginExpiressTime"));
			long time=System.currentTimeMillis()+loginExpiresTime*1000;
			String mima=WebUtils.md5(username, time, password);
			String userinfo=username+":"+time+":"+mima;
			Cookie cookie=new Cookie("autologinCookie",userinfo);
			//设置cookie的有效时间
			cookie.setMaxAge(loginExpiresTime);
			//设置cookie的访问路径
			cookie.setPath(request.getContextPath());//也就是javaweb_day13
			//把cookie加入到response对象中一并发送到客户端
			response.addCookie(cookie);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		//把请求转发到message页面上来
		request.setAttribute("message", "登录成功！");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}

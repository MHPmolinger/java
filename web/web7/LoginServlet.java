package cn.zdxy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zdxy.listener.domain.User;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取用户的输入，并把用户信息封装到一个实体对象中来
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		if(null!=username && null!=password){
			User user=new User(username,password);
			//把合法的用户登录添加到会话session中来
			request.getSession().setAttribute("user", user);
		}
		
		//请求转发到index.jsp页面上来！
		request.getRequestDispatcher("/kich/index.jsp").forward(request, response);
		
	}

}

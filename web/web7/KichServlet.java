package cn.zdxy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
public class KichServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//先获取到用户传递过来的username
		String username=request.getParameter("username").trim();
		if(username!=null){
			//要到上下文中去找对象的key所对象的session
			ServletContext context=request.getSession().getServletContext();
			//获取上下文域中的map
			Map<String,HttpSession> map=(Map<String, HttpSession>) context.getAttribute("map");
			if(map!=null){
				//获取到那个session
				HttpSession session=map.get(username);
				//让session失效
				session.invalidate();
				//并把该session在上下文域中移除
				map.remove(username);
				
			}
		}
		//请求重定向到listuser.jsp页面
		response.sendRedirect("/javaweb_day14/kich/listuser.jsp");
		
	}

}

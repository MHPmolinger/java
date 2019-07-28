package cn.neusoft.usermanager.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
//		Enumeration<String> headers=request.getHeaderNames();
//		out.println("1.request.getHeaderNames():<br>");
//		while(headers.hasMoreElements()){
//			String headerName=headers.nextElement();
//			String value=request.getHeader(headerName);
//			out.println("------"+headerName+":="+value+"<br>");
//		}
//		String methodName=request.getMethod();
//		out.println("<br>2.request.getMethod():="+methodName+"<br>");
//		out.println("3.request.getContextPath():="+request.getContextPath()+"<br>");
//		out.println("4.request.getQueryString():="+request.getQueryString()+"<br>");
//		out.println("5.request.getRequestURI():="+request.getRequestURI()+"<br>");
//		out.println("6.request.getRequestURL():="+request.getRequestURL()+"<br>");
//		out.println("7.request.getServletPath():="+request.getServletPath()+"<br>");
		String requestPath=request.getRequestURI();
		if(requestPath.endsWith("/add")){
			out.println("表示添加用户操作");
			String name=request.getParameter("name");
			String method=request.getMethod();
			if("POST".equals(method)){
				out.println("name:="+name);
			}else if("GET".equals(method)){
				//要做硬编码操作
				name=new String(name.getBytes("iso8859-1"),"utf-8");
				out.println("name:="+name);
			}
			
			//目前主流的web层的框架有：Struts1.x,Struts2.x,SpringMVC
		}else if(requestPath.endsWith("/find")){
			out.println("表示查询用户操作");
		}else if(requestPath.endsWith("/delete")){
			out.println("表示删除用户操作");
		}else if(requestPath.endsWith("/update")){
			out.println("表示修改用户操作");
		}
	}

	
}
